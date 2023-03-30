package springFrameworkSpringBoot.S21SpringSecurityBasicAuth.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.Model.CustomerDTOS16;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.controllers.CustomerControllerS16;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.entities.CustomerEntityS16;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.mappers.CustomerMapperS16;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.repositories.CustomerRepositoryS16;
import springFrameworkSpringBoot.S8ExceptionHandling.NotFoundException;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
class CustomerControllerS21TestIT {

    @Autowired
    CustomerRepositoryS16 customerRepository;

    @Autowired
    CustomerControllerS16 customerController;

    @Autowired
    CustomerMapperS16 customerMapper;

    @Rollback
    @Transactional
    @Test
    void deleteByIdFound() {
        CustomerEntityS16 customer = customerRepository.findAll().get(0);

        ResponseEntity responseEntity = customerController.deleteCustomerById(customer.getId());
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));

        assertThat(customerRepository.findById(customer.getId()).isEmpty());
    }

    @Test
    void testDeleteNotFound() {
        assertThrows(NotFoundException.class, () -> {
            customerController.deleteCustomerById(UUID.randomUUID());
        });
    }

    @Test
    void testUpdateNotFound() {
        assertThrows(NotFoundException.class, () -> {
            customerController.updateCustomerByID(UUID.randomUUID(), CustomerDTOS16.builder().build());
        });
    }

    @Rollback
    @Transactional
    @Test
    void updateExistingBeer() {
        CustomerEntityS16 customer = customerRepository.findAll().get(0);
        CustomerDTOS16 customerDTO = customerMapper.customerEntityToCustomerDTO(customer);
        customerDTO.setId(null);
        customerDTO.setVersion(null);
        final String customerName = "UPDATED";
        customerDTO.setName(customerName);

        ResponseEntity responseEntity = customerController.updateCustomerByID(customer.getId(), customerDTO);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));

        CustomerEntityS16 updatedCustomer = customerRepository.findById(customer.getId()).get();
        assertThat(updatedCustomer.getName()).isEqualTo(customerName);
    }

    @Rollback
    @Transactional
    @Test
    void saveNewBeerTest() {
        CustomerDTOS16 customerDTO = CustomerDTOS16.builder()
                .name("TEST")
                .build();

        ResponseEntity responseEntity = customerController.handlePost(customerDTO);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
        assertThat(responseEntity.getHeaders().getLocation()).isNotNull();

        String[] locationUUID = responseEntity.getHeaders().getLocation().getPath().split("/");
        UUID savedUUID = UUID.fromString(locationUUID[4]);

        CustomerEntityS16 customer = customerRepository.findById(savedUUID).get();
        assertThat(customer).isNotNull();
    }

    @Rollback
    @Transactional
    @Test
    void testListAllEmptyList() {
        customerRepository.deleteAll();
        List<CustomerDTOS16> dtos = customerController.listAllCustomers();

        assertThat(dtos.size()).isEqualTo(0);
    }

    @Test
    void testListAll() {
        List<CustomerDTOS16> dtos = customerController.listAllCustomers();

        assertThat(dtos.size()).isEqualTo(3);
    }

    @Test
    void testGetByIdNotFound() {
        assertThrows(NotFoundException.class, () -> {
            customerController.getCustomerById(UUID.randomUUID());
        });
    }

    @Test
    void testGetById() {
        CustomerEntityS16 customer = customerRepository.findAll().get(0);
        CustomerDTOS16 customerDTO = customerController.getCustomerById(customer.getId());
        assertThat(customerDTO).isNotNull();
    }
}

