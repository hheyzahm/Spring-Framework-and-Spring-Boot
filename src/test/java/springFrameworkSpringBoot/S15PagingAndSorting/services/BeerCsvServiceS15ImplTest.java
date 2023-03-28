package springFrameworkSpringBoot.S15PagingAndSorting.services;

import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;
import springFrameworkSpringBoot.S15PagingAndSorting.Model.BeerCSVRecordS15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
class BeerCsvServiceS15ImplTest {
    BeerCsvServiceS15 beerCsvService = new BeerCsvServiceS15Impl();

    @Test
    void convertCSV() throws FileNotFoundException {

        File file = ResourceUtils.getFile("classpath:csvData/beers.csv");

        List<BeerCSVRecordS15> recs = beerCsvService.convertCSV(file);

        System.out.println(recs.size());

        assertThat(recs.size()).isGreaterThan(0);
    }

}