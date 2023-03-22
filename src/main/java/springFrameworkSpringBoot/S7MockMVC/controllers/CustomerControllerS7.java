package springFrameworkSpringBoot.S7MockMVC.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springFrameworkSpringBoot.S7MockMVC.Model.CustomerS7;
import springFrameworkSpringBoot.S7MockMVC.services.CustomerServiceS7;

import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:57 PM
 * @Author Hazeem Hassan
 */
@RequestMapping("/api/v1/MockMVC/customer/")
@RequiredArgsConstructor
@RestController
public class CustomerControllerS7 {

    private final CustomerServiceS7 customerServiceS7;

    @DeleteMapping("{customerId}")
    public ResponseEntity deleteCustomerByIdMockMVC(@PathVariable("customerId") UUID customerId){

        customerServiceS7.deleteCustomerById(customerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{customerId}")
    public ResponseEntity updateCustomerByIDMockMVC(@PathVariable("customerId") UUID customerId,
                                             @RequestBody CustomerS7 customerS7){

        customerServiceS7.updateCustomerById(customerId, customerS7);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity handlePostMockMVC(@RequestBody CustomerS7 customerS7){
        CustomerS7 savedCustomerS7 = customerServiceS7.saveNewCustomer(customerS7);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/MockMVC/customer/" + savedCustomerS7.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CustomerS7> listAllCustomersMockMVC(){
        return customerServiceS7.getAllCustomers();
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public CustomerS7 getCustomerByIdMockMVC(@PathVariable("customerId") UUID id){
        return customerServiceS7.getCustomerById(id);
    }

}