package springFrameworkSpringBoot.S11MySQLWithSpringBoot.services;



import springFrameworkSpringBoot.S11MySQLWithSpringBoot.Model.BeerDTOS11;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:00 PM
 * @Author Hazeem Hassan
 */
public interface BeerServiceS11 {
    List<BeerDTOS11> listBeers();

    Optional<BeerDTOS11> getBeerById(UUID id);

    BeerDTOS11 saveNewBeer(BeerDTOS11 beer);

    Optional<BeerDTOS11> updateBeerById(UUID beerId, BeerDTOS11 beer);

    Boolean deleteById(UUID beerId);

    Optional<BeerDTOS11> patchBeerById(UUID beerId, BeerDTOS11 beer);
}
