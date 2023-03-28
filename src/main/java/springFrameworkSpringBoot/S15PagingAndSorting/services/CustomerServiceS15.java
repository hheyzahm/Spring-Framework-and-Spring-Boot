package springFrameworkSpringBoot.S15PagingAndSorting.services;



import springFrameworkSpringBoot.S15PagingAndSorting.Model.CustomerDTOS15;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:55 PM
 * @Author Hazeem Hassan
 */
public interface CustomerServiceS15 {
    Optional<CustomerDTOS15> getCustomerById(UUID uuid);

    List<CustomerDTOS15> getAllCustomers();

    CustomerDTOS15 saveNewCustomer(CustomerDTOS15 customer);

    Optional<CustomerDTOS15> updateCustomerById(UUID customerId, CustomerDTOS15 customer);

    Boolean deleteCustomerById(UUID customerId);

    Optional<CustomerDTOS15> patchCustomerById(UUID customerId, CustomerDTOS15 customer);

}
