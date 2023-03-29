package springFrameworkSpringBoot.S16DatabaseRelationShipMapping.services;

import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;
import springFrameworkSpringBoot.S16DatabaseRelationShipMapping.Model.BeerCSVRecordS16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BeerCsvServiceS16ImplTest {

    BeerCsvServiceS16 beerCsvService = new BeerCsvServiceS16Impl();

    @Test
    void convertCSV() throws FileNotFoundException {

        File file = ResourceUtils.getFile("classpath:csvData/beers.csv");

        List<BeerCSVRecordS16> recs = beerCsvService.convertCSV(file);

        System.out.println(recs.size());

        assertThat(recs.size()).isGreaterThan(0);
    }
}