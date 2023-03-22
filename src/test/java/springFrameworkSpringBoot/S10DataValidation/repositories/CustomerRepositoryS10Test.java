package springFrameworkSpringBoot.S10DataValidation.repositories;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import springFrameworkSpringBoot.S10DataValidation.entities.CustomerEntityS10;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CustomerRepositoryS10Test {
    @Autowired
    CustomerRepositoryS10 customerRepository;

    @Test
    void testSaveCustomer() {
        CustomerEntityS10 customer = customerRepository.save(CustomerEntityS10.builder()
                .name("New Name")
                .build());

        assertThat(customer.getId()).isNotNull();

    }
}