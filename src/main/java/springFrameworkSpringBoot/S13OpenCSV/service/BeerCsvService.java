package springFrameworkSpringBoot.S13OpenCSV.service;

import springFrameworkSpringBoot.S13OpenCSV.model.BeerCSVRecord;

import java.io.File;
import java.util.List;

/**
 * @Created 27 03 2023 - 11:13 AM
 * @Author Hazeem Hassan
 */
public interface BeerCsvService {
    List<BeerCSVRecord> convertCSV(File csvFile);
}