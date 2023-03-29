package springFrameworkSpringBoot.S16DatabaseRelationShipMapping.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.Model.CustomerDTOS16;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.mappers.CustomerMapperS16;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.repositories.CustomerRepositoryS16;


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
public class CustomerServiceS16JPA implements CustomerServiceS16 {
    private final CustomerRepositoryS16 customerRepository;
    private final CustomerMapperS16 customerMapper;

    @Override
    public Optional<CustomerDTOS16> getCustomerById(UUID uuid) {
        return Optional.ofNullable(customerMapper
                .customerEntityToCustomerDTO(customerRepository.findById(uuid).orElse(null)));
    }

    @Override
    public List<CustomerDTOS16> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::customerEntityToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTOS16 saveNewCustomer(CustomerDTOS16 customer) {
        return customerMapper.customerEntityToCustomerDTO(customerRepository
                .save(customerMapper.customerDTOtoCustomerEntity(customer)));
    }

    @Override
    public Optional<CustomerDTOS16> updateCustomerById(UUID customerId, CustomerDTOS16 customer) {
        AtomicReference<Optional<CustomerDTOS16>> atomicReference = new AtomicReference<>();

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
    public Optional<CustomerDTOS16> patchCustomerById(UUID customerId, CustomerDTOS16 customer) {
        AtomicReference<Optional<CustomerDTOS16>> atomicReference = new AtomicReference<>();

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
