package springFrameworkSpringBoot.S16DatabaseRelationShipMapping.services;


import org.springframework.data.domain.Page;
import springFrameworkSpringBoot.BeerStyle;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.Model.BeerDTOS16;

import java.util.Optional;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:00 PM
 * @Author Hazeem Hassan
 */
public interface BeerServiceS16 {
    Page<BeerDTOS16> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber, Integer pageSize);

    Optional<BeerDTOS16> getBeerById(UUID id);

    BeerDTOS16 saveNewBeer(BeerDTOS16 beer);

    Optional<BeerDTOS16> updateBeerById(UUID beerId, BeerDTOS16 beer);

    Boolean deleteById(UUID beerId);

    Optional<BeerDTOS16> patchBeerById(UUID beerId, BeerDTOS16 beer);
}
