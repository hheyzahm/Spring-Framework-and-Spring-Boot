package springFrameworkSpringBoot.S13OpenCSV.service.bootStrap;


import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import springFrameworkSpringBoot.S12FlywayMigrations.Model.BeerStyleS12;
import springFrameworkSpringBoot.S12FlywayMigrations.entities.BeerEntityS12;
import springFrameworkSpringBoot.S12FlywayMigrations.entities.CustomerEntityS12;
import springFrameworkSpringBoot.S12FlywayMigrations.repositories.BeerRepositoryS12;
import springFrameworkSpringBoot.S12FlywayMigrations.repositories.CustomerRepositoryS12;
import springFrameworkSpringBoot.S13OpenCSV.model.BeerCSVRecord;
import springFrameworkSpringBoot.S13OpenCSV.service.BeerCsvService;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @Created 22 03 2023 - 5:03 PM
 * @Author Hazeem Hassan
 */
@Component
@RequiredArgsConstructor
public class BootstrapDataS12 implements CommandLineRunner {
    private final BeerCsvService beerCsvService;
    private final BeerRepositoryS12 beerRepository;
    private final CustomerRepositoryS12 customerRepository;
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        loadBeerData();
        loadCustomerData();
        loadCsvData();
    }

    private void loadCsvData() throws FileNotFoundException {
        if (beerRepository.count() < 10){
            File file = ResourceUtils.getFile("classpath:csvData/beers.csv");

            List<BeerCSVRecord> recs = beerCsvService.convertCSV(file);

            recs.forEach(beerCSVRecord -> {
                BeerStyleS12 beerStyle = switch (beerCSVRecord.getStyle()) {
                    case "American Pale Lager" -> BeerStyleS12.LAGER;
                    case "American Pale Ale (APA)", "American Black Ale", "Belgian Dark Ale", "American Blonde Ale" ->
                            BeerStyleS12.ALE;
                    case "American IPA", "American Double / Imperial IPA", "Belgian IPA" -> BeerStyleS12.IPA;
                    case "American Porter" -> BeerStyleS12.PORTER;
                    case "Oatmeal Stout", "American Stout" -> BeerStyleS12.STOUT;
                    case "Saison / Farmhouse Ale" -> BeerStyleS12.SAISON;
                    case "Fruit / Vegetable Beer", "Winter Warmer", "Berliner Weissbier" -> BeerStyleS12.WHEAT;
                    case "English Pale Ale" -> BeerStyleS12.PALE_ALE;
                    default -> BeerStyleS12.PILSNER;
                };

                beerRepository.save(BeerEntityS12.builder()
                        .beerName(StringUtils.abbreviate(beerCSVRecord.getBeer(), 50))
                        .beerStyle(beerStyle)
                        .price(BigDecimal.TEN)
                        .upc(beerCSVRecord.getId().toString())
                        .quantityOnHand(beerCSVRecord.getCount())
                        .build());
            });
        }
    }

    private void loadBeerData() {
        if (beerRepository.count() == 0){
            BeerEntityS12 beer1 = BeerEntityS12.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle(BeerStyleS12.PALE_ALE)
                    .upc("12356")
                    .price(new BigDecimal("12.99"))
                    .quantityOnHand(122)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            BeerEntityS12 beer2 = BeerEntityS12.builder()
                    .beerName("Crank")
                    .beerStyle(BeerStyleS12.PALE_ALE)
                    .upc("12356222")
                    .price(new BigDecimal("11.99"))
                    .quantityOnHand(392)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            BeerEntityS12 beer3 = BeerEntityS12.builder()
                    .beerName("Sunshine City")
                    .beerStyle(BeerStyleS12.IPA)
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
            CustomerEntityS12 customer1 = CustomerEntityS12.builder()
                    .id(UUID.randomUUID())
                    .name("Customer 1")
                    .version(1)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            CustomerEntityS12 customer2 = CustomerEntityS12.builder()
                    .id(UUID.randomUUID())
                    .name("Customer 2")
                    .version(1)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            CustomerEntityS12 customer3 = CustomerEntityS12.builder()
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