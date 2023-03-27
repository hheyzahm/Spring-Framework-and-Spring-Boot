package springFrameworkSpringBoot.S12FlywayMigrations.mappers;

import org.mapstruct.Mapper;

import springFrameworkSpringBoot.S12FlywayMigrations.Model.BeerDTOS12;
import springFrameworkSpringBoot.S12FlywayMigrations.entities.BeerEntityS12;



/**
 * @Created 20 03 2023 - 12:02 PM
 * @Author Hazeem Hassan
 */
@Mapper
public interface BeerMapperS12 {
    BeerEntityS12 beerDTOtoBeerEntity(BeerDTOS12 beerDTO);
    BeerDTOS12 beerEntityToBeerDTO(BeerEntityS12 beer);
}
