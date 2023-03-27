package springFrameworkSpringBoot.S12FlywayMigrations.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import springFrameworkSpringBoot.S12FlywayMigrations.Model.BeerDTOS12;
import springFrameworkSpringBoot.S12FlywayMigrations.mappers.BeerMapperS12;
import springFrameworkSpringBoot.S12FlywayMigrations.repositories.BeerRepositoryS12;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @Created 20 03 2023 - 12:17 PM
 * @Author Hazeem Hassan
 */
@Service
@Primary
@RequiredArgsConstructor
public class BeerServiceS12JPA implements BeerServiceS12 {
    private final BeerRepositoryS12 beerRepository;
    private final BeerMapperS12 beerMapper;

    @Override
    public List<BeerDTOS12> listBeers() {
        return beerRepository.findAll()
                .stream()
                .map(beerMapper::beerEntityToBeerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BeerDTOS12> getBeerById(UUID id) {
        return Optional.ofNullable(beerMapper.beerEntityToBeerDTO(beerRepository.findById(id)
                .orElse(null)));
    }

    @Override
    public BeerDTOS12 saveNewBeer(BeerDTOS12 beer) {
        return beerMapper.beerEntityToBeerDTO(beerRepository.save(beerMapper.beerDTOtoBeerEntity(beer)));
    }

    @Override
    public Optional<BeerDTOS12> updateBeerById(UUID beerId, BeerDTOS12 beer) {
        AtomicReference<Optional<BeerDTOS12>> atomicReference = new AtomicReference<>();

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
    public Optional<BeerDTOS12> patchBeerById(UUID beerId, BeerDTOS12 beer) {
        AtomicReference<Optional<BeerDTOS12>> atomicReference = new AtomicReference<>();

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
