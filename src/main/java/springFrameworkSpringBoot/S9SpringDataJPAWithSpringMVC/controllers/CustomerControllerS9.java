package springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import springFrameworkSpringBoot.S8ExceptionHandling.NotFoundException;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.Model.CustomerDTO;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.services.CustomerServiceS9;

import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:57 PM
 * @Author Hazeem Hassan
 */
//@RequestMapping("")
@AllArgsConstructor
@RestController
public class CustomerControllerS9 {
    public static final String CUSTOMER_PATH = "/S9/api/v1/customer/";
    public static final String CUSTOMER_PATH_ID = CUSTOMER_PATH + "/{customerId}";
    private final CustomerServiceS9 customerServiceS9;

   /* @DeleteMapping("{customerId}")
    public ResponseEntity deleteCustomerByIdMockMVC(@PathVariable("customerId") UUID customerId){

        customeCustomerDTO.deleteCustomerById(customerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{customerId}")
    public ResponseEntity updateCustomerByIDMockMVC(@PathVariable("customerId") UUID customerId,
                                             @RequestBody CustomerDTO CustomerDTO){

        customeCustomerDTO.updateCustomerById(customerId, CustomerDTO);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity handlePostMockMVC(@RequestBody CustomerDTO CustomerDTO){
        CustomerDTO savedCustomerDTO = customeCustomerDTO.saveNewCustomer(CustomerDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/MockMVC/customer/" + savedCustomerDTO.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CustomerDTO> listAllCustomersMockMVC(){
        return customeCustomerDTO.getAllCustomers();
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public CustomerDTO getCustomerByIdMockMVC(@PathVariable("customerId") UUID id){
        return customeCustomerDTO.getCustomerById(id);
    }*/


       private final CustomerServiceS9 customerService;

       @PatchMapping(CUSTOMER_PATH_ID)
       public ResponseEntity patchCustomerById(@PathVariable("customerId") UUID customerId,
                                               @RequestBody CustomerDTO customer){

           customerService.patchCustomerById(customerId, customer);

           return new ResponseEntity(HttpStatus.NO_CONTENT);
       }

       @DeleteMapping(CUSTOMER_PATH_ID)
       public ResponseEntity deleteCustomerById(@PathVariable("customerId") UUID customerId){

           customerService.deleteCustomerById(customerId);

           return new ResponseEntity(HttpStatus.NO_CONTENT);
       }

       @PutMapping(CUSTOMER_PATH_ID)
       public ResponseEntity updateCustomerByID(@PathVariable("customerId") UUID customerId,
                                                @RequestBody CustomerDTO customer){

           customerService.updateCustomerById(customerId, customer);

           return new ResponseEntity(HttpStatus.NO_CONTENT);
       }

       @PostMapping(CUSTOMER_PATH)
       public ResponseEntity handlePost(@RequestBody CustomerDTO customer){
           CustomerDTO savedCustomer = customerService.saveNewCustomer(customer);

           HttpHeaders headers = new HttpHeaders();
           headers.add("Location", CUSTOMER_PATH + "/" + savedCustomer.getId().toString());

           return new ResponseEntity(headers, HttpStatus.CREATED);
       }

       @GetMapping(CUSTOMER_PATH)
       public List<CustomerDTO> listAllCustomers(){
           return customerService.getAllCustomers();
       }

       @GetMapping(value = CUSTOMER_PATH_ID)
       public CustomerDTO getCustomerById(@PathVariable("customerId") UUID id){
           return customerService.getCustomerById(id).orElseThrow(NotFoundException::new);
       }

   }