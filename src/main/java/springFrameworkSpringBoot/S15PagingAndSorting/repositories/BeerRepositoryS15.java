package springFrameworkSpringBoot.S15PagingAndSorting.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import springFrameworkSpringBoot.BeerStyle;
import springFrameworkSpringBoot.S15PagingAndSorting.entities.BeerEntityS15;

import java.util.UUID;

/**
 * @Created 20 03 2023 - 11:26 AM
 * @Author Hazeem Hassan
 */
public interface BeerRepositoryS15 extends JpaRepository<BeerEntityS15, UUID> {

    Page<BeerEntityS15> findAllByBeerNameIsLikeIgnoreCase(String beerName, Pageable pageable);

    Page<BeerEntityS15> findAllByBeerStyle(BeerStyle beerStyle, Pageable pageable);

    Page<BeerEntityS15> findAllByBeerNameIsLikeIgnoreCaseAndBeerStyle(String beerName, BeerStyle beerStyle, Pageable pageable);
}
