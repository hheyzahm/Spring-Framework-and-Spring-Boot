package springFrameworkSpringBoot.S10DataValidation.services;



import springFrameworkSpringBoot.S10DataValidation.Model.BeerDTOS10;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:00 PM
 * @Author Hazeem Hassan
 */
public interface BeerServiceS10 {
    List<BeerDTOS10> listBeers();

    Optional<BeerDTOS10> getBeerById(UUID id);

    BeerDTOS10 saveNewBeer(BeerDTOS10 beer);

    Optional<BeerDTOS10> updateBeerById(UUID beerId, BeerDTOS10 beer);

    Boolean deleteById(UUID beerId);

    Optional<BeerDTOS10> patchBeerById(UUID beerId, BeerDTOS10 beer);
}
