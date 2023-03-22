package springFrameworkSpringBoot.S10DataValidation.services;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import springFrameworkSpringBoot.S10DataValidation.Model.CustomerDTOS10;

import java.time.LocalDateTime;
import java.util.*;


/**
 * @Created 17 03 2023 - 5:56 PM
 * @Author Hazeem Hassan
 */
@Service
public class CustomerServiceS10Impl implements CustomerServiceS10 {
    private Map<UUID, CustomerDTOS10> customerMap;

    public CustomerServiceS10Impl() {
        CustomerDTOS10 customer1 = CustomerDTOS10.builder()
                .id(UUID.randomUUID())
                .name("Customer 1")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerDTOS10 customer2 = CustomerDTOS10.builder()
                .id(UUID.randomUUID())
                .name("Customer 2")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerDTOS10 customer3 = CustomerDTOS10.builder()
                .id(UUID.randomUUID())
                .name("Customer 3")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        customerMap = new HashMap<>();
        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
        customerMap.put(customer3.getId(), customer3);
    }

    @Override
    public Optional<CustomerDTOS10> patchCustomerById(UUID customerId, CustomerDTOS10 customer) {
        CustomerDTOS10 existing = customerMap.get(customerId);

        if (StringUtils.hasText(customer.getName())) {
            existing.setName(customer.getName());
        }

        return Optional.of(existing);
    }

    @Override
    public Boolean deleteCustomerById(UUID customerId) {
        customerMap.remove(customerId);

        return true;
    }

    @Override
    public Optional<CustomerDTOS10> updateCustomerById(UUID customerId, CustomerDTOS10 customer) {
        CustomerDTOS10 existing = customerMap.get(customerId);
        existing.setName(customer.getName());
        return Optional.of(existing);
    }

    @Override
    public CustomerDTOS10 saveNewCustomer(CustomerDTOS10 customer) {

        CustomerDTOS10 savedCustomer = CustomerDTOS10.builder()
                .id(UUID.randomUUID())
                .version(1)
                .updateDate(LocalDateTime.now())
                .createdDate(LocalDateTime.now())
                .name(customer.getName())
                .build();

        customerMap.put(savedCustomer.getId(), savedCustomer);

        return savedCustomer;
    }

    @Override
    public Optional<CustomerDTOS10> getCustomerById(UUID uuid) {
        return Optional.of(customerMap.get(uuid));
    }

    @Override
    public List<CustomerDTOS10> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }
}
