package springFrameworkSpringBoot.S4ProjectLombok.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import springFrameworkSpringBoot.S4ProjectLombok.Model.BeerPL;
import springFrameworkSpringBoot.S4ProjectLombok.services.BeerServicePL;


import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:05 PM
 * @Author Hazeem Hassan
 */
@Slf4j
@AllArgsConstructor
@Controller
public class BeerControllerPL {
    private final BeerServicePL beerServicePL;

    public BeerPL getBeerByID(UUID uuid) {
        log.debug("Get Beer by Id - in Controller.  ");
        return beerServicePL.getBeerByID(uuid);
    }
}