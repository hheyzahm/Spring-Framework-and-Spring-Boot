package springFrameworkSpringBoot.S16DatabaseRelationShipMapping.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.entities.CustomerEntityS16;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
class CustomerRepositoryS16Test {

    @Autowired
    CustomerRepositoryS16 customerRepository;

    @Test
    void testSaveCustomer() {
        CustomerEntityS16 customer = customerRepository.save(CustomerEntityS16.builder()
                .name("New Name")
                .build());

        assertThat(customer.getId()).isNotNull();

    }
}
