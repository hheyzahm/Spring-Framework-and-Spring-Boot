package springFrameworkSpringBoot.S11MySQLWithSpringBoot.mappers;

import org.mapstruct.Mapper;
import springFrameworkSpringBoot.S11MySQLWithSpringBoot.Model.CustomerDTOS11;
import springFrameworkSpringBoot.S11MySQLWithSpringBoot.entities.CustomerEntityS11;

/**
 * @Created 20 03 2023 - 12:02 PM
 * @Author Hazeem Hassan
 */
@Mapper
public interface CustomerMapperS11 {
    CustomerEntityS11 customerDTOtoCustomerEntity(CustomerDTOS11 customerDTOS11);
    CustomerDTOS11 customerEntityToCustomerDTO(CustomerEntityS11 customerEntityS10);
}
