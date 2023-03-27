package springFrameworkSpringBoot.S12FlywayMigrations.services;

import org.springframework.util.StringUtils;
import springFrameworkSpringBoot.S12FlywayMigrations.Model.CustomerDTOS12;


import java.time.LocalDateTime;
import java.util.*;

public class CustomerServiceS12Impl implements CustomerServiceS12 {

    private Map<UUID, CustomerDTOS12> customerMap;

    public CustomerServiceS12Impl() {
        CustomerDTOS12 customer1 = CustomerDTOS12.builder()
                .id(UUID.randomUUID())
                .name("Customer 1")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerDTOS12 customer2 = CustomerDTOS12.builder()
                .id(UUID.randomUUID())
                .name("Customer 2")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerDTOS12 customer3 = CustomerDTOS12.builder()
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
    public Optional<CustomerDTOS12> patchCustomerById(UUID customerId, CustomerDTOS12 customer) {
        CustomerDTOS12 existing = customerMap.get(customerId);

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
    public Optional<CustomerDTOS12> updateCustomerById(UUID customerId, CustomerDTOS12 customer) {
        CustomerDTOS12 existing = customerMap.get(customerId);
        existing.setName(customer.getName());
        return Optional.of(existing);
    }

    @Override
    public CustomerDTOS12 saveNewCustomer(CustomerDTOS12 customer) {

        CustomerDTOS12 savedCustomer = CustomerDTOS12.builder()
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
    public Optional<CustomerDTOS12> getCustomerById(UUID uuid) {
        return Optional.of(customerMap.get(uuid));
    }

    @Override
    public List<CustomerDTOS12> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }
}

