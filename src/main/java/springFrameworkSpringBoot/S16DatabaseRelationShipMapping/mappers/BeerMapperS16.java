package springFrameworkSpringBoot.S16DatabaseRelationShipMapping.mappers;

import org.mapstruct.Mapper;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.Model.BeerDTOS16;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.entities.BeerEntityS16;


/**
 * @Created 20 03 2023 - 12:02 PM
 * @Author Hazeem Hassan
 */
@Mapper
public interface BeerMapperS16 {
    BeerEntityS16 beerDTOtoBeerEntity(BeerDTOS16 beerDTO);
    BeerDTOS16 beerEntityToBeerDTO(BeerEntityS16 beer);
}
