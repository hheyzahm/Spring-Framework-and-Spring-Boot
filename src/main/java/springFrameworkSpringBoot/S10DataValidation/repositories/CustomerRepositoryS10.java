package springFrameworkSpringBoot.S10DataValidation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springFrameworkSpringBoot.S10DataValidation.entities.CustomerEntityS10;

import java.util.UUID;

/**
 * @Created 20 03 2023 - 11:26 AM
 * @Author Hazeem Hassan
 */
public interface CustomerRepositoryS10 extends JpaRepository<CustomerEntityS10, UUID> {
}
