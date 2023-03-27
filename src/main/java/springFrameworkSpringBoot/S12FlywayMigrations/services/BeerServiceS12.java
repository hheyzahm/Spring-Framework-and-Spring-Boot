package springFrameworkSpringBoot.S12FlywayMigrations.services;



import springFrameworkSpringBoot.S12FlywayMigrations.Model.BeerDTOS12;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:00 PM
 * @Author Hazeem Hassan
 */
public interface BeerServiceS12 {
    List<BeerDTOS12> listBeers();

    Optional<BeerDTOS12> getBeerById(UUID id);

    BeerDTOS12 saveNewBeer(BeerDTOS12 beer);

    Optional<BeerDTOS12> updateBeerById(UUID beerId, BeerDTOS12 beer);

    Boolean deleteById(UUID beerId);

    Optional<BeerDTOS12> patchBeerById(UUID beerId, BeerDTOS12 beer);
}
