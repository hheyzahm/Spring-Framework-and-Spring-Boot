package springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.Model.BeerDTO;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.mappers.BeerMapper;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.repositories.BeerRepositoryS9;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @Created 22 03 2023 - 5:28 PM
 * @Author Hazeem Hassan
 */
@Service
@Primary
@RequiredArgsConstructor
public class BeerServiceS9JPA implements BeerServiceS9 {
    private final BeerRepositoryS9 beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public List<BeerDTO> listBeers() {
        return beerRepository.findAll()
                .stream()
                .map(beerMapper::beerEntitytoBeerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BeerDTO> getBeerById(UUID id) {
        return Optional.ofNullable(beerMapper.beerEntitytoBeerDTO(beerRepository.findById(id)
                .orElse(null)));
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beer) {
        return beerMapper.beerEntitytoBeerDTO(beerRepository.save(beerMapper.beerDTOtoBeerEntity(beer)));
    }

    @Override
    public Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer) {
        AtomicReference<Optional<BeerDTO>> atomicReference = new AtomicReference<>();

        beerRepository.findById(beerId).ifPresentOrElse(foundBeer -> {
            foundBeer.setBeerName(beer.getBeerName());
            foundBeer.setBeerStyle(beer.getBeerStyle());
            foundBeer.setUpc(beer.getUpc());
            foundBeer.setPrice(beer.getPrice());
            atomicReference.set(Optional.of(beerMapper
                    .beerEntitytoBeerDTO(beerRepository.save(foundBeer))));
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
    public void patchBeerById(UUID beerId, BeerDTO beer) {

    }
}
