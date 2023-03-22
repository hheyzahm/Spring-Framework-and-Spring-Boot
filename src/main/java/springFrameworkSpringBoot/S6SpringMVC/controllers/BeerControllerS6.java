package springFrameworkSpringBoot.S6SpringMVC.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springFrameworkSpringBoot.S6SpringMVC.Model.BeerS6;
import springFrameworkSpringBoot.S6SpringMVC.services.BeerServiceS6;

import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:05 PM
 * @Author Hazeem Hassan
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/SpringMVC/api/v1/beer/")
public class BeerControllerS6 {
    private final BeerServiceS6 beerServiceS6;

    @PatchMapping("{beerId}")
    public ResponseEntity updateBeerPatchByIdSpringMVC(@PathVariable("beerId")UUID beerId, @RequestBody BeerS6 beerS6){

        beerServiceS6.patchBeerById(beerId, beerS6);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{beerId}")
    public ResponseEntity deleteByIdSpringMVC(@PathVariable("beerId") UUID beerId){

        beerServiceS6.deleteById(beerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{beerId}")
    public ResponseEntity updateByIdSpringMVC(@PathVariable("beerId")UUID beerId, @RequestBody BeerS6 beerS6){

        beerServiceS6.updateBeerById(beerId, beerS6);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    //@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity handlePostSpringMVC(@RequestBody BeerS6 beerS6){

        BeerS6 savedBeerS6 = beerServiceS6.saveNewBeer(beerS6);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedBeerS6.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BeerS6> listBeersSpringMVC(){
        return beerServiceS6.listBeers();
    }

    @RequestMapping(value = "{beerId}", method = RequestMethod.GET)
    public BeerS6 getBeerByIdSpringMVC(@PathVariable("beerId") UUID beerId){

        log.debug("Get Beer by Id - in controller");

        return beerServiceS6.getBeerById(beerId);
    }

}