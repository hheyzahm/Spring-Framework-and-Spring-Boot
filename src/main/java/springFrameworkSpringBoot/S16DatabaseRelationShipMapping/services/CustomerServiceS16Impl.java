package springFrameworkSpringBoot.S16DatabaseRelationShipMapping.services;

import org.springframework.util.StringUtils;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.Model.CustomerDTOS16;

import java.time.LocalDateTime;
import java.util.*;

public class CustomerServiceS16Impl implements CustomerServiceS16 {

    private Map<UUID, CustomerDTOS16> customerMap;

    public CustomerServiceS16Impl() {
        CustomerDTOS16 customer1 = CustomerDTOS16.builder()
                .id(UUID.randomUUID())
                .name("Customer 1")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerDTOS16 customer2 = CustomerDTOS16.builder()
                .id(UUID.randomUUID())
                .name("Customer 2")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerDTOS16 customer3 = CustomerDTOS16.builder()
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
    public Optional<CustomerDTOS16> patchCustomerById(UUID customerId, CustomerDTOS16 customer) {
        CustomerDTOS16 existing = customerMap.get(customerId);

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
    public Optional<CustomerDTOS16> updateCustomerById(UUID customerId, CustomerDTOS16 customer) {
        CustomerDTOS16 existing = customerMap.get(customerId);
        existing.setName(customer.getName());
        return Optional.of(existing);
    }

    @Override
    public CustomerDTOS16 saveNewCustomer(CustomerDTOS16 customer) {

        CustomerDTOS16 savedCustomer = CustomerDTOS16.builder()
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
    public Optional<CustomerDTOS16> getCustomerById(UUID uuid) {
        return Optional.of(customerMap.get(uuid));
    }

    @Override
    public List<CustomerDTOS16> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }
}

