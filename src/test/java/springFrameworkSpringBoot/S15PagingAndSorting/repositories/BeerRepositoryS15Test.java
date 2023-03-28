package springFrameworkSpringBoot.S15PagingAndSorting.repositories;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import springFrameworkSpringBoot.BeerStyle;
import springFrameworkSpringBoot.S15PagingAndSorting.bootStrap.BootstrapDataS15;
import springFrameworkSpringBoot.S15PagingAndSorting.entities.BeerEntityS15;
import springFrameworkSpringBoot.S15PagingAndSorting.services.BeerCsvServiceS15Impl;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DataJpaTest
@Import({BootstrapDataS15.class, BeerCsvServiceS15Impl.class})
class BeerRepositoryS15Test {

    @Autowired
    BeerRepositoryS15 beerRepository;

    @Test
    void testGetBeerListByName() {
        Page<BeerEntityS15> list = beerRepository.findAllByBeerNameIsLikeIgnoreCase("%IPA%", null);

        assertThat(list.getContent().size()).isEqualTo(336);
    }

    @Test
    void testSaveBeerNameTooLong() {

        assertThrows(ConstraintViolationException.class, () -> {
            BeerEntityS15 savedBeer = beerRepository.save(BeerEntityS15.builder()
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
        BeerEntityS15 savedBeer = beerRepository.save(BeerEntityS15.builder()
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