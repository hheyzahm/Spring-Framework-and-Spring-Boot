package springFrameworkSpringBoot.S10DataValidation.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import springFrameworkSpringBoot.S10DataValidation.Model.CustomerDTOS10;
import springFrameworkSpringBoot.S10DataValidation.mappers.CustomerMapperS10;
import springFrameworkSpringBoot.S10DataValidation.repositories.CustomerRepositoryS10;

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
public class CustomerServiceS10JPA implements CustomerServiceS10 {
    private final CustomerRepositoryS10 customerRepository;
    private final CustomerMapperS10 customerMapper;

    @Override
    public Optional<CustomerDTOS10> getCustomerById(UUID uuid) {
        return Optional.ofNullable(customerMapper
                .customerEntityToCustomerDTO(customerRepository.findById(uuid).orElse(null)));
    }

    @Override
    public List<CustomerDTOS10> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::customerEntityToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTOS10 saveNewCustomer(CustomerDTOS10 customer) {
        return customerMapper.customerEntityToCustomerDTO(customerRepository
                .save(customerMapper.customerDTOtoCustomerEntity(customer)));
    }

    @Override
    public Optional<CustomerDTOS10> updateCustomerById(UUID customerId, CustomerDTOS10 customer) {
        AtomicReference<Optional<CustomerDTOS10>> atomicReference = new AtomicReference<>();

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
    public Optional<CustomerDTOS10> patchCustomerById(UUID customerId, CustomerDTOS10 customer) {
        AtomicReference<Optional<CustomerDTOS10>> atomicReference = new AtomicReference<>();

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
