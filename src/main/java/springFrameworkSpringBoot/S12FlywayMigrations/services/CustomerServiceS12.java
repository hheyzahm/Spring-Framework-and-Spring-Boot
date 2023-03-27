package springFrameworkSpringBoot.S12FlywayMigrations.services;





import springFrameworkSpringBoot.S12FlywayMigrations.Model.CustomerDTOS12;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:55 PM
 * @Author Hazeem Hassan
 */
public interface CustomerServiceS12 {
    Optional<CustomerDTOS12> getCustomerById(UUID uuid);

    List<CustomerDTOS12> getAllCustomers();

    CustomerDTOS12 saveNewCustomer(CustomerDTOS12 customer);

    Optional<CustomerDTOS12> updateCustomerById(UUID customerId, CustomerDTOS12 customer);

    Boolean deleteCustomerById(UUID customerId);

    Optional<CustomerDTOS12> patchCustomerById(UUID customerId, CustomerDTOS12 customer);

}
