package springFrameworkSpringBoot.S19SpringRestTemplate.client;

import org.springframework.data.domain.Page;
import springFrameworkSpringBoot.BeerStyle;
import springFrameworkSpringBoot.S19SpringRestTemplate.model.BeerDTOS19;

import java.util.UUID;

/**
 * @Created 29 03 2023 - 1:26 PM
 * @Author Hazeem Hassan
 */
public interface BeerClientS19 {
    Page<BeerDTOS19> listBeers();

    Page<BeerDTOS19> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber,
                               Integer pageSize);

    BeerDTOS19 getBeerById(UUID beerId);

    BeerDTOS19 createBeer(BeerDTOS19 newDto);

    BeerDTOS19 updateBeer(BeerDTOS19 beerDto);

    void deleteBeer(UUID beerId);
}
