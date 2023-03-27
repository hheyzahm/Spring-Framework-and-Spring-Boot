package springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.mappers;

import org.mapstruct.Mapper;

import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.Model.BeerDTOS14;
import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.entities.BeerEntityS14;



/**
 * @Created 20 03 2023 - 12:02 PM
 * @Author Hazeem Hassan
 */
@Mapper
public interface BeerMapperS14 {
    BeerEntityS14 beerDTOtoBeerEntity(BeerDTOS14 beerDTO);
    BeerDTOS14 beerEntityToBeerDTO(BeerEntityS14 beer);
}
