package springFrameworkSpringBoot.S12FlywayMigrations.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import springFrameworkSpringBoot.S12FlywayMigrations.Model.BeerDTOS12;
import springFrameworkSpringBoot.S12FlywayMigrations.Model.BeerStyleS12;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @Created 17 03 2023 - 5:01 PM
 * @Author Hazeem Hassan
 */

@Slf4j
@Service
public class BeerServiceS12Impl implements BeerServiceS12 {
    private Map<UUID, BeerDTOS12> beerMap;

    public BeerServiceS12Impl() {
        this.beerMap = new HashMap<>();

        BeerDTOS12 beer1 = BeerDTOS12.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleS12.PALE_ALE)
                .upc("12356")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        BeerDTOS12 beer2 = BeerDTOS12.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Crank")
                .beerStyle(BeerStyleS12.PALE_ALE)
                .upc("12356222")
                .price(new BigDecimal("11.99"))
                .quantityOnHand(392)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        BeerDTOS12 beer3 = BeerDTOS12.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Sunshine City")
                .beerStyle(BeerStyleS12.IPA)
                .upc("12356")
                .price(new BigDecimal("13.99"))
                .quantityOnHand(144)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        beerMap.put(beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);
    }

    @Override
    public Optional<BeerDTOS12> patchBeerById(UUID beerId, BeerDTOS12 beer) {
        BeerDTOS12 existing = beerMap.get(beerId);

        if (StringUtils.hasText(beer.getBeerName())){
            existing.setBeerName(beer.getBeerName());
        }

        if (beer.getBeerStyle() != null) {
            existing.setBeerStyle(beer.getBeerStyle());
        }

        if (beer.getPrice() != null) {
            existing.setPrice(beer.getPrice());
        }

        if (beer.getQuantityOnHand() != null){
            existing.setQuantityOnHand(beer.getQuantityOnHand());
        }

        if (StringUtils.hasText(beer.getUpc())) {
            existing.setUpc(beer.getUpc());
        }

        return Optional.of(existing);
    }

    @Override
    public Boolean deleteById(UUID beerId) {
        beerMap.remove(beerId);

        return true;
    }

    @Override
    public Optional<BeerDTOS12> updateBeerById(UUID beerId, BeerDTOS12 beer) {
        BeerDTOS12 existing = beerMap.get(beerId);
        existing.setBeerName(beer.getBeerName());
        existing.setPrice(beer.getPrice());
        existing.setUpc(beer.getUpc());
        existing.setQuantityOnHand(beer.getQuantityOnHand());
        return Optional.of(existing);
    }

    @Override
    public List<BeerDTOS12> listBeers(){
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Optional<BeerDTOS12> getBeerById(UUID id) {

        log.debug("Get Beer by Id - in service. Id: " + id.toString());

        return Optional.of(beerMap.get(id));
    }

    @Override
    public BeerDTOS12 saveNewBeer(BeerDTOS12 beer) {

        BeerDTOS12 savedBeer = BeerDTOS12.builder()
                .id(UUID.randomUUID())
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .beerName(beer.getBeerName())
                .beerStyle(beer.getBeerStyle())
                .quantityOnHand(beer.getQuantityOnHand())
                .upc(beer.getUpc())
                .price(beer.getPrice())
                .build();

        beerMap.put(savedBeer.getId(), savedBeer);

        return savedBeer;
    }
}