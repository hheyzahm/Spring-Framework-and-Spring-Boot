package springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.bootStrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.Entities.BeerEntity;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.Entities.CustomerEntity;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.Model.BeerStyleS9;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.repositories.BeerRepositoryS9;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.repositories.CustomerRepositoryS9;

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

public class BootstrapDataS9 implements CommandLineRunner {
    private final BeerRepositoryS9 beerRepository;
    private final CustomerRepositoryS9 customerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerData();
        loadCustomerData();
    }

    private void loadBeerData() {
        if (beerRepository.count() == 0){
            BeerEntity beer1 = BeerEntity.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle(BeerStyleS9.PALE_ALE)
                    .upc("12356")
                    .price(new BigDecimal("12.99"))
                    .quantityOnHand(122)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            BeerEntity beer2 = BeerEntity.builder()
                    .beerName("Crank")
                    .beerStyle(BeerStyleS9.PALE_ALE)
                    .upc("12356222")
                    .price(new BigDecimal("11.99"))
                    .quantityOnHand(392)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            BeerEntity beer3 = BeerEntity.builder()
                    .beerName("Sunshine City")
                    .beerStyle(BeerStyleS9.IPA)
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
            CustomerEntity customer1 = CustomerEntity.builder()
                    .id(UUID.randomUUID())
                    .name("Customer 1")
                    .version(1)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            CustomerEntity customer2 = CustomerEntity.builder()
                    .id(UUID.randomUUID())
                    .name("Customer 2")
                    .version(1)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            CustomerEntity customer3 = CustomerEntity.builder()
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