package springFrameworkSpringBoot.S11MySQLWithSpringBoot.bootStrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springFrameworkSpringBoot.S11MySQLWithSpringBoot.Model.BeerStyleS11;
import springFrameworkSpringBoot.S11MySQLWithSpringBoot.entities.BeerEntityS11;
import springFrameworkSpringBoot.S11MySQLWithSpringBoot.entities.CustomerEntityS11;
import springFrameworkSpringBoot.S11MySQLWithSpringBoot.repositories.BeerRepositoryS11;
import springFrameworkSpringBoot.S11MySQLWithSpringBoot.repositories.CustomerRepositoryS11;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

/**
 * @Created 22 03 2023 - 5:03 PM
 * @Author Hazeem Hassan
 */
@Component
@RequiredArgsConstructor
public class BootstrapDataS11 implements CommandLineRunner {

    private final BeerRepositoryS11 beerRepository;
    private final CustomerRepositoryS11 customerRepository;
    @Override
    public void run(String... args) throws Exception {
        loadBeerData();
        loadCustomerData();
    }

    private void loadBeerData() {
        if (beerRepository.count() == 0){
            BeerEntityS11 beer1 = BeerEntityS11.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle(BeerStyleS11.PALE_ALE)
                    .upc("12356")
                    .price(new BigDecimal("12.99"))
                    .quantityOnHand(122)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            BeerEntityS11 beer2 = BeerEntityS11.builder()
                    .beerName("Crank")
                    .beerStyle(BeerStyleS11.PALE_ALE)
                    .upc("12356222")
                    .price(new BigDecimal("11.99"))
                    .quantityOnHand(392)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            BeerEntityS11 beer3 = BeerEntityS11.builder()
                    .beerName("Sunshine City")
                    .beerStyle(BeerStyleS11.IPA)
                    .upc("12356")
                    .price(new BigDecimal("13.99"))
                    .quantityOnHand(144)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            beerRepository.save(beer1);
            beerRepository.save(beer2);
            beerRepository.save(beer3);
        }

    }

    private void loadCustomerData() {

        if (customerRepository.count() == 0) {
            CustomerEntityS11 customer1 = CustomerEntityS11.builder()
                    .id(UUID.randomUUID())
                    .name("Customer 1")
                    .version(1)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            CustomerEntityS11 customer2 = CustomerEntityS11.builder()
                    .id(UUID.randomUUID())
                    .name("Customer 2")
                    .version(1)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            CustomerEntityS11 customer3 = CustomerEntityS11.builder()
                    .id(UUID.randomUUID())
                    .name("Customer 3")
                    .version(1)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));
        }

    }


}