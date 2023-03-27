package springFrameworkSpringBoot.S10DataValidation.repositories;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import springFrameworkSpringBoot.S10DataValidation.Model.BeerStyleS10;
import springFrameworkSpringBoot.S10DataValidation.entities.BeerEntityS10;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class BeerRepositoryS10Test {
    @Autowired
    BeerRepositoryS10 beerRepository;

    @Test
    void testSaveBeerNameTooLong() {

        assertThrows(ConstraintViolationException.class, () -> {
            BeerEntityS10 savedBeer = beerRepository.save(BeerEntityS10.builder()
                    .beerName("My Beer 0123345678901233456789012334567890123345678901233456789012334567890123345678901233456789")
                    .beerStyle(BeerStyleS10.PALE_ALE)
                    .upc("234234234234")
                    .price(new BigDecimal("11.99"))
                    .build());

            beerRepository.flush();
        });
    }

    @Test
    void testSaveBeer() {
        BeerEntityS10 savedBeer = beerRepository.save(BeerEntityS10.builder()
                .beerName("My Beer")
                .beerStyle(BeerStyleS10.PALE_ALE)
                .upc("234234234234")
                .price(new BigDecimal("11.99"))
                .build());

        beerRepository.flush();

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }
}