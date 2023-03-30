package springFrameworkSpringBoot.S19SpringRestTemplate.model;

import lombok.Builder;
import lombok.Data;
import springFrameworkSpringBoot.BeerStyle;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
/**
 * @Created 29 03 2023 - 1:16 PM
 * @Author Hazeem Hassan
 */
@Builder
@Data
public class BeerDTOS19 {
    private UUID id;
    private Integer version;
    private String beerName;
    private BeerStyle beerStyle;
    private String upc;
    private Integer quantityOnHand;
    private BigDecimal price;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}