package springFrameworkSpringBoot.S7MockMVC.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springFrameworkSpringBoot.S7MockMVC.Model.BeerS7;
import springFrameworkSpringBoot.S7MockMVC.services.BeerServiceS7;
import springFrameworkSpringBoot.S8ExceptionHandling.NotFoundException;

import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:05 PM
 * @Author Hazeem Hassan
 */
@Slf4j
@RequiredArgsConstructor
@RestController
//@RequestMapping("/api/v1/MockMVC/beer/")
public class BeerControllerS7 {

    public static final String BEER_PATH = "/MockMVC/api/v1/beer";
    public static final String BEER_PATH_ID = BEER_PATH + "/{beerId}";
    private final BeerServiceS7 beerServiceS7;

    @PatchMapping(BEER_PATH_ID)
    public ResponseEntity updateBeerPatchById(@PathVariable("beerId") UUID beerId, @RequestBody BeerS7 beer) {

        beerServiceS7.patchBeerById(beerId, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(BEER_PATH_ID)
    public ResponseEntity deleteById(@PathVariable("beerId") UUID beerId) {

        beerServiceS7.deleteById(beerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(BEER_PATH_ID)
    public ResponseEntity updateById(@PathVariable("beerId") UUID beerId, @RequestBody BeerS7 beer) {

        beerServiceS7.updateBeerById(beerId, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(BEER_PATH)
    public ResponseEntity handlePost(@RequestBody BeerS7 beer) {

        BeerS7 savedBeer = beerServiceS7.saveNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", BEER_PATH + "/" + savedBeer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = BEER_PATH)
    public List<BeerS7> listBeers() {
        return beerServiceS7.listBeers();
    }

    @GetMapping(value = BEER_PATH_ID)
    public BeerS7 getBeerById(@PathVariable("beerId") UUID beerId) {

        log.debug("Get Beer by Id - in controller");

        return beerServiceS7.getBeerById(beerId).orElseThrow(NotFoundException::new);
    }


}