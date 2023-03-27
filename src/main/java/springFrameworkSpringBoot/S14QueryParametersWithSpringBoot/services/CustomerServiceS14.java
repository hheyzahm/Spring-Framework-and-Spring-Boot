package springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.services;



import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.Model.CustomerDTOS14;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:55 PM
 * @Author Hazeem Hassan
 */
public interface CustomerServiceS14 {
    Optional<CustomerDTOS14> getCustomerById(UUID uuid);

    List<CustomerDTOS14> getAllCustomers();

    CustomerDTOS14 saveNewCustomer(CustomerDTOS14 customer);

    Optional<CustomerDTOS14> updateCustomerById(UUID customerId, CustomerDTOS14 customer);

    Boolean deleteCustomerById(UUID customerId);

    Optional<CustomerDTOS14> patchCustomerById(UUID customerId, CustomerDTOS14 customer);

}
