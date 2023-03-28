package springFrameworkSpringBoot.S15PagingAndSorting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springFrameworkSpringBoot.S15PagingAndSorting.entities.CustomerEntityS15;

import java.util.UUID;

/**
 * @Created 20 03 2023 - 11:26 AM
 * @Author Hazeem Hassan
 */
public interface CustomerRepositoryS15 extends JpaRepository<CustomerEntityS15, UUID> {
}
