package springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.services;

import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.Model.BeerCSVRecordS14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
class BeerCsvServiceS14ImplTest {
    BeerCsvServiceS14 beerCsvService = new BeerCsvServiceS14Impl();

    @Test
    void convertCSV() throws FileNotFoundException {

        File file = ResourceUtils.getFile("classpath:csvData/beers.csv");

        List<BeerCSVRecordS14> recs = beerCsvService.convertCSV(file);

        System.out.println(recs.size());

        assertThat(recs.size()).isGreaterThan(0);
    }

}