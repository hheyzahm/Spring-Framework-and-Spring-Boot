package springFrameworkSpringBoot.S15PagingAndSorting.mappers;

import org.mapstruct.Mapper;
import springFrameworkSpringBoot.S15PagingAndSorting.Model.CustomerDTOS15;
import springFrameworkSpringBoot.S15PagingAndSorting.entities.CustomerEntityS15;

/**
 * @Created 20 03 2023 - 12:02 PM
 * @Author Hazeem Hassan
 */
@Mapper
public interface CustomerMapperS15 {
    CustomerEntityS15 customerDTOtoCustomerEntity(CustomerDTOS15 customerDTO);
    CustomerDTOS15 customerEntityToCustomerDTO(CustomerEntityS15 customerEntityS10);
}
