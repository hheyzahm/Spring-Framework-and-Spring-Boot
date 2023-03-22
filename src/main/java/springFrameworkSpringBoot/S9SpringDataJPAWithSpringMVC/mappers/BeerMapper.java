package springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.mappers;

import org.mapstruct.Mapper;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.Entities.BeerEntity;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.Model.BeerDTO;

/**
 * @Created 20 03 2023 - 12:02 PM
 * @Author Hazeem Hassan
 */
@Mapper
public interface BeerMapper {
    BeerEntity beerDTOtoBeerEntity(BeerDTO beerDTO);
    BeerDTO beerEntitytoBeerDTO(BeerEntity beer);
}
