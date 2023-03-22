package springFrameworkSpringBoot.S7MockMVC.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import springFrameworkSpringBoot.S7MockMVC.Model.BeerS7;
import springFrameworkSpringBoot.S7MockMVC.Model.BeerStyleS7;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @Created 17 03 2023 - 5:01 PM
 * @Author Hazeem Hassan
 */

@Slf4j
@Service
public class BeerServiceS7Impl implements BeerServiceS7 {

    private Map<UUID, BeerS7> beerMap;

    public BeerServiceS7Impl() {
        this.beerMap = new HashMap<>();

        BeerS7 beerS71 = BeerS7.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleS7.PALE_ALE)
                .upc("12356")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        BeerS7 beerS72 = BeerS7.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Crank")
                .beerStyle(BeerStyleS7.PALE_ALE)
                .upc("12356222")
                .price(new BigDecimal("11.99"))
                .quantityOnHand(392)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        BeerS7 beerS73 = BeerS7.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Sunshine City")
                .beerStyle(BeerStyleS7.IPA)
                .upc("12356")
                .price(new BigDecimal("13.99"))
                .quantityOnHand(144)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        beerMap.put(beerS71.getId(), beerS71);
        beerMap.put(beerS72.getId(), beerS72);
        beerMap.put(beerS73.getId(), beerS73);
    }

    @Override
    public void patchBeerById(UUID beerId, BeerS7 beerS7) {
        BeerS7 existing = beerMap.get(beerId);

        if (StringUtils.hasText(beerS7.getBeerName())){
            existing.setBeerName(beerS7.getBeerName());
        }

        if (beerS7.getBeerStyle() != null) {
            existing.setBeerStyle(beerS7.getBeerStyle());
        }

        if (beerS7.getPrice() != null) {
            existing.setPrice(beerS7.getPrice());
        }

        if (beerS7.getQuantityOnHand() != null){
            existing.setQuantityOnHand(beerS7.getQuantityOnHand());
        }

        if (StringUtils.hasText(beerS7.getUpc())) {
            existing.setUpc(beerS7.getUpc());
        }
    }

    @Override
    public void deleteById(UUID beerId) {
        beerMap.remove(beerId);
    }

    @Override
    public void updateBeerById(UUID beerId, BeerS7 beerS7) {
        BeerS7 existing = beerMap.get(beerId);
        existing.setBeerName(beerS7.getBeerName());
        existing.setPrice(beerS7.getPrice());
        existing.setUpc(beerS7.getUpc());
        existing.setQuantityOnHand(beerS7.getQuantityOnHand());
    }

    @Override
    public List<BeerS7> listBeers(){
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public BeerS7 getBeerById(UUID id) {

        log.debug("Get Beer by Id - in service. Id: " + id.toString());

        return beerMap.get(id);
    }

    @Override
    public BeerS7 saveNewBeer(BeerS7 beerS7) {

        BeerS7 savedBeerS7 = BeerS7.builder()
                .id(UUID.randomUUID())
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .beerName(beerS7.getBeerName())
                .beerStyle(beerS7.getBeerStyle())
                .quantityOnHand(beerS7.getQuantityOnHand())
                .upc(beerS7.getUpc())
                .price(beerS7.getPrice())
                .build();

        beerMap.put(savedBeerS7.getId(), savedBeerS7);

        return savedBeerS7;
    }
}