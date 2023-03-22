package springFrameworkSpringBoot.S7MockMVC.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import springFrameworkSpringBoot.S7MockMVC.Model.BeerS7;
import springFrameworkSpringBoot.S7MockMVC.services.BeerServiceS7;
import springFrameworkSpringBoot.S7MockMVC.services.BeerServiceS7Impl;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
@WebMvcTest(BeerControllerS7.class)
class BeerControllerS7Test {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BeerServiceS7 beerServiceS7;
    BeerServiceS7Impl beerServiceS7Impl= new BeerServiceS7Impl();

    @Test
    void getBeerById() throws Exception {
        BeerS7 testBeerS7 =beerServiceS7Impl.listBeers().get(0);
        given(beerServiceS7.getBeerById(testBeerS7.getId()))
                .willReturn(testBeerS7);
        mockMvc.perform(get("/MockMVC/api/v1/beer" + UUID.randomUUID())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                ;

    }
}