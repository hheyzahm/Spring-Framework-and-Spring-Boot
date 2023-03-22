package springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.bootStrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.repositories.BeerRepositoryS9;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.repositories.CustomerRepositoryS9;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
class BootstrapDataS9Test {
    @Autowired
    BeerRepositoryS9 beerRepository;

    @Autowired
    CustomerRepositoryS9 customerRepository;

    BootstrapDataS9 bootstrapData;

    @BeforeEach
    void setUp() {
        bootstrapData = new BootstrapDataS9(beerRepository, customerRepository);
    }

    @Test
    void Testrun() throws Exception {
        bootstrapData.run(null);

        assertThat(beerRepository.count()).isEqualTo(3);
        assertThat(customerRepository.count()).isEqualTo(3);
    }
}