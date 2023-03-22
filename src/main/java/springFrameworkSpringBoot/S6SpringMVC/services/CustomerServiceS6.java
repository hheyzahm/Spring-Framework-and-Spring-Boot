package springFrameworkSpringBoot.S6SpringMVC.services;



import springFrameworkSpringBoot.S6SpringMVC.Model.CustomerS6;

import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:55 PM
 * @Author Hazeem Hassan
 */
public interface CustomerServiceS6 {

    CustomerS6 getCustomerById(UUID uuid);

    List<CustomerS6> getAllCustomers();

    CustomerS6 saveNewCustomer(CustomerS6 customerS6);

    void updateCustomerById(UUID customerId, CustomerS6 customerS6);

    void deleteCustomerById(UUID customerId);
}
