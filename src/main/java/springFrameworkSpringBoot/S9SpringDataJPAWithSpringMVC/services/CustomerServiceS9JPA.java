package springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.Model.CustomerDTO;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.mappers.CustomerMapper;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.repositories.CustomerRepositoryS9;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @Created 22 03 2023 - 5:31 PM
 * @Author Hazeem Hassan
 */
@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceS9JPA implements CustomerServiceS9 {
    private final CustomerRepositoryS9 customerRepository;
    private final CustomerMapper customerMapper;
    @Override
    public Optional<CustomerDTO> getCustomerById(UUID uuid) {
        return Optional.ofNullable(customerMapper
                .cutomerEnityToCustomerDTO(customerRepository.findById(uuid).orElse(null)));
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::cutomerEnityToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customer) {
        return customerMapper.cutomerEnityToCustomerDTO(customerRepository
                .save(customerMapper.customeerDTOtoCustomerEntity(customer)));
    }

    @Override
    public Optional<CustomerDTO> updateCustomerById(UUID customerId, CustomerDTO customer) {
        AtomicReference<Optional<CustomerDTO>> atomicReference = new AtomicReference<>();

        customerRepository.findById(customerId).ifPresentOrElse(foundCustomer -> {
            foundCustomer.setName(customer.getName());
            atomicReference.set(Optional.of(customerMapper
                    .cutomerEnityToCustomerDTO(customerRepository.save(foundCustomer))));
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
    public Optional<CustomerDTO> patchCustomerById(UUID customerId, CustomerDTO customer) {
        AtomicReference<Optional<CustomerDTO>> atomicReference = new AtomicReference<>();

        customerRepository.findById(customerId).ifPresentOrElse(foundCustomer -> {
            if (StringUtils.hasText(customer.getName())){
                foundCustomer.setName(customer.getName());
            }
            atomicReference.set(Optional.of(customerMapper
                    .cutomerEnityToCustomerDTO(customerRepository.save(foundCustomer))));
        }, () -> {
            atomicReference.set(Optional.empty());
        });

        return atomicReference.get();
    }
}
