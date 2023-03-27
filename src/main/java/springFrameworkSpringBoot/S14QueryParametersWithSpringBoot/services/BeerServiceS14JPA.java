package springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import springFrameworkSpringBoot.BeerStyle;

import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.Model.BeerDTOS14;
import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.entities.BeerEntityS14;
import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.mappers.BeerMapperS14;
import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.repositories.BeerRepositoryS14;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @Created 20 03 2023 - 12:17 PM
 * @Author Hazeem Hassan
 */


/**
 * Created by jt, Spring Framework Guru.
 */
@Service
@Primary
@RequiredArgsConstructor
public class BeerServiceS14JPA implements BeerServiceS14 {
    private final BeerRepositoryS14 beerRepository;
    private final BeerMapperS14 beerMapper;

    @Override
    public List<BeerDTOS14> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory) {

        List<BeerEntityS14> beerList;

        if(StringUtils.hasText(beerName) && beerStyle == null) {
            beerList = listBeersByName(beerName);
        } else if (!StringUtils.hasText(beerName) && beerStyle != null){
            beerList = listBeersByStyle(beerStyle);
        } else if (StringUtils.hasText(beerName) && beerStyle != null){
            beerList= listBeersByNameAndStyle(beerName,beerStyle);
        } else {
            beerList = beerRepository.findAll();
        }
        if(showInventory != null && !showInventory )
        {
            beerList.forEach(beerEntity -> beerEntity.setQuantityOnHand(null));
        }
        return beerList.stream()
                .map(beerMapper::beerEntityToBeerDTO)
                .collect(Collectors.toList());
    }

    private List<BeerEntityS14> listBeersByNameAndStyle(String beerName, BeerStyle beerStyle) {

   return beerRepository.findAllByBeerNameIsLikeIgnoreCaseAndBeerStyle("%" + beerName + "%",beerStyle); }

    public List<BeerEntityS14> listBeersByStyle(BeerStyle beerStyle) {
        return beerRepository.findAllByBeerStyle(beerStyle);
    }

    public List<BeerEntityS14> listBeersByName(String beerName){
        return beerRepository.findAllByBeerNameIsLikeIgnoreCase("%" + beerName + "%");
    }

    @Override
    public Optional<BeerDTOS14> getBeerById(UUID id) {
        return Optional.ofNullable(beerMapper.beerEntityToBeerDTO(beerRepository.findById(id)
                .orElse(null)));
    }

    @Override
    public BeerDTOS14 saveNewBeer(BeerDTOS14 beer) {
        return beerMapper.beerEntityToBeerDTO(beerRepository.save(beerMapper.beerDTOtoBeerEntity(beer)));
    }

    @Override
    public Optional<BeerDTOS14> updateBeerById(UUID beerId, BeerDTOS14 beer) {
        AtomicReference<Optional<BeerDTOS14>> atomicReference = new AtomicReference<>();

        beerRepository.findById(beerId).ifPresentOrElse(foundBeer -> {
            foundBeer.setBeerName(beer.getBeerName());
            foundBeer.setBeerStyle(beer.getBeerStyle());
            foundBeer.setUpc(beer.getUpc());
            foundBeer.setPrice(beer.getPrice());
            foundBeer.setQuantityOnHand(beer.getQuantityOnHand());
            atomicReference.set(Optional.of(beerMapper
                    .beerEntityToBeerDTO(beerRepository.save(foundBeer))));
        }, () -> {
            atomicReference.set(Optional.empty());
        });

        return atomicReference.get();
    }

    @Override
    public Boolean deleteById(UUID beerId) {
        if (beerRepository.existsById(beerId)) {
            beerRepository.deleteById(beerId);
            return true;
        }
        return false;
    }

    @Override
    public Optional<BeerDTOS14> patchBeerById(UUID beerId, BeerDTOS14 beer) {
        AtomicReference<Optional<BeerDTOS14>> atomicReference = new AtomicReference<>();

        beerRepository.findById(beerId).ifPresentOrElse(foundBeer -> {
            if (StringUtils.hasText(beer.getBeerName())){
                foundBeer.setBeerName(beer.getBeerName());
            }
            if (beer.getBeerStyle() != null){
                foundBeer.setBeerStyle(beer.getBeerStyle());
            }
            if (StringUtils.hasText(beer.getUpc())){
                foundBeer.setUpc(beer.getUpc());
            }
            if (beer.getPrice() != null){
                foundBeer.setPrice(beer.getPrice());
            }
            if (beer.getQuantityOnHand() != null){
                foundBeer.setQuantityOnHand(beer.getQuantityOnHand());
            }
            atomicReference.set(Optional.of(beerMapper
                    .beerEntityToBeerDTO(beerRepository.save(foundBeer))));
        }, () -> {
            atomicReference.set(Optional.empty());
        });

        return atomicReference.get();
    }
}