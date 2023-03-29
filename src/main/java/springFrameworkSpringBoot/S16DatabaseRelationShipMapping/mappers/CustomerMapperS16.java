package springFrameworkSpringBoot.S16DatabaseRelationShipMapping.mappers;

import org.mapstruct.Mapper;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.Model.CustomerDTOS16;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.entities.CustomerEntityS16;

/**
 * @Created 20 03 2023 - 12:02 PM
 * @Author Hazeem Hassan
 */
@Mapper
public interface CustomerMapperS16 {
    CustomerEntityS16 customerDTOtoCustomerEntity(CustomerDTOS16  customerDTO);
    CustomerDTOS16 customerEntityToCustomerDTO(CustomerEntityS16 customerEntityS10);
}
