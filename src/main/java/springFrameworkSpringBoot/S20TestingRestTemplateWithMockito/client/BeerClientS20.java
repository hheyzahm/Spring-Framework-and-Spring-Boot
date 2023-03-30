package springFrameworkSpringBoot.S20TestingRestTemplateWithMockito.client;

import org.springframework.data.domain.Page;
import springFrameworkSpringBoot.BeerStyle;
import springFrameworkSpringBoot.S20TestingRestTemplateWithMockito.model.BeerDTOS20;

import java.util.UUID;

/**
 * @Created 29 03 2023 - 1:26 PM
 * @Author Hazeem Hassan
 */
public interface BeerClientS20 {
    Page<BeerDTOS20> listBeers();

    Page<BeerDTOS20> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber,
                               Integer pageSize);

    BeerDTOS20 getBeerById(UUID beerId);

    BeerDTOS20 createBeer(BeerDTOS20 newDto);

    BeerDTOS20 updateBeer(BeerDTOS20 beerDto);

    void deleteBeer(UUID beerId);
}
