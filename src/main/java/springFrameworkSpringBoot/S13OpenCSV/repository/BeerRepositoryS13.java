package springFrameworkSpringBoot.S13OpenCSV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springFrameworkSpringBoot.S12FlywayMigrations.entities.BeerEntityS12;
import springFrameworkSpringBoot.S13OpenCSV.entity.BeerEntityS13;

import java.util.UUID;

/**
 * @Created 20 03 2023 - 11:26 AM
 * @Author Hazeem Hassan
 */
public interface BeerRepositoryS13 extends JpaRepository<BeerEntityS13, UUID> {
}
