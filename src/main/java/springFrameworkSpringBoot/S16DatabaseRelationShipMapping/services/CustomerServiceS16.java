package springFrameworkSpringBoot.S16DatabaseRelationShipMapping.services;

import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.Model.CustomerDTOS16;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:55 PM
 * @Author Hazeem Hassan
 */
public interface CustomerServiceS16 {
    Optional<CustomerDTOS16> getCustomerById(UUID uuid);

    List<CustomerDTOS16> getAllCustomers();

    CustomerDTOS16 saveNewCustomer(CustomerDTOS16 customer);

    Optional<CustomerDTOS16> updateCustomerById(UUID customerId, CustomerDTOS16 customer);

    Boolean deleteCustomerById(UUID customerId);

    Optional<CustomerDTOS16> patchCustomerById(UUID customerId, CustomerDTOS16 customer);

}
