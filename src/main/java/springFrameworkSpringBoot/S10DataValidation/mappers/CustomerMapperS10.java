package springFrameworkSpringBoot.S10DataValidation.mappers;

import org.mapstruct.Mapper;
import springFrameworkSpringBoot.S10DataValidation.Model.CustomerDTOS10;
import springFrameworkSpringBoot.S10DataValidation.entities.CustomerEntityS10;

/**
 * @Created 20 03 2023 - 12:02 PM
 * @Author Hazeem Hassan
 */
@Mapper
public interface CustomerMapperS10 {
    CustomerEntityS10 customerDTOtoCustomerEntity(CustomerDTOS10 customerDTOS10);
    CustomerDTOS10 customerEntityToCustomerDTO(CustomerEntityS10 customerEntityS10);
}
