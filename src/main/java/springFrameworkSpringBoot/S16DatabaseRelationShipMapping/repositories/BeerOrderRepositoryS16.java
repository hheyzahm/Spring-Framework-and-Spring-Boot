package springFrameworkSpringBoot.S16DatabaseRelationShipMapping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.entities.BeerOrderS16;

import java.util.UUID;

/**
 * @Created 28 03 2023 - 12:06 PM
 * @Author Hazeem Hassan
 */
public interface BeerOrderRepositoryS16 extends JpaRepository<BeerOrderS16, UUID> {
}
