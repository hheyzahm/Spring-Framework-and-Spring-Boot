package springFrameworkSpringBoot.S19SpringRestTemplate.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.web.client.HttpClientErrorException;
import springFrameworkSpringBoot.BeerStyle;
import springFrameworkSpringBoot.S19SpringRestTemplate.model.BeerDTOS19;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerClientS20ImplTest {

    @Autowired
    BeerClientS19Impl beerClient;
    @Test
    void listBeersNoBeerName() {

        beerClient.listBeers(null, null, null, null, null);
    }
    @Test
    void testCreateBeer() {

        BeerDTOS19 newDto = BeerDTOS19.builder()
                .price(new BigDecimal("10.99"))
                .beerName("Mango Bobs")
                .beerStyle(BeerStyle.IPA)
                .quantityOnHand(500)
                .upc("123245")
                .build();

        BeerDTOS19 savedDto = beerClient.createBeer(newDto);
        assertNotNull(savedDto);
    }

    @Test
    void listBeers() {

        beerClient.listBeers("ALE", null, null, null, null);
    }

    @Test
    void getBeerByID() {
        Page<BeerDTOS19> beerDTOS = beerClient.listBeers();

        BeerDTOS19 dto = beerDTOS.getContent().get(0);

        BeerDTOS19 byID= beerClient.getBeerById(dto.getId());
        assertNotNull(byID);
    }
    @Test
    void testDeleteBeer() {
        BeerDTOS19 newDto = BeerDTOS19.builder()
                .price(new BigDecimal("10.99"))
                .beerName("Mango Bobs 2")
                .beerStyle(BeerStyle.IPA)
                .quantityOnHand(500)
                .upc("123245")
                .build();

        BeerDTOS19 beerDto = beerClient.createBeer(newDto);

        beerClient.deleteBeer(beerDto.getId());

        assertThrows(HttpClientErrorException.class, () -> {
            //should error
            beerClient.getBeerById(beerDto.getId());
        });
    }

    @Test
    void testUpdateBeer() {

        BeerDTOS19 newDto = BeerDTOS19.builder()
                .price(new BigDecimal("10.99"))
                .beerName("Mango Bobs 2")
                .beerStyle(BeerStyle.IPA)
                .quantityOnHand(500)
                .upc("123245")
                .build();

        BeerDTOS19 beerDto = beerClient.createBeer(newDto);

        final String newName = "Mango Bobs 3";
        beerDto.setBeerName(newName);
        BeerDTOS19 updatedBeer = beerClient.updateBeer(beerDto);

        assertEquals(newName, updatedBeer.getBeerName());
    }
}




















