package springFrameworkSpringBoot.S6SpringMVC.services;

import org.springframework.stereotype.Service;
import springFrameworkSpringBoot.S6SpringMVC.Model.CustomerS6;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @Created 17 03 2023 - 5:56 PM
 * @Author Hazeem Hassan
 */
@Service
public class CustomerServiceS6Impl implements CustomerServiceS6 {

    private Map<UUID, CustomerS6> customerMap;

    public CustomerServiceS6Impl() {
        CustomerS6 customerS61 = CustomerS6.builder()
                .id(UUID.randomUUID())
                .name("Customer 1")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerS6 customerS62 = CustomerS6.builder()
                .id(UUID.randomUUID())
                .name("Customer 2")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerS6 customerS63 = CustomerS6.builder()
                .id(UUID.randomUUID())
                .name("Customer 3")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        customerMap = new HashMap<>();
        customerMap.put(customerS61.getId(), customerS61);
        customerMap.put(customerS62.getId(), customerS62);
        customerMap.put(customerS63.getId(), customerS63);
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        customerMap.remove(customerId);
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerS6 customerS6) {
        CustomerS6 existing = customerMap.get(customerId);
        existing.setName(customerS6.getName());
    }

    @Override
    public CustomerS6 saveNewCustomer(CustomerS6 customerS6) {

        CustomerS6 savedCustomerS6 = CustomerS6.builder()
                .id(UUID.randomUUID())
                .version(1)
                .updateDate(LocalDateTime.now())
                .createdDate(LocalDateTime.now())
                .name(customerS6.getName())
                .build();

        customerMap.put(savedCustomerS6.getId(), savedCustomerS6);

        return savedCustomerS6;
    }

    @Override
    public CustomerS6 getCustomerById(UUID uuid) {
        return customerMap.get(uuid);
    }

    @Override
    public List<CustomerS6> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }
}
