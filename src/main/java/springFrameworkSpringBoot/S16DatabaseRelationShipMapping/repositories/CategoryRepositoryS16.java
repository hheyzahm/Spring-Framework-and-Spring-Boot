package springFrameworkSpringBoot.S16DatabaseRelationShipMapping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.entities.CategoryS16;

import java.util.UUID;

/**
 * @Created 28 03 2023 - 4:50 PM
 * @Author Hazeem Hassan
 */
public interface CategoryRepositoryS16 extends JpaRepository<CategoryS16, UUID> {
}
