package springFrameworkSpringBoot.S12FlywayMigrations.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import springFrameworkSpringBoot.S12FlywayMigrations.Model.CustomerDTOS12;
import springFrameworkSpringBoot.S12FlywayMigrations.mappers.CustomerMapperS12;
import springFrameworkSpringBoot.S12FlywayMigrations.repositories.CustomerRepositoryS12;


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
public class CustomerServiceS12JPA implements CustomerServiceS12 {
    private final CustomerRepositoryS12 customerRepository;
    private final CustomerMapperS12 customerMapper;

    @Override
    public Optional<CustomerDTOS12> getCustomerById(UUID uuid) {
        return Optional.ofNullable(customerMapper
                .customerEntityToCustomerDTO(customerRepository.findById(uuid).orElse(null)));
    }

    @Override
    public List<CustomerDTOS12> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::customerEntityToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTOS12 saveNewCustomer(CustomerDTOS12 customer) {
        return customerMapper.customerEntityToCustomerDTO(customerRepository
                .save(customerMapper.customerDTOtoCustomerEntity(customer)));
    }

    @Override
    public Optional<CustomerDTOS12> updateCustomerById(UUID customerId, CustomerDTOS12 customer) {
        AtomicReference<Optional<CustomerDTOS12>> atomicReference = new AtomicReference<>();

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
    public Optional<CustomerDTOS12> patchCustomerById(UUID customerId, CustomerDTOS12 customer) {
        AtomicReference<Optional<CustomerDTOS12>> atomicReference = new AtomicReference<>();

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
