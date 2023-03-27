package springFrameworkSpringBoot.S14QueryParametersWithSpringBoot.Model;

/**
 * @Created 27 03 2023 - 11:00 AM
 * @Author Hazeem Hassan
 */

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeerCSVRecordS14 {
    @CsvBindByName(column = "")
    private Integer row;

    @CsvBindByName(column = "count.x")
    private Integer count;

    @CsvBindByName(column = "abv")
    private String abv;

    @CsvBindByName(column = "ibu")
    private String ibu;

    @CsvBindByName(column = "id")
    private Integer id;

    @CsvBindByName(column = "beer")
    private String beer;

    @CsvBindByName(column = "style")
    private String style;

    @CsvBindByName(column = "brewery_id")
    private Integer breweryId;

    @CsvBindByName(column = "ounces")
    private Float ounces;

    @CsvBindByName(column = "style2")
    private String style2;

    @CsvBindByName(column = "count.y")
    private String count_y;

    @CsvBindByName(column = "brewery")
    private String brewery;

    @CsvBindByName(column = "city")
    private String city;

    @CsvBindByName(column = "state")
    private String state;

    @CsvBindByName(column = "label")
    private String label;

}