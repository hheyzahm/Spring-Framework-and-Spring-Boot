package springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.mappers;

import org.mapstruct.Mapper;
import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.Model.CustomerDTOS14;
import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.entities.CustomerEntityS14;


/**
 * @Created 20 03 2023 - 12:02 PM
 * @Author Hazeem Hassan
 */
@Mapper
public interface CustomerMapperS14 {
    CustomerEntityS14 customerDTOtoCustomerEntity(CustomerDTOS14 customerDTO);
    CustomerDTOS14 customerEntityToCustomerDTO(CustomerEntityS14 customerEntityS10);
}
