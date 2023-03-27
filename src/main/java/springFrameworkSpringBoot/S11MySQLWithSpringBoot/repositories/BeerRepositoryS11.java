package springFrameworkSpringBoot.S11MySQLWithSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springFrameworkSpringBoot.S11MySQLWithSpringBoot.entities.BeerEntityS11;

import java.util.UUID;

/**
 * @Created 20 03 2023 - 11:26 AM
 * @Author Hazeem Hassan
 */
public interface BeerRepositoryS11 extends JpaRepository<BeerEntityS11, UUID> {
}
