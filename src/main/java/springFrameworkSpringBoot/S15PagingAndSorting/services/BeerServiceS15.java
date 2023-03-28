package springFrameworkSpringBoot.S15PagingAndSorting.services;


import org.springframework.data.domain.Page;
import springFrameworkSpringBoot.BeerStyle;
import springFrameworkSpringBoot.S15PagingAndSorting.Model.BeerDTOS15;

import java.util.Optional;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:00 PM
 * @Author Hazeem Hassan
 */
public interface BeerServiceS15 {
    Page<BeerDTOS15> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber, Integer pageSize);

    Optional<BeerDTOS15> getBeerById(UUID id);

    BeerDTOS15 saveNewBeer(BeerDTOS15 beer);

    Optional<BeerDTOS15> updateBeerById(UUID beerId, BeerDTOS15 beer);

    Boolean deleteById(UUID beerId);

    Optional<BeerDTOS15> patchBeerById(UUID beerId, BeerDTOS15 beer);
}
