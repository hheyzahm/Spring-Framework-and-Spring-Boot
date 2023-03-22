package springFrameworkSpringBoot.S10DataValidation.bootStrap;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import springFrameworkSpringBoot.S10DataValidation.repositories.BeerRepositoryS10;
import springFrameworkSpringBoot.S10DataValidation.repositories.CustomerRepositoryS10;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BootstrapDataS10Test {
    @Autowired
    BeerRepositoryS10 beerRepository;

    @Autowired
    CustomerRepositoryS10 customerRepository;

    BootstrapDataS10 bootstrapData;

    @BeforeEach
    void setUp() {
        bootstrapData = new BootstrapDataS10(beerRepository, customerRepository);
    }

    @Test
    void Testrun() throws Exception {
        bootstrapData.run(null);

        assertThat(beerRepository.count()).isEqualTo(3);
        assertThat(customerRepository.count()).isEqualTo(3);
    }
}