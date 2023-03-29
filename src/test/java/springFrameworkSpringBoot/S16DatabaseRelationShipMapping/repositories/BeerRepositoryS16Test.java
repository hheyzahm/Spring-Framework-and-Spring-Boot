package springFrameworkSpringBoot.S16DatabaseRelationShipMapping.repositories;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import springFrameworkSpringBoot.BeerStyle;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.bootStrap.BootstrapDataS16;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.entities.BeerEntityS16;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.services.BeerCsvServiceS16Impl;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@Import({BootstrapDataS16.class, BeerCsvServiceS16Impl.class})
class BeerRepositoryS16Test {

    @Autowired
    BeerRepositoryS16 beerRepository;

    @Test
    void testGetBeerListByName() {
    Page<BeerEntityS16> list = beerRepository.findAllByBeerNameIsLikeIgnoreCase("%IPA%", null);

        assertThat(list.getContent().size()).isEqualTo(336);
    }

    @Test
    void testSaveBeerNameTooLong() {

        assertThrows(ConstraintViolationException.class, () -> {
            BeerEntityS16 savedBeer = beerRepository.save(BeerEntityS16.builder()
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
        BeerEntityS16 savedBeer = beerRepository.save(BeerEntityS16.builder()
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