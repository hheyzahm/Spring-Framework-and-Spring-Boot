package springFrameworkSpringBoot.S7MockMVC.services;

import org.springframework.stereotype.Service;
import springFrameworkSpringBoot.S7MockMVC.Model.CustomerS7;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @Created 17 03 2023 - 5:56 PM
 * @Author Hazeem Hassan
 */
@Service
public class CustomerServiceS7Impl implements CustomerServiceS7 {

    private Map<UUID, CustomerS7> customerMap;

    public CustomerServiceS7Impl() {
        CustomerS7 customerS71 = CustomerS7.builder()
                .id(UUID.randomUUID())
                .name("Customer 1")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerS7 customerS72 = CustomerS7.builder()
                .id(UUID.randomUUID())
                .name("Customer 2")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerS7 customerS73 = CustomerS7.builder()
                .id(UUID.randomUUID())
                .name("Customer 3")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        customerMap = new HashMap<>();
        customerMap.put(customerS71.getId(), customerS71);
        customerMap.put(customerS72.getId(), customerS72);
        customerMap.put(customerS73.getId(), customerS73);
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        customerMap.remove(customerId);
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerS7 customerS7) {
        CustomerS7 existing = customerMap.get(customerId);
        existing.setName(customerS7.getName());
    }

    @Override
    public CustomerS7 saveNewCustomer(CustomerS7 customerS7) {

        CustomerS7 savedCustomerS7 = CustomerS7.builder()
                .id(UUID.randomUUID())
                .version(1)
                .updateDate(LocalDateTime.now())
                .createdDate(LocalDateTime.now())
                .name(customerS7.getName())
                .build();

        customerMap.put(savedCustomerS7.getId(), savedCustomerS7);

        return savedCustomerS7;
    }

    @Override
    public CustomerS7 getCustomerById(UUID uuid) {
        return customerMap.get(uuid);
    }

    @Override
    public List<CustomerS7> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }
}
