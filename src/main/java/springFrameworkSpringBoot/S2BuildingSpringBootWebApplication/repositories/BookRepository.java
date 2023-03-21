package springFrameworkSpringBoot.S2BuildingSpringBootWebApplication.repositories;

import org.springframework.data.repository.CrudRepository;
import springFrameworkSpringBoot.S2BuildingSpringBootWebApplication.domain.Book;

/**
 * @Created 21 03 2023 - 11:41 AM
 * @Author Hazeem Hassan
 */
public interface BookRepository extends CrudRepository<Book,Long> {
}
