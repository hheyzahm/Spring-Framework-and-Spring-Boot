package springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.services;


import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.Model.BeerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:00 PM
 * @Author Hazeem Hassan
 */
public interface BeerServiceS9 {
    List<BeerDTO> listBeers();

    Optional<BeerDTO> getBeerById(UUID id);

    BeerDTO saveNewBeer(BeerDTO beer);

    Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer);

    Boolean deleteById(UUID beerId);

    void patchBeerById(UUID beerId, BeerDTO beer);
}
