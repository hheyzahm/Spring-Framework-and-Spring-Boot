package springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.Entities.BeerEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class BeerRepositoryS9Test {
    @Autowired
    BeerRepositoryS9 beerRepository;

    @Test
    void testSaveBeer() {
        BeerEntity savedBeer = beerRepository.save(BeerEntity.builder()
                .beerName("My Beer")
                .build());

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }
}