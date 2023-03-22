package springFrameworkSpringBoot.S4ProjectLombok.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import springFrameworkSpringBoot.S4ProjectLombok.Model.BeerPL;
import springFrameworkSpringBoot.S4ProjectLombok.Model.BeerStylePL;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:01 PM
 * @Author Hazeem Hassan
 */

@Slf4j
@Service
public class BeerServicePLImpl implements BeerServicePL {
    @Override
    public BeerPL getBeerByID(UUID uuidID) {
        log.debug("Get Beer by Id - in service. Id: " + uuidID.toString());
        return BeerPL.builder()
                .id(uuidID)
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStylePL.PALE_ALE)
                .upc("12356")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
    }
}
