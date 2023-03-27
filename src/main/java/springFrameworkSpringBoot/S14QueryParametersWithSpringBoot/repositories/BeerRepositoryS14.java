package springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springFrameworkSpringBoot.BeerStyle;

import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.entities.BeerEntityS14;


import java.util.List;
import java.util.UUID;

/**
 * @Created 20 03 2023 - 11:26 AM
 * @Author Hazeem Hassan
 */
public interface BeerRepositoryS14 extends JpaRepository<BeerEntityS14, UUID> {

List<BeerEntityS14> findAllByBeerNameIsLikeIgnoreCase(String beerName);
    List<BeerEntityS14> findAllByBeerStyle(BeerStyle beerStyle);

    List<BeerEntityS14> findAllByBeerNameIsLikeIgnoreCaseAndBeerStyle(String beerName,BeerStyle beerStyle);
}
