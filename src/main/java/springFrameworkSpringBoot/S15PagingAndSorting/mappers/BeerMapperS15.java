package springFrameworkSpringBoot.S15PagingAndSorting.mappers;

import org.mapstruct.Mapper;
import springFrameworkSpringBoot.S15PagingAndSorting.Model.BeerDTOS15;
import springFrameworkSpringBoot.S15PagingAndSorting.entities.BeerEntityS15;


/**
 * @Created 20 03 2023 - 12:02 PM
 * @Author Hazeem Hassan
 */
@Mapper
public interface BeerMapperS15 {
    BeerEntityS15 beerDTOtoBeerEntity(BeerDTOS15 beerDTO);
    BeerDTOS15 beerEntityToBeerDTO(BeerEntityS15 beer);
}
