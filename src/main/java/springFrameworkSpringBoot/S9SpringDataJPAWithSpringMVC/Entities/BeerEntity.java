package springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.*;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.Model.BeerStyleS9;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Created 22 03 2023 - 4:03 PM
 * @Author Hazeem Hassan
 */
@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BeerEntity {
    @Id
    private UUID id;
    @Version
    private Integer version;
    private String beerName;
    private BeerStyleS9 beerStyleS9;
    private String upc;
    private Integer quantityOnHand;
    private BigDecimal price;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}
