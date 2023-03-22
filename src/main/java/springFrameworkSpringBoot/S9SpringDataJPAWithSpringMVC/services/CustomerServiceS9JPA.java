package springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.Model.CustomerDTO;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.mappers.CustomerMapper;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.repositories.CustomerRepositoryS9;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        return Optional.empty();
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return null;
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customer) {
        return null;
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerDTO customer) {

    }

    @Override
    public void deleteCustomerById(UUID customerId) {

    }

    @Override
    public void patchCustomerById(UUID customerId, CustomerDTO customer) {

    }
}
