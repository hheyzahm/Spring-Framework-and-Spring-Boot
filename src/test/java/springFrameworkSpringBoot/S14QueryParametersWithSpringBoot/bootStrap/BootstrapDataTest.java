package springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.bootStrap;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.repositories.BeerRepositoryS14;
import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.repositories.CustomerRepositoryS14;
import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.services.BeerCsvServiceS14;
import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.services.BeerCsvServiceS14Impl;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@Import(BeerCsvServiceS14Impl.class)
class BootstrapDataTest {
    @Autowired
    BeerRepositoryS14 beerRepository;

    @Autowired
    CustomerRepositoryS14 customerRepository;

    @Autowired
    BeerCsvServiceS14 csvService;

    BootstrapDataS14 bootstrapData;

    @BeforeEach
    void setUp() {
        bootstrapData = new BootstrapDataS14(csvService, beerRepository, customerRepository);
    }

    @Test
    void Testrun() throws Exception {
        bootstrapData.run(null);

        assertThat(beerRepository.count()).isEqualTo(2413);
        assertThat(customerRepository.count()).isEqualTo(3);
    }
}