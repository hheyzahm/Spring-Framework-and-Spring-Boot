package springFrameworkSpringBoot.S7MockMVC.services;



import springFrameworkSpringBoot.S7MockMVC.Model.CustomerS7;

import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:55 PM
 * @Author Hazeem Hassan
 */
public interface CustomerServiceS7 {

    CustomerS7 getCustomerById(UUID uuid);

    List<CustomerS7> getAllCustomers();

    CustomerS7 saveNewCustomer(CustomerS7 customerS7);

    void updateCustomerById(UUID customerId, CustomerS7 customerS7);

    void deleteCustomerById(UUID customerId);
}
