package springFrameworkSpringBoot.S16DatabaseRelationShipMapping.bootStrap;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.repositories.BeerRepositoryS16;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.repositories.CustomerRepositoryS16;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.services.BeerCsvServiceS16;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.services.BeerCsvServiceS16Impl;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@Import(BeerCsvServiceS16Impl.class)
class BootstrapDataS16Test {
    @Autowired
    BeerRepositoryS16 beerRepository;

    @Autowired
    CustomerRepositoryS16 customerRepository;

    @Autowired
    BeerCsvServiceS16 csvService;

    BootstrapDataS16 bootstrapData;

    @BeforeEach
    void setUp() {
        bootstrapData = new BootstrapDataS16(beerRepository, customerRepository, csvService);
    }

    @Test
    void Testrun() throws Exception {
        bootstrapData.run(null);

        assertThat(beerRepository.count()).isEqualTo(2413);
        assertThat(customerRepository.count()).isEqualTo(3);
    }
}