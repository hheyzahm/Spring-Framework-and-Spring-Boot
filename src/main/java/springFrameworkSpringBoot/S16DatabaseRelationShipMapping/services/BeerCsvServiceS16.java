package springFrameworkSpringBoot.S16DatabaseRelationShipMapping.services;

import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.Model.BeerCSVRecordS16;

import java.io.File;
import java.util.List;

/**
 * @Created 27 03 2023 - 11:13 AM
 * @Author Hazeem Hassan
 */
public interface BeerCsvServiceS16 {
    List<BeerCSVRecordS16> convertCSV(File csvFile);
}