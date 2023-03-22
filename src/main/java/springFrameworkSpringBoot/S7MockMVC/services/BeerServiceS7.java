package springFrameworkSpringBoot.S7MockMVC.services;



import springFrameworkSpringBoot.S7MockMVC.Model.BeerS7;

import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:00 PM
 * @Author Hazeem Hassan
 */
public interface BeerServiceS7 {
    List<BeerS7> listBeers();

    BeerS7 getBeerById(UUID id);

    BeerS7 saveNewBeer(BeerS7 beerS7);

    void updateBeerById(UUID beerId, BeerS7 beerS7);

    void deleteById(UUID beerId);

    void patchBeerById(UUID beerId, BeerS7 beerS7);
}
