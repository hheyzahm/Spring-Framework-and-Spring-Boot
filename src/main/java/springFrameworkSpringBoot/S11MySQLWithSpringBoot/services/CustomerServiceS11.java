package springFrameworkSpringBoot.S11MySQLWithSpringBoot.services;


import springFrameworkSpringBoot.S11MySQLWithSpringBoot.Model.CustomerDTOS11;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:55 PM
 * @Author Hazeem Hassan
 */
public interface CustomerServiceS11 {
    Optional<CustomerDTOS11> getCustomerById(UUID uuid);

    List<CustomerDTOS11> getAllCustomers();

    CustomerDTOS11 saveNewCustomer(CustomerDTOS11 customer);

    Optional<CustomerDTOS11> updateCustomerById(UUID customerId, CustomerDTOS11 customer);

    Boolean deleteCustomerById(UUID customerId);

    Optional<CustomerDTOS11> patchCustomerById(UUID customerId, CustomerDTOS11 customer);

}
