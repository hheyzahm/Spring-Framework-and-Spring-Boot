package springFrameworkSpringBoot.S2BuildingSpringBootWebApplication.services;

import org.springframework.stereotype.Service;
import springFrameworkSpringBoot.S2BuildingSpringBootWebApplication.domain.Book;
import springFrameworkSpringBoot.S2BuildingSpringBootWebApplication.repositories.BookRepository;

/**
 * @Created 21 03 2023 - 11:44 AM
 * @Author Hazeem Hassan
 */
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}