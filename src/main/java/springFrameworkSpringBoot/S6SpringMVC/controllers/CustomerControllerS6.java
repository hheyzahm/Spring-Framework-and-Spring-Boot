package springFrameworkSpringBoot.S6SpringMVC.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springFrameworkSpringBoot.S6SpringMVC.Model.CustomerS6;
import springFrameworkSpringBoot.S6SpringMVC.services.CustomerServiceS6;

import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:57 PM
 * @Author Hazeem Hassan
 */
@RequestMapping("/SpringMVC/api/v1/MockMVC/customer/")
@RequiredArgsConstructor
@RestController
public class CustomerControllerS6 {

    private final CustomerServiceS6 customerServiceS6;

    @DeleteMapping("{customerId}")
    public ResponseEntity deleteCustomerByIdSpringMVC(@PathVariable("customerId") UUID customerId){

        customerServiceS6.deleteCustomerById(customerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{customerId}")
    public ResponseEntity updateCustomerByIDSpringMVC(@PathVariable("customerId") UUID customerId,
                                             @RequestBody CustomerS6 customerS6){

        customerServiceS6.updateCustomerById(customerId, customerS6);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity handlePostSpringMVC(@RequestBody CustomerS6 customerS6){
        CustomerS6 savedCustomerS6 = customerServiceS6.saveNewCustomer(customerS6);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/MockMVC/customer/" + savedCustomerS6.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CustomerS6> listAllCustomersSpringMVC(){
        return customerServiceS6.getAllCustomers();
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public CustomerS6 getCustomerByIdSpringMVC(@PathVariable("customerId") UUID id){
        return customerServiceS6.getCustomerById(id);
    }

}