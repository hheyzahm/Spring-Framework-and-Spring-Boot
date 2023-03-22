package springFrameworkSpringBoot.S10DataValidation.mappers;

import org.mapstruct.Mapper;
import springFrameworkSpringBoot.S10DataValidation.Model.BeerDTOS10;
import springFrameworkSpringBoot.S10DataValidation.entities.BeerEntityS10;

/**
 * @Created 20 03 2023 - 12:02 PM
 * @Author Hazeem Hassan
 */
@Mapper
public interface BeerMapperS10 {
    BeerEntityS10 beerDTOtoBeerEntity(BeerDTOS10 beerDTOS10);
    BeerDTOS10 beerEntityToBeerDTO(BeerEntityS10 beer);
}
