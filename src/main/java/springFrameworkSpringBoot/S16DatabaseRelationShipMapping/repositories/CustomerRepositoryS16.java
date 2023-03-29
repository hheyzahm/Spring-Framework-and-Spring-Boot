package springFrameworkSpringBoot.S16DatabaseRelationShipMapping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.entities.CustomerEntityS16;

import java.util.UUID;

/**
 * @Created 20 03 2023 - 11:26 AM
 * @Author Hazeem Hassan
 */
public interface CustomerRepositoryS16 extends JpaRepository<CustomerEntityS16, UUID> {
}
