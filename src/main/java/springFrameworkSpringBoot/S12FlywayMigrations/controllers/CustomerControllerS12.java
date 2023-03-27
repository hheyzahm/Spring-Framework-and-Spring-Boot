package springFrameworkSpringBoot.S12FlywayMigrations.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springFrameworkSpringBoot.S12FlywayMigrations.Model.CustomerDTOS12;
import springFrameworkSpringBoot.S12FlywayMigrations.services.CustomerServiceS12;
import springFrameworkSpringBoot.S8ExceptionHandling.NotFoundException;


import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:57 PM
 * @Author Hazeem Hassan
 */
//@RequestMapping("/api/v1/MockMVC/customer/")
@RequiredArgsConstructor
@RestController
public class CustomerControllerS12 {
    public static final String CUSTOMER_PATH = "/S12/api/v1/customer";
    public static final String CUSTOMER_PATH_ID = CUSTOMER_PATH + "/{customerId}";

    private final CustomerServiceS12 customerService;

    @PatchMapping(CUSTOMER_PATH_ID)
    public ResponseEntity patchCustomerById(@PathVariable("customerId") UUID customerId,
                                            @RequestBody CustomerDTOS12 customer){

        customerService.patchCustomerById(customerId, customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(CUSTOMER_PATH_ID)
    public ResponseEntity deleteCustomerById(@PathVariable("customerId") UUID customerId){

        if (!customerService.deleteCustomerById(customerId)){
            throw new NotFoundException();
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(CUSTOMER_PATH_ID)
    public ResponseEntity updateCustomerByID(@PathVariable("customerId") UUID customerId,
                                             @RequestBody CustomerDTOS12 customer){

        if (customerService.updateCustomerById(customerId, customer).isEmpty()){
            throw new NotFoundException();
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(CUSTOMER_PATH)
    public ResponseEntity handlePost(@RequestBody CustomerDTOS12 customer){
        CustomerDTOS12 savedCustomer = customerService.saveNewCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", CUSTOMER_PATH + "/" + savedCustomer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @GetMapping(CUSTOMER_PATH)
    public List<CustomerDTOS12> listAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(value = CUSTOMER_PATH_ID)
    public CustomerDTOS12 getCustomerById(@PathVariable("customerId") UUID id){
        return customerService.getCustomerById(id).orElseThrow(NotFoundException::new);
    }
}