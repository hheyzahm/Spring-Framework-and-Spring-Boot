package springFrameworkSpringBoot.S13OpenCSV.bootStrap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import springFrameworkSpringBoot.S12FlywayMigrations.repositories.CustomerRepositoryS12;
import springFrameworkSpringBoot.S13OpenCSV.repository.BeerRepositoryS13;
import springFrameworkSpringBoot.S13OpenCSV.service.BeerCsvService;
import springFrameworkSpringBoot.S13OpenCSV.service.BeerCsvServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(BeerCsvServiceImpl.class)
class BootstrapDataS13Test {
    @Autowired
    BeerRepositoryS13 beerRepository;

    @Autowired
    CustomerRepositoryS12 customerRepository;

    @Autowired
    BeerCsvService csvService;

    BootstrapDataS13 bootstrapData;

    @BeforeEach
    void setUp() {
        bootstrapData = new BootstrapDataS13(csvService, beerRepository, customerRepository);
    }

    @Test
    void Testrun() throws Exception {
        bootstrapData.run(null);

        assertThat(beerRepository.count()).isEqualTo(2413);
        assertThat(customerRepository.count()).isEqualTo(3);
    }
}