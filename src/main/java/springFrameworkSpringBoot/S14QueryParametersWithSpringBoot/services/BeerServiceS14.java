package springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.services;



import springFrameworkSpringBoot.BeerStyle;
import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.Model.BeerDTOS14;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:00 PM
 * @Author Hazeem Hassan
 */
public interface BeerServiceS14 {
    List<BeerDTOS14> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory);

    Optional<BeerDTOS14> getBeerById(UUID id);

    BeerDTOS14 saveNewBeer(BeerDTOS14 beer);

    Optional<BeerDTOS14> updateBeerById(UUID beerId, BeerDTOS14 beer);

    Boolean deleteById(UUID beerId);

    Optional<BeerDTOS14> patchBeerById(UUID beerId, BeerDTOS14 beer);
}
