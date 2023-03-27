package springFrameworkSpringBoot.S11MySQLWithSpringBoot.mappers;

import org.mapstruct.Mapper;
import springFrameworkSpringBoot.S11MySQLWithSpringBoot.Model.BeerDTOS11;
import springFrameworkSpringBoot.S11MySQLWithSpringBoot.entities.BeerEntityS11;

/**
 * @Created 20 03 2023 - 12:02 PM
 * @Author Hazeem Hassan
 */
@Mapper
public interface BeerMapperS11 {
    BeerEntityS11 beerDTOtoBeerEntity(BeerDTOS11 beerDTOS11);
    BeerDTOS11 beerEntityToBeerDTO(BeerEntityS11 beer);
}
