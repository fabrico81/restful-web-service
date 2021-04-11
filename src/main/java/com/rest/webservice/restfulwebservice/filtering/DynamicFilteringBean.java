package com.rest.webservice.restfulwebservice.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("DynamicFilteringBean")
public class DynamicFilteringBean {

    private String field1;
    private String field2;
    private String field3;
}
