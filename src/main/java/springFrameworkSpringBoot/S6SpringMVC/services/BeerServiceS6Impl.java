package springFrameworkSpringBoot.S6SpringMVC.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import springFrameworkSpringBoot.S6SpringMVC.Model.BeerS6;
import springFrameworkSpringBoot.S6SpringMVC.Model.BeerStyleS6;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @Created 17 03 2023 - 5:01 PM
 * @Author Hazeem Hassan
 */

@Slf4j
@Service
public class BeerServiceS6Impl implements BeerServiceS6 {

    private Map<UUID, BeerS6> beerMap;

    public BeerServiceS6Impl() {
        this.beerMap = new HashMap<>();

        BeerS6 beerS61 = BeerS6.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleS6.PALE_ALE)
                .upc("12356")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        BeerS6 beerS62 = BeerS6.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Crank")
                .beerStyle(BeerStyleS6.PALE_ALE)
                .upc("12356222")
                .price(new BigDecimal("11.99"))
                .quantityOnHand(392)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        BeerS6 beerS63 = BeerS6.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Sunshine City")
                .beerStyle(BeerStyleS6.IPA)
                .upc("12356")
                .price(new BigDecimal("13.99"))
                .quantityOnHand(144)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        beerMap.put(beerS61.getId(), beerS61);
        beerMap.put(beerS62.getId(), beerS62);
        beerMap.put(beerS63.getId(), beerS63);
    }

    @Override
    public void patchBeerById(UUID beerId, BeerS6 beerS6) {
        BeerS6 existing = beerMap.get(beerId);

        if (StringUtils.hasText(beerS6.getBeerName())){
            existing.setBeerName(beerS6.getBeerName());
        }

        if (beerS6.getBeerStyle() != null) {
            existing.setBeerStyle(beerS6.getBeerStyle());
        }

        if (beerS6.getPrice() != null) {
            existing.setPrice(beerS6.getPrice());
        }

        if (beerS6.getQuantityOnHand() != null){
            existing.setQuantityOnHand(beerS6.getQuantityOnHand());
        }

        if (StringUtils.hasText(beerS6.getUpc())) {
            existing.setUpc(beerS6.getUpc());
        }
    }

    @Override
    public void deleteById(UUID beerId) {
        beerMap.remove(beerId);
    }

    @Override
    public void updateBeerById(UUID beerId, BeerS6 beerS6) {
        BeerS6 existing = beerMap.get(beerId);
        existing.setBeerName(beerS6.getBeerName());
        existing.setPrice(beerS6.getPrice());
        existing.setUpc(beerS6.getUpc());
        existing.setQuantityOnHand(beerS6.getQuantityOnHand());
    }

    @Override
    public List<BeerS6> listBeers(){
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public BeerS6 getBeerById(UUID id) {

        log.debug("Get Beer by Id - in service. Id: " + id.toString());

        return beerMap.get(id);
    }

    @Override
    public BeerS6 saveNewBeer(BeerS6 beerS6) {

        BeerS6 savedBeerS6 = BeerS6.builder()
                .id(UUID.randomUUID())
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .beerName(beerS6.getBeerName())
                .beerStyle(beerS6.getBeerStyle())
                .quantityOnHand(beerS6.getQuantityOnHand())
                .upc(beerS6.getUpc())
                .price(beerS6.getPrice())
                .build();

        beerMap.put(savedBeerS6.getId(), savedBeerS6);

        return savedBeerS6;
    }
}