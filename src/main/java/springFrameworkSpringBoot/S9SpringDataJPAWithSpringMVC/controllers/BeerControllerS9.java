package springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.controllers;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import springFrameworkSpringBoot.S8ExceptionHandling.NotFoundException;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.Model.BeerDTO;
import springFrameworkSpringBoot.S9SpringDataJPAWithSpringMVC.services.BeerServiceS9;

import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:05 PM
 * @Author Hazeem Hassan
 */
@Slf4j
@AllArgsConstructor
@RestController
public class BeerControllerS9 {

    public static final String BEER_PATH = "/S9/api/v1/beer";
    public static final String BEER_PATH_ID = BEER_PATH + "/{beerId}";
    private final BeerServiceS9 beerServiceS9;

    @PatchMapping(BEER_PATH_ID)
    public ResponseEntity updateBeerPatchById(@PathVariable("beerId") UUID beerId, @RequestBody BeerDTO beer) {

        beerServiceS9.patchBeerById(beerId, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(BEER_PATH_ID)
    public ResponseEntity deleteById(@PathVariable("beerId") UUID beerId) {

        beerServiceS9.deleteById(beerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(BEER_PATH_ID)
    public ResponseEntity updateById(@PathVariable("beerId") UUID beerId, @RequestBody BeerDTO beer) {

        beerServiceS9.updateBeerById(beerId, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(BEER_PATH)
    public ResponseEntity handlePost(@RequestBody BeerDTO beer) {

        BeerDTO savedBeer = beerServiceS9.saveNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", BEER_PATH + "/" + savedBeer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = BEER_PATH)
    public List<BeerDTO> listBeers() {
        return beerServiceS9.listBeers();
    }

    @GetMapping(value = BEER_PATH_ID)
    public BeerDTO getBeerById(@PathVariable("beerId") UUID beerId) {

        log.debug("Get Beer by Id - in controller");

        return beerServiceS9.getBeerById(beerId).orElseThrow(NotFoundException::new);
    }


}