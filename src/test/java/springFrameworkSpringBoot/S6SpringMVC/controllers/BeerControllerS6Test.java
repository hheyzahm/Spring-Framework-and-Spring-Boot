package springFrameworkSpringBoot.S6SpringMVC.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BeerControllerS6Test {
    @Autowired
    BeerControllerS6 beerControllerS6;
    @Test
    void getBeerByID(){
        System.out.println(beerControllerS6.getBeerByIdSpringMVC(UUID.randomUUID()));
    }
}