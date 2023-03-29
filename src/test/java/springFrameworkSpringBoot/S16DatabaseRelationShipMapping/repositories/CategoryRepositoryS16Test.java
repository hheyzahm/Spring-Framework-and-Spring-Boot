package springFrameworkSpringBoot.S16DatabaseRelationShipMapping.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.entities.BeerEntityS16;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.entities.CategoryS16;

@SpringBootTest
class CategoryRepositoryS16Test {
    @Autowired
    CategoryRepositoryS16 categoryRepository;

    @Autowired
    BeerRepositoryS16 beerRepository;
    BeerEntityS16 testBeer;

    @BeforeEach
    void setUp() {
        testBeer = beerRepository.findAll().get(0);
    }

    @Transactional
    @Test
    void testAddCategory() {
        CategoryS16 savedCat = categoryRepository.save(CategoryS16.builder()
                .description("Ales")
                .build());

        testBeer.addCategory(savedCat);
        BeerEntityS16 saveBeer = beerRepository.save(testBeer);

        System.out.println(saveBeer.getBeerName());

    }
}