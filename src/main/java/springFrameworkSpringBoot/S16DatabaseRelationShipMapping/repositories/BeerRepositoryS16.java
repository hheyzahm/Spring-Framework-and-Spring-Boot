package springFrameworkSpringBoot.S16DatabaseRelationShipMapping.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import springFrameworkSpringBoot.BeerStyle;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.entities.BeerEntityS16;

import java.util.UUID;

/**
 * @Created 20 03 2023 - 11:26 AM
 * @Author Hazeem Hassan
 */
public interface BeerRepositoryS16 extends JpaRepository<BeerEntityS16, UUID> {

    Page<BeerEntityS16> findAllByBeerNameIsLikeIgnoreCase(String beerName, Pageable pageable);

    Page<BeerEntityS16> findAllByBeerStyle(BeerStyle beerStyle, Pageable pageable);

    Page<BeerEntityS16> findAllByBeerNameIsLikeIgnoreCaseAndBeerStyle(String beerName, BeerStyle beerStyle, Pageable pageable);
}
