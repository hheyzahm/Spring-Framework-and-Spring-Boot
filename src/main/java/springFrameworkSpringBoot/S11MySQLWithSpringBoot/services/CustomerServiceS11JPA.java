package springFrameworkSpringBoot.S11MySQLWithSpringBoot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import springFrameworkSpringBoot.S11MySQLWithSpringBoot.Model.CustomerDTOS11;
import springFrameworkSpringBoot.S11MySQLWithSpringBoot.mappers.CustomerMapperS11;
import springFrameworkSpringBoot.S11MySQLWithSpringBoot.repositories.CustomerRepositoryS11;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @Created 20 03 2023 - 12:21 PM
 * @Author Hazeem Hassan
 */
@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceS11JPA implements CustomerServiceS11 {
    private final CustomerRepositoryS11 customerRepository;
    private final CustomerMapperS11 customerMapper;

    @Override
    public Optional<CustomerDTOS11> getCustomerById(UUID uuid) {
        return Optional.ofNullable(customerMapper
                .customerEntityToCustomerDTO(customerRepository.findById(uuid).orElse(null)));
    }

    @Override
    public List<CustomerDTOS11> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::customerEntityToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTOS11 saveNewCustomer(CustomerDTOS11 customer) {
        return customerMapper.customerEntityToCustomerDTO(customerRepository
                .save(customerMapper.customerDTOtoCustomerEntity(customer)));
    }

    @Override
    public Optional<CustomerDTOS11> updateCustomerById(UUID customerId, CustomerDTOS11 customer) {
        AtomicReference<Optional<CustomerDTOS11>> atomicReference = new AtomicReference<>();

        customerRepository.findById(customerId).ifPresentOrElse(foundCustomer -> {
            foundCustomer.setName(customer.getName());
            atomicReference.set(Optional.of(customerMapper
                    .customerEntityToCustomerDTO(customerRepository.save(foundCustomer))));
        }, () -> {
            atomicReference.set(Optional.empty());
        });

        return atomicReference.get();
    }

    @Override
    public Boolean deleteCustomerById(UUID customerId) {
        if(customerRepository.existsById(customerId)){
            customerRepository.deleteById(customerId);
            return true;
        }
        return false;
    }

    @Override
    public Optional<CustomerDTOS11> patchCustomerById(UUID customerId, CustomerDTOS11 customer) {
        AtomicReference<Optional<CustomerDTOS11>> atomicReference = new AtomicReference<>();

        customerRepository.findById(customerId).ifPresentOrElse(foundCustomer -> {
            if (StringUtils.hasText(customer.getName())){
                foundCustomer.setName(customer.getName());
            }
            atomicReference.set(Optional.of(customerMapper
                    .customerEntityToCustomerDTO(customerRepository.save(foundCustomer))));
        }, () -> {
            atomicReference.set(Optional.empty());
        });

        return atomicReference.get();
    }
}
