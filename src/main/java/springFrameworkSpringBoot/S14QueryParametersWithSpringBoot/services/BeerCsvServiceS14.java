package springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.services;


import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.Model.BeerCSVRecordS14;

import java.io.File;
import java.util.List;

/**
 * @Created 27 03 2023 - 11:13 AM
 * @Author Hazeem Hassan
 */
public interface BeerCsvServiceS14 {
    List<BeerCSVRecordS14> convertCSV(File csvFile);
}