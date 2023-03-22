package springFrameworkSpringBoot.S10DataValidation.bootStrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springFrameworkSpringBoot.S10DataValidation.Model.BeerStyleS10;
import springFrameworkSpringBoot.S10DataValidation.entities.BeerEntityS10;
import springFrameworkSpringBoot.S10DataValidation.entities.CustomerEntityS10;
import springFrameworkSpringBoot.S10DataValidation.repositories.BeerRepositoryS10;
import springFrameworkSpringBoot.S10DataValidation.repositories.CustomerRepositoryS10;

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
public class BootstrapDataS10 implements CommandLineRunner {

    private final BeerRepositoryS10 beerRepository;
    private final CustomerRepositoryS10 customerRepository;
    @Override
    public void run(String... args) throws Exception {
        loadBeerData();
        loadCustomerData();
    }

    private void loadBeerData() {
        if (beerRepository.count() == 0){
            BeerEntityS10 beer1 = BeerEntityS10.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle(BeerStyleS10.PALE_ALE)
                    .upc("12356")
                    .price(new BigDecimal("12.99"))
                    .quantityOnHand(122)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            BeerEntityS10 beer2 = BeerEntityS10.builder()
                    .beerName("Crank")
                    .beerStyle(BeerStyleS10.PALE_ALE)
                    .upc("12356222")
                    .price(new BigDecimal("11.99"))
                    .quantityOnHand(392)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            BeerEntityS10 beer3 = BeerEntityS10.builder()
                    .beerName("Sunshine City")
                    .beerStyle(BeerStyleS10.IPA)
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
            CustomerEntityS10 customer1 = CustomerEntityS10.builder()
                    .id(UUID.randomUUID())
                    .name("Customer 1")
                    .version(1)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            CustomerEntityS10 customer2 = CustomerEntityS10.builder()
                    .id(UUID.randomUUID())
                    .name("Customer 2")
                    .version(1)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            CustomerEntityS10 customer3 = CustomerEntityS10.builder()
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