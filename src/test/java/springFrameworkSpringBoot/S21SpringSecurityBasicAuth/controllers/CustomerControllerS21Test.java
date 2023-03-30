package springFrameworkSpringBoot.S21SpringSecurityBasicAuth.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.Model.CustomerDTOS16;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.controllers.CustomerControllerS16;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.services.CustomerServiceS16;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.services.CustomerServiceS16Impl;
import springFrameworkSpringBoot.S21SpringSecurityBasicAuth.config.SpringSecurityConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@WebMvcTest(CustomerControllerS16.class)
@Import(SpringSecurityConfig.class)
class CustomerControllerS21Test {

    @MockBean
    CustomerServiceS16 customerService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    CustomerServiceS16Impl customerServiceImpl;

    @BeforeEach
    void setUp() {
        customerServiceImpl = new CustomerServiceS16Impl();
    }

    @Captor
    ArgumentCaptor<UUID> uuidArgumentCaptor;

    @Captor
    ArgumentCaptor<CustomerDTOS16> customerArgumentCaptor;

    @Test
    void testPatchCustomer() throws Exception {
        CustomerDTOS16 customer = customerServiceImpl.getAllCustomers().get(0);

        Map<String, Object> customerMap = new HashMap<>();
        customerMap.put("name", "New Name");

        mockMvc.perform(patch( CustomerControllerS16.CUSTOMER_PATH_ID, customer.getId())
                        .with(httpBasic(BeerControllerS21Test.USERNAME, BeerControllerS21Test.PASSWORD))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerMap)))
                .andExpect(status().isNoContent());

        verify(customerService).patchCustomerById(uuidArgumentCaptor.capture(),
                customerArgumentCaptor.capture());

        assertThat(uuidArgumentCaptor.getValue()).isEqualTo(customer.getId());
        assertThat(customerArgumentCaptor.getValue().getName())
                .isEqualTo(customerMap.get("name"));
    }

    @Test
    void testDeleteCustomer() throws Exception {
        CustomerDTOS16 customer = customerServiceImpl.getAllCustomers().get(0);

        given(customerService.deleteCustomerById(any())).willReturn(true);

        mockMvc.perform(delete(CustomerControllerS16.CUSTOMER_PATH_ID, customer.getId())
                        .with(httpBasic(BeerControllerS21Test.USERNAME, BeerControllerS21Test.PASSWORD))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(customerService).deleteCustomerById(uuidArgumentCaptor.capture());

        assertThat(customer.getId()).isEqualTo(uuidArgumentCaptor.getValue());
    }

    @Test
    void testUpdateCustomer() throws Exception {
        CustomerDTOS16 customer = customerServiceImpl.getAllCustomers().get(0);

        given(customerService.updateCustomerById(any(), any())).willReturn(Optional.of(CustomerDTOS16.builder()
                .build()));

        mockMvc.perform(put(CustomerControllerS16.CUSTOMER_PATH_ID, customer.getId())
                        .with(httpBasic(BeerControllerS21Test.USERNAME, BeerControllerS21Test.PASSWORD))
                        .content(objectMapper.writeValueAsString(customer))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(customerService).updateCustomerById(uuidArgumentCaptor.capture(), any(CustomerDTOS16.class));

        assertThat(customer.getId()).isEqualTo(uuidArgumentCaptor.getValue());
    }

    @Test
    void testCreateCustomer() throws Exception {
        CustomerDTOS16 customer = customerServiceImpl.getAllCustomers().get(0);
        customer.setId(null);
        customer.setVersion(null);

        given(customerService.saveNewCustomer(any(CustomerDTOS16.class)))
                .willReturn(customerServiceImpl.getAllCustomers().get(1));

        mockMvc.perform(post(CustomerControllerS16.CUSTOMER_PATH).contentType(MediaType.APPLICATION_JSON)
                        .with(httpBasic(BeerControllerS21Test.USERNAME, BeerControllerS21Test.PASSWORD))
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"));
    }

    @Test
    void listAllCustomers() throws Exception {
        given(customerService.getAllCustomers()).willReturn(customerServiceImpl.getAllCustomers());

        mockMvc.perform(get(CustomerControllerS16.CUSTOMER_PATH)
                        .with(httpBasic(BeerControllerS21Test.USERNAME, BeerControllerS21Test.PASSWORD))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(3)));
    }

    @Test
    void getCustomerByIdNotFound() throws Exception {

        given(customerService.getCustomerById(any(UUID.class))).willReturn(Optional.empty());

        mockMvc.perform(get(CustomerControllerS16.CUSTOMER_PATH_ID, UUID.randomUUID())
                        .with(httpBasic(BeerControllerS21Test.USERNAME, BeerControllerS21Test.PASSWORD)))
                .andExpect(status().isNotFound());
    }

    @Test
    void getCustomerById() throws Exception {
        CustomerDTOS16 customer = customerServiceImpl.getAllCustomers().get(0);

        given(customerService.getCustomerById(customer.getId())).willReturn(Optional.of(customer));

        mockMvc.perform(get(CustomerControllerS16.CUSTOMER_PATH_ID, customer.getId())
                        .with(httpBasic(BeerControllerS21Test.USERNAME, BeerControllerS21Test.PASSWORD))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is(customer.getName())));
    }
}



