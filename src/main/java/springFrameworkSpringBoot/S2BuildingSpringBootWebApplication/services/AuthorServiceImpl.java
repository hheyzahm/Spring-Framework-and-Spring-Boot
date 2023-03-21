package springFrameworkSpringBoot.S2BuildingSpringBootWebApplication.services;

import org.springframework.stereotype.Service;
import springFrameworkSpringBoot.S2BuildingSpringBootWebApplication.domain.Author;
import springFrameworkSpringBoot.S2BuildingSpringBootWebApplication.repositories.AuthorRepository;

/**
 * @Created 21 03 2023 - 11:44 AM
 * @Author Hazeem Hassan
 */
@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

}
