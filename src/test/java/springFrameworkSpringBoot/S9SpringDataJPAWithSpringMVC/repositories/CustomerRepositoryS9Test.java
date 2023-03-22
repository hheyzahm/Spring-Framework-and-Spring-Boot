package springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.Entities.CustomerEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CustomerRepositoryS9Test {
    @Autowired
    CustomerRepositoryS9 customerRepository;

    @Test
    void testSaveCustomer() {
        CustomerEntity customer = customerRepository.save(CustomerEntity.builder()
                .name("New Name")
                .build());
        assertThat(customer).isNotNull();
        assertThat(customer.getId()).isNotNull();

    }
}