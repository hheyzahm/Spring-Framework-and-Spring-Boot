package springFrameworkSpringBoot.S6SpringMVC.services;



import springFrameworkSpringBoot.S6SpringMVC.Model.BeerS6;

import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:00 PM
 * @Author Hazeem Hassan
 */
public interface BeerServiceS6 {
    List<BeerS6> listBeers();

    BeerS6 getBeerById(UUID id);

    BeerS6 saveNewBeer(BeerS6 beerS6);

    void updateBeerById(UUID beerId, BeerS6 beerS6);

    void deleteById(UUID beerId);

    void patchBeerById(UUID beerId, BeerS6 beerS6);
}
