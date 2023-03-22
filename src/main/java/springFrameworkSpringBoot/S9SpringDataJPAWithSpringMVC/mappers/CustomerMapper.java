package springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.mappers;


import org.mapstruct.Mapper;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.Entities.CustomerEntity;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.Model.CustomerDTO;

/**
 * @Created 20 03 2023 - 12:02 PM
 * @Author Hazeem Hassan
 */
@Mapper
public interface CustomerMapper {
    CustomerEntity customeerDTOtoCustomerEntity(CustomerDTO customerDTO);
    CustomerDTO cutomerEnityToCustomerDTO(CustomerEntity customerEntity);
}
