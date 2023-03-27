package springFrameworkSpringBoot.S11MySQLWithSpringBoot.services;

import org.springframework.util.StringUtils;
import springFrameworkSpringBoot.S11MySQLWithSpringBoot.Model.CustomerDTOS11;


import java.time.LocalDateTime;
import java.util.*;

public class CustomerServiceS11Impl implements CustomerServiceS11 {

    private Map<UUID, CustomerDTOS11> customerMap;

    public CustomerServiceS11Impl() {
        CustomerDTOS11 customer1 = CustomerDTOS11.builder()
                .id(UUID.randomUUID())
                .name("Customer 1")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerDTOS11 customer2 = CustomerDTOS11.builder()
                .id(UUID.randomUUID())
                .name("Customer 2")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerDTOS11 customer3 = CustomerDTOS11.builder()
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
    public Optional<CustomerDTOS11> patchCustomerById(UUID customerId, CustomerDTOS11 customer) {
        CustomerDTOS11 existing = customerMap.get(customerId);

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
    public Optional<CustomerDTOS11> updateCustomerById(UUID customerId, CustomerDTOS11 customer) {
        CustomerDTOS11 existing = customerMap.get(customerId);
        existing.setName(customer.getName());
        return Optional.of(existing);
    }

    @Override
    public CustomerDTOS11 saveNewCustomer(CustomerDTOS11 customer) {

        CustomerDTOS11 savedCustomer = CustomerDTOS11.builder()
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
    public Optional<CustomerDTOS11> getCustomerById(UUID uuid) {
        return Optional.of(customerMap.get(uuid));
    }

    @Override
    public List<CustomerDTOS11> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }
}

