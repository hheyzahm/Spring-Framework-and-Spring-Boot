package springFrameworkSpringBoot.S16DatabaseRelationShipMapping.services;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.Model.BeerCSVRecordS16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * @Created 27 03 2023 - 11:13 AM
 * @Author Hazeem Hassan
 */
@Service
public class BeerCsvServiceS16Impl implements BeerCsvServiceS16 {
    @Override
    public List<BeerCSVRecordS16> convertCSV(File csvFile) {

        try {
            List<BeerCSVRecordS16> beerCSVRecords = new CsvToBeanBuilder<BeerCSVRecordS16>(new FileReader(csvFile))
                    .withType(BeerCSVRecordS16.class)
                    .build().parse();
            return beerCSVRecords;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
