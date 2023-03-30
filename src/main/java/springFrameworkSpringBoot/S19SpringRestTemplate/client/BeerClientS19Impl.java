package springFrameworkSpringBoot.S19SpringRestTemplate.client;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import springFrameworkSpringBoot.BeerStyle;
import springFrameworkSpringBoot.S19SpringRestTemplate.model.BeerDTOPageImpl;
import springFrameworkSpringBoot.S19SpringRestTemplate.model.BeerDTOS19;

import java.net.URI;
import java.util.UUID;

/**
 * @Created 29 03 2023 - 1:42 PM
 * @Author Hazeem Hassan
 */
@Service
@RequiredArgsConstructor
public class BeerClientS19Impl implements BeerClientS19 {

    private final RestTemplateBuilder restTemplateBuilder;

    private final static String GET_BEER_PATH = "/api/v1/beer";
    private final static String GET_BEER_BY_ID_PATH = "/api/v1/beer/{beerID}";

    @Override
    public void deleteBeer(UUID beerId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(GET_BEER_BY_ID_PATH, beerId);
    }

    @Override
    public BeerDTOS19 createBeer(BeerDTOS19 newDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        URI uri = restTemplate.postForLocation(GET_BEER_PATH, newDto);
        return restTemplate.getForObject(uri.getPath(), BeerDTOS19.class);
    }

    @Override
    public BeerDTOS19 updateBeer(BeerDTOS19 beerDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.put(GET_BEER_BY_ID_PATH, beerDto, beerDto.getId());
        return getBeerById(beerDto.getId());
    }

    @Override
    public BeerDTOS19 getBeerById(UUID beerID) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        return restTemplate.getForObject(GET_BEER_BY_ID_PATH, BeerDTOS19.class, beerID);
    }

    @Override
    public Page<BeerDTOS19> listBeers() {
        return this.listBeers(null, null, null, null, null);
    }

    @Override
    public Page<BeerDTOS19> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber,
                                      Integer pageSize) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath(GET_BEER_PATH);

        if (beerName != null) {
            uriComponentsBuilder.queryParam("beerName", beerName);
        }

        if (beerStyle != null) {
            uriComponentsBuilder.queryParam("beerStyle", beerStyle);
        }

        if (showInventory != null) {
            uriComponentsBuilder.queryParam("showInventory", beerStyle);
        }

        if (pageNumber != null) {
            uriComponentsBuilder.queryParam("pageNumber", beerStyle);
        }

        if (pageSize != null) {
            uriComponentsBuilder.queryParam("pageSize", beerStyle);
        }


        ResponseEntity<BeerDTOPageImpl> response =
                restTemplate.getForEntity(uriComponentsBuilder.toUriString(), BeerDTOPageImpl.class);


        return response.getBody();
    }
   /* @Override
    public Page<BeerDTOS19> listBeers(String beerName) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        *//** String
     * *//*
        ResponseEntity<String> stringResponse =
                restTemplate.getForEntity(GET_BEER_PATH, String.class);
        *//*System.out.println("String Response Starts Here");
        System.out.println(stringResponse.getBody());
        System.out.println("String Response Ends Here");*//*
     *//** Map
     * *//*
        ResponseEntity<Map> mapResponse =
                restTemplate.getForEntity(GET_BEER_PATH, Map.class);
        *//** Json node
     * *//*

        ResponseEntity<JsonNode> jsonNodeResponse =
                restTemplate.getForEntity(GET_BEER_PATH, JsonNode.class);

        jsonNodeResponse.getBody().findPath("content")
                        .elements().forEachRemaining(
                                node ->{System.out.println(node.get("beerName").asText());}

                );
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath(GET_BEER_PATH);

        if(beerName!=null){
            uriComponentsBuilder.queryParam("beerName",beerName );
        }
        *//** Page impl
     * *//*
        ResponseEntity<BeerDTPPageImpl> pageResponse =
        restTemplate.getForEntity(GET_BEER_PATH, BeerDTPPageImpl.class);

        return null;
    }*/
}
