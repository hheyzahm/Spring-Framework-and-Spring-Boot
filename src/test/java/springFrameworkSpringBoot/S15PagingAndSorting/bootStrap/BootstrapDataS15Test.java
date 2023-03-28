package springFrameworkSpringBoot.S15PagingAndSorting.bootStrap;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import springFrameworkSpringBoot.S15PagingAndSorting.repositories.BeerRepositoryS15;
import springFrameworkSpringBoot.S15PagingAndSorting.repositories.CustomerRepositoryS15;
import springFrameworkSpringBoot.S15PagingAndSorting.services.BeerCsvServiceS15;
import springFrameworkSpringBoot.S15PagingAndSorting.services.BeerCsvServiceS15Impl;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(BeerCsvServiceS15Impl.class)
class BootstrapDataS15Test {
    @Autowired
    BeerRepositoryS15 beerRepository;

    @Autowired
    CustomerRepositoryS15 customerRepository;

    @Autowired
    BeerCsvServiceS15 csvService;

    BootstrapDataS15 bootstrapData;

    @BeforeEach
    void setUp() {
        bootstrapData = new BootstrapDataS15(csvService, beerRepository, customerRepository);
    }

    @Test
    void Testrun() throws Exception {
        bootstrapData.run(null);

        assertThat(beerRepository.count()).isEqualTo(2413);
        assertThat(customerRepository.count()).isEqualTo(3);
    }
}