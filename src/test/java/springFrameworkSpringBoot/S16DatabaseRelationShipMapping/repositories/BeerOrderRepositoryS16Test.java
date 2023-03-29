package springFrameworkSpringBoot.S16DatabaseRelationShipMapping.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.entities.BeerEntityS16;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.entities.BeerOrderS16;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.entities.BeerOrderShipmentS16;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.entities.CustomerEntityS16;


@SpringBootTest
class BeerOrderRepositoryS16Test {

    @Autowired
    BeerOrderRepositoryS16 beerOrderRepository;

    @Autowired
    CustomerRepositoryS16 customerRepository;

    @Autowired
    BeerRepositoryS16 beerRepository;

    CustomerEntityS16 testCustomer;
    BeerEntityS16 testBeer;

    @BeforeEach
    void setUp() {
        testCustomer = customerRepository.findAll().get(0);
        testBeer = beerRepository.findAll().get(0);
    }

    @Transactional
    @Test
    void testBeerOrders() {
        BeerOrderS16 beerOrder = BeerOrderS16.builder()
                .customerRef("Test order")
                .customer(testCustomer)
                .beerOrderShipment(BeerOrderShipmentS16.builder()
                        .trackingNumber("1235r")
                        .build())
                .build();

        BeerOrderS16 savedBeerOrder = beerOrderRepository.save(beerOrder);


        System.out.println(savedBeerOrder.getCustomerRef());
    }
}


