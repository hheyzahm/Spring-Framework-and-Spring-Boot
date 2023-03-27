package springFrameworkSpringBoot.S12FlywayMigrations.mappers;

import org.mapstruct.Mapper;

import springFrameworkSpringBoot.S12FlywayMigrations.Model.CustomerDTOS12;
import springFrameworkSpringBoot.S12FlywayMigrations.entities.CustomerEntityS12;


/**
 * @Created 20 03 2023 - 12:02 PM
 * @Author Hazeem Hassan
 */
@Mapper
public interface CustomerMapperS12 {
    CustomerEntityS12 customerDTOtoCustomerEntity(CustomerDTOS12 customerDTO);
    CustomerDTOS12 customerEntityToCustomerDTO(CustomerEntityS12 customerEntityS10);
}
