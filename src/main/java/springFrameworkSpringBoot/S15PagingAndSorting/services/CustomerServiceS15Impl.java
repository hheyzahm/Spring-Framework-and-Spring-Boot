package springFrameworkSpringBoot.S15PagingAndSorting.services;

import org.springframework.util.StringUtils;
import springFrameworkSpringBoot.S15PagingAndSorting.Model.CustomerDTOS15;

import java.time.LocalDateTime;
import java.util.*;

public class CustomerServiceS15Impl implements CustomerServiceS15 {

    private Map<UUID, CustomerDTOS15> customerMap;

    public CustomerServiceS15Impl() {
        CustomerDTOS15 customer1 = CustomerDTOS15.builder()
                .id(UUID.randomUUID())
                .name("Customer 1")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerDTOS15 customer2 = CustomerDTOS15.builder()
                .id(UUID.randomUUID())
                .name("Customer 2")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerDTOS15 customer3 = CustomerDTOS15.builder()
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
    public Optional<CustomerDTOS15> patchCustomerById(UUID customerId, CustomerDTOS15 customer) {
        CustomerDTOS15 existing = customerMap.get(customerId);

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
    public Optional<CustomerDTOS15> updateCustomerById(UUID customerId, CustomerDTOS15 customer) {
        CustomerDTOS15 existing = customerMap.get(customerId);
        existing.setName(customer.getName());
        return Optional.of(existing);
    }

    @Override
    public CustomerDTOS15 saveNewCustomer(CustomerDTOS15 customer) {

        CustomerDTOS15 savedCustomer = CustomerDTOS15.builder()
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
    public Optional<CustomerDTOS15> getCustomerById(UUID uuid) {
        return Optional.of(customerMap.get(uuid));
    }

    @Override
    public List<CustomerDTOS15> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }
}

