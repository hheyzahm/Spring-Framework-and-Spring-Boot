package springFrameworkSpringBoot.S15PagingAndSorting.services;

import springFrameworkSpringBoot.S15PagingAndSorting.Model.BeerCSVRecordS15;

import java.io.File;
import java.util.List;

/**
 * @Created 27 03 2023 - 11:13 AM
 * @Author Hazeem Hassan
 */
public interface BeerCsvServiceS15 {
    List<BeerCSVRecordS15> convertCSV(File csvFile);
}