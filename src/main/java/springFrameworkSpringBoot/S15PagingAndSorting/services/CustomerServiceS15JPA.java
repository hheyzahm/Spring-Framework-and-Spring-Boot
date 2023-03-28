package springFrameworkSpringBoot.S15PagingAndSorting.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import springFrameworkSpringBoot.S15PagingAndSorting.Model.CustomerDTOS15;
import springFrameworkSpringBoot.S15PagingAndSorting.mappers.CustomerMapperS15;
import springFrameworkSpringBoot.S15PagingAndSorting.repositories.CustomerRepositoryS15;

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
public class CustomerServiceS15JPA implements CustomerServiceS15 {
    private final CustomerRepositoryS15 customerRepository;
    private final CustomerMapperS15 customerMapper;

    @Override
    public Optional<CustomerDTOS15> getCustomerById(UUID uuid) {
        return Optional.ofNullable(customerMapper
                .customerEntityToCustomerDTO(customerRepository.findById(uuid).orElse(null)));
    }

    @Override
    public List<CustomerDTOS15> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::customerEntityToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTOS15 saveNewCustomer(CustomerDTOS15 customer) {
        return customerMapper.customerEntityToCustomerDTO(customerRepository
                .save(customerMapper.customerDTOtoCustomerEntity(customer)));
    }

    @Override
    public Optional<CustomerDTOS15> updateCustomerById(UUID customerId, CustomerDTOS15 customer) {
        AtomicReference<Optional<CustomerDTOS15>> atomicReference = new AtomicReference<>();

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
    public Optional<CustomerDTOS15> patchCustomerById(UUID customerId, CustomerDTOS15 customer) {
        AtomicReference<Optional<CustomerDTOS15>> atomicReference = new AtomicReference<>();

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
