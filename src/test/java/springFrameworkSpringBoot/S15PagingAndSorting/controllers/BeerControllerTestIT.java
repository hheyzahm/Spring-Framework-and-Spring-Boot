package springFrameworkSpringBoot.S15PagingAndSorting.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import springFrameworkSpringBoot.BeerStyle;
import springFrameworkSpringBoot.S15PagingAndSorting.Model.BeerDTOS15;
import springFrameworkSpringBoot.S15PagingAndSorting.entities.BeerEntityS15;
import springFrameworkSpringBoot.S15PagingAndSorting.mappers.BeerMapperS15;
import springFrameworkSpringBoot.S15PagingAndSorting.repositories.BeerRepositoryS15;
import springFrameworkSpringBoot.S8ExceptionHandling.NotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class BeerControllerTestIT {
    @Autowired
    BeerControllerS15 beerController;

    @Autowired
    BeerRepositoryS15 beerRepository;

    @Autowired
    BeerMapperS15 beerMapper;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void tesListBeersByStyleAndNameShowInventoryTruePage2() throws Exception {
        mockMvc.perform(get(BeerControllerS15.BEER_PATH).queryParam("beerName", "IPA").queryParam("beerStyle", BeerStyle.IPA.name()).queryParam("showInventory", "true").queryParam("pageNumber", "2").queryParam("pageSize", "50")).andExpect(status().isOk()).andExpect(jsonPath("$.content.size()", is(50))).andExpect(jsonPath("$.content[0].quantityOnHand").value(IsNull.notNullValue()));
    }

    @Test
    void tesListBeersByStyleAndNameShowInventoryTrue() throws Exception {
        mockMvc.perform(get(BeerControllerS15.BEER_PATH).queryParam("beerName", "IPA").queryParam("beerStyle", BeerStyle.IPA.name()).queryParam("showInventory", "true").queryParam("pageSize", "800")).andExpect(status().isOk()).andExpect(jsonPath("$.content.size()", is(310))).andExpect(jsonPath("$.content[0].quantityOnHand").value(IsNull.notNullValue()));
    }

    @Test
    void tesListBeersByStyleAndNameShowInventoryFalse() throws Exception {
        mockMvc.perform(get(BeerControllerS15.BEER_PATH).queryParam("beerName", "IPA").queryParam("beerStyle", BeerStyle.IPA.name()).queryParam("showInventory", "false").queryParam("pageSize", "800")).andExpect(status().isOk()).andExpect(jsonPath("$.content.size()", is(310))).andExpect(jsonPath("$.content[0].quantityOnHand").value(IsNull.nullValue()));
    }

    @Test
    void tesListBeersByStyleAndName() throws Exception {
        mockMvc.perform(get(BeerControllerS15.BEER_PATH).queryParam("beerName", "IPA").queryParam("beerStyle", BeerStyle.IPA.name()).queryParam("pageSize", "800")).andExpect(status().isOk()).andExpect(jsonPath("$.content.size()", is(310)));
    }

    @Test
    void tesListBeersByStyle() throws Exception {
        mockMvc.perform(get(BeerControllerS15.BEER_PATH).queryParam("beerStyle", BeerStyle.IPA.name()).queryParam("pageSize", "800")).andExpect(status().isOk()).andExpect(jsonPath("$.content.size()", is(548)));
    }

    @Test
    void tesListBeersByName() throws Exception {
        mockMvc.perform(get(BeerControllerS15.BEER_PATH).queryParam("beerName", "IPA").queryParam("pageSize", "800")).andExpect(status().isOk()).andExpect(jsonPath("$.content.size()", is(336)));
    }

    @Test
    void testPatchBeerBadName() throws Exception {
        BeerEntityS15 beer = beerRepository.findAll().get(0);

        Map<String, Object> beerMap = new HashMap<>();
        beerMap.put("beerName", "New Name 1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");

        mockMvc.perform(patch(BeerControllerS15.BEER_PATH_ID, beer.getId()).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(beerMap))).andExpect(status().isBadRequest());

    }

    @Test
    void testDeleteByIDNotFound() {
        assertThrows(NotFoundException.class, () -> {
            beerController.deleteById(UUID.randomUUID());
        });
    }

    @Rollback
    @Transactional
    @Test
    void deleteByIdFound() {
        BeerEntityS15 beer = beerRepository.findAll().get(0);

        ResponseEntity responseEntity = beerController.deleteById(beer.getId());
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));

        assertThat(beerRepository.findById(beer.getId()).isEmpty());
    }

    @Test
    void testUpdateNotFound() {
        assertThrows(NotFoundException.class, () -> {
            beerController.updateById(UUID.randomUUID(), BeerDTOS15.builder().build());
        });
    }

    @Rollback
    @Transactional
    @Test
    void updateExistingBeer() {
        BeerEntityS15 beer = beerRepository.findAll().get(0);
        BeerDTOS15 beerDTO = beerMapper.beerEntityToBeerDTO(beer);
        beerDTO.setId(null);
        beerDTO.setVersion(null);
        final String beerName = "UPDATED";
        beerDTO.setBeerName(beerName);

        ResponseEntity responseEntity = beerController.updateById(beer.getId(), beerDTO);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));

        BeerEntityS15 updatedBeer = beerRepository.findById(beer.getId()).get();
        assertThat(updatedBeer.getBeerName()).isEqualTo(beerName);
    }

    @Rollback
    @Transactional
    @Test
    void saveNewBeerTest() {
        BeerDTOS15 beerDTO = BeerDTOS15.builder().beerName("New Beer").build();

        ResponseEntity responseEntity = beerController.handlePost(beerDTO);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
        assertThat(responseEntity.getHeaders().getLocation()).isNotNull();

        String[] locationUUID = responseEntity.getHeaders().getLocation().getPath().split("/");
        UUID savedUUID = UUID.fromString(locationUUID[4]);

        BeerEntityS15 beer = beerRepository.findById(savedUUID).get();
        assertThat(beer).isNotNull();
    }

    @Test
    void testBeerIdNotFound() {
        assertThrows(NotFoundException.class, () -> {
            beerController.getBeerById(UUID.randomUUID());
        });
    }

    @Test
    void testGetById() {
        BeerEntityS15 beer = beerRepository.findAll().get(0);

        BeerDTOS15 dto = beerController.getBeerById(beer.getId());

        assertThat(dto).isNotNull();
    }

    @Test
    void testListBeers() {
        Page<BeerDTOS15> dtos = beerController.listBeers(null, null, false, 1, 2413);

        assertThat(dtos.getContent().size()).isEqualTo(1000);
    }

    @Rollback
    @Transactional
    @Test
    void testEmptyList() {
        beerRepository.deleteAll();
        Page<BeerDTOS15> dtos = beerController.listBeers(null, null, false, 1, 25);

        assertThat(dtos.getContent().size()).isEqualTo(0);
    }
}
