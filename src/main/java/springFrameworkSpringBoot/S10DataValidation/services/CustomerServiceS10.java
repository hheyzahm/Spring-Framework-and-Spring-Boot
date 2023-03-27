package springFrameworkSpringBoot.S10DataValidation.services;


import springFrameworkSpringBoot.S10DataValidation.Model.CustomerDTOS10;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:55 PM
 * @Author Hazeem Hassan
 */
public interface CustomerServiceS10 {
    Optional<CustomerDTOS10> getCustomerById(UUID uuid);

    List<CustomerDTOS10> getAllCustomers();

    CustomerDTOS10 saveNewCustomer(CustomerDTOS10 customer);

    Optional<CustomerDTOS10> updateCustomerById(UUID customerId, CustomerDTOS10 customer);

    Boolean deleteCustomerById(UUID customerId);

    Optional<CustomerDTOS10> patchCustomerById(UUID customerId, CustomerDTOS10 customer);


}
