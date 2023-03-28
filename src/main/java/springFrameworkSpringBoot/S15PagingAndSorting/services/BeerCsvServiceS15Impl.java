package springFrameworkSpringBoot.S15PagingAndSorting.services;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;
import springFrameworkSpringBoot.S15PagingAndSorting.Model.BeerCSVRecordS15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * @Created 27 03 2023 - 11:13 AM
 * @Author Hazeem Hassan
 */
@Service
public class BeerCsvServiceS15Impl implements BeerCsvServiceS15 {
    @Override
    public List<BeerCSVRecordS15> convertCSV(File csvFile) {

        try {
            List<BeerCSVRecordS15> beerCSVRecords = new CsvToBeanBuilder<BeerCSVRecordS15>(new FileReader(csvFile))
                    .withType(BeerCSVRecordS15.class)
                    .build().parse();
            return beerCSVRecords;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
