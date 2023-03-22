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
//@RequestMapping("")
@RequiredArgsConstructor
@RestController
public class CustomerControllerS7 {
    public static final String CUSTOMER_PATH = "/MockMVC/api/v1/customer/";
    public static final String CUSTOMER_PATH_ID = CUSTOMER_PATH + "/{customerId}";
    private final CustomerServiceS7 customerServiceS7;

   /* @DeleteMapping("{customerId}")
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
    }*/

    @PatchMapping(CUSTOMER_PATH_ID)
    public ResponseEntity patchCustomerById(@PathVariable("customerId") UUID customerId,
                                            @RequestBody CustomerS7 customer){

        customerServiceS7.patchCustomerById(customerId, customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(CUSTOMER_PATH_ID)
    public ResponseEntity deleteCustomerById(@PathVariable("customerId") UUID customerId){

        customerServiceS7.deleteCustomerById(customerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(CUSTOMER_PATH_ID)
    public ResponseEntity updateCustomerByID(@PathVariable("customerId") UUID customerId,
                                             @RequestBody CustomerS7 customer){

        customerServiceS7.updateCustomerById(customerId, customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(CUSTOMER_PATH)
    public ResponseEntity handlePost(@RequestBody CustomerS7 customer){
        CustomerS7 savedCustomer = customerServiceS7.saveNewCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", CUSTOMER_PATH + "/" + savedCustomer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @GetMapping(CUSTOMER_PATH)
    public List<CustomerS7> listAllCustomers(){
        return customerServiceS7.getAllCustomers();
    }

    @GetMapping(value = CUSTOMER_PATH_ID)
    public CustomerS7 getCustomerById(@PathVariable("customerId") UUID id){
        return customerServiceS7.getCustomerById(id);
    }
}