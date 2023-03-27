package springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.services;

import org.springframework.util.StringUtils;
import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.Model.CustomerDTOS14;

import java.time.LocalDateTime;
import java.util.*;

public class CustomerServiceS14Impl implements CustomerServiceS14 {

    private Map<UUID, CustomerDTOS14> customerMap;

    public CustomerServiceS14Impl() {
        CustomerDTOS14 customer1 = CustomerDTOS14.builder()
                .id(UUID.randomUUID())
                .name("Customer 1")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerDTOS14 customer2 = CustomerDTOS14.builder()
                .id(UUID.randomUUID())
                .name("Customer 2")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerDTOS14 customer3 = CustomerDTOS14.builder()
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
    public Optional<CustomerDTOS14> patchCustomerById(UUID customerId, CustomerDTOS14 customer) {
        CustomerDTOS14 existing = customerMap.get(customerId);

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
    public Optional<CustomerDTOS14> updateCustomerById(UUID customerId, CustomerDTOS14 customer) {
        CustomerDTOS14 existing = customerMap.get(customerId);
        existing.setName(customer.getName());
        return Optional.of(existing);
    }

    @Override
    public CustomerDTOS14 saveNewCustomer(CustomerDTOS14 customer) {

        CustomerDTOS14 savedCustomer = CustomerDTOS14.builder()
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
    public Optional<CustomerDTOS14> getCustomerById(UUID uuid) {
        return Optional.of(customerMap.get(uuid));
    }

    @Override
    public List<CustomerDTOS14> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }
}

