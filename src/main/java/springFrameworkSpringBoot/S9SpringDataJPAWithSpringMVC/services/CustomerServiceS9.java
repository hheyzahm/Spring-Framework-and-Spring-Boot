package springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.services;



import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.Model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:55 PM
 * @Author Hazeem Hassan
 */
public interface CustomerServiceS9 {
    Optional<CustomerDTO> getCustomerById(UUID uuid);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO saveNewCustomer(CustomerDTO customer);

    void updateCustomerById(UUID customerId, CustomerDTO customer);

    void deleteCustomerById(UUID customerId);

    void patchCustomerById(UUID customerId, CustomerDTO customer);
}
