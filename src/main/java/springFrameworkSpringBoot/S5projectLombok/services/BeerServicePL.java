package springFrameworkSpringBoot.S5projectLombok.services;


import springFrameworkSpringBoot.S5projectLombok.Model.BeerPL;

import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:00 PM
 * @Author Hazeem Hassan
 */
public interface BeerServicePL {
    BeerPL getBeerByID(UUID uuidID);
}
