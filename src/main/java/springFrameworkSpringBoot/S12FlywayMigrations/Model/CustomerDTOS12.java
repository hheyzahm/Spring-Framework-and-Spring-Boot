package springFrameworkSpringBoot.S12FlywayMigrations.Model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:53 PM
 * @Author Hazeem Hassan
 */
@Data
@Builder
public class CustomerDTOS12 {

    private UUID id;
    private String name;
    private Integer version;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}