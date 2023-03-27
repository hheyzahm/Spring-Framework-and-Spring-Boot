package springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.services;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.Model.BeerCSVRecordS14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * @Created 27 03 2023 - 11:13 AM
 * @Author Hazeem Hassan
 */
@Service
public class BeerCsvServiceS14Impl implements BeerCsvServiceS14 {
    @Override
    public List<BeerCSVRecordS14> convertCSV(File csvFile) {

        try {
            List<BeerCSVRecordS14> beerCSVRecords = new CsvToBeanBuilder<BeerCSVRecordS14>(new FileReader(csvFile))
                    .withType(BeerCSVRecordS14.class)
                    .build().parse();
            return beerCSVRecords;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
