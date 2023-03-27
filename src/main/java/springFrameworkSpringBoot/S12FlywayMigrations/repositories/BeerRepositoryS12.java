package springFrameworkSpringBoot.S12FlywayMigrations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springFrameworkSpringBoot.S12FlywayMigrations.entities.BeerEntityS12;

import java.util.UUID;

/**
 * @Created 20 03 2023 - 11:26 AM
 * @Author Hazeem Hassan
 */
public interface BeerRepositoryS12 extends JpaRepository<BeerEntityS12, UUID> {
}
