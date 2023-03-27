package springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.repositories;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import springFrameworkSpringBoot.BeerStyle;
import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.bootStrap.BootstrapDataS14;
import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.entities.BeerEntityS14;
import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.services.BeerCsvServiceS14Impl;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@Import({BootstrapDataS14.class, BeerCsvServiceS14Impl.class})
class BeerRepositoryS14Test {

    @Autowired
    BeerRepositoryS14 beerRepository;

    @Test
    void testGetBeerListByName() {
        List<BeerEntityS14> list = beerRepository.findAllByBeerNameIsLikeIgnoreCase("%IPA%");

        assertThat(list.size()).isEqualTo(336);
    }

    @Test
    void testSaveBeerNameTooLong() {

        assertThrows(ConstraintViolationException.class, () -> {
            BeerEntityS14 savedBeer = beerRepository.save(BeerEntityS14.builder()
                    .beerName("My Beer 0123345678901233456789012334567890123345678901233456789012334567890123345678901233456789")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("234234234234")
                    .price(new BigDecimal("11.99"))
                    .build());

            beerRepository.flush();
        });
    }

    @Test
    void testSaveBeer() {
        BeerEntityS14 savedBeer = beerRepository.save(BeerEntityS14.builder()
                .beerName("My Beer")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("234234234234")
                .price(new BigDecimal("11.99"))
                .build());

        beerRepository.flush();

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }
}