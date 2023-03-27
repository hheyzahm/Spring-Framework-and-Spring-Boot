package springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.entities.CustomerEntityS14;


import java.util.UUID;

/**
 * @Created 20 03 2023 - 11:26 AM
 * @Author Hazeem Hassan
 */
public interface CustomerRepositoryS14 extends JpaRepository<CustomerEntityS14, UUID> {
}
