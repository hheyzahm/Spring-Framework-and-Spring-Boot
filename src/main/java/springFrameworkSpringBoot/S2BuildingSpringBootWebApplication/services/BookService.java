package springFrameworkSpringBoot.S2BuildingSpringBootWebApplication.services;

import springFrameworkSpringBoot.S2BuildingSpringBootWebApplication.domain.Book;

/**
 * @Created 21 03 2023 - 11:43 AM
 * @Author Hazeem Hassan
 */
public interface BookService {
    Iterable<Book> findAll();

}
