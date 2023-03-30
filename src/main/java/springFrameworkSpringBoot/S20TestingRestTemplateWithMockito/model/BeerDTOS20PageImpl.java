package springFrameworkSpringBoot.S20TestingRestTemplateWithMockito.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Created 29 03 2023 - 2:29 PM
 * @Author Hazeem Hassan
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = "pageable")
public class BeerDTOS20PageImpl<BeerDTOS20> extends PageImpl<BeerDTOS20> {
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public BeerDTOS20PageImpl(@JsonProperty("content") List<BeerDTOS20> content,
                              @JsonProperty("number") int page,
                              @JsonProperty("size") int size,
                              @JsonProperty("totalElements") long total){
        super(content, PageRequest.of(page, size), total);
    }


    public BeerDTOS20PageImpl(List<BeerDTOS20> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerDTOS20PageImpl(List<BeerDTOS20> content) {
        super(content);
    }}
