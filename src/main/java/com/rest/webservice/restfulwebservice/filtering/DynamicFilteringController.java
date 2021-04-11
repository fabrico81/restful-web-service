package com.rest.webservice.restfulwebservice.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DynamicFilteringController {

    @GetMapping("/dynamic-filtering")
    public MappingJacksonValue retrieveBeanDynamicFiltered() {

        DynamicFilteringBean dynamicFilteringBean = new DynamicFilteringBean("value1", "value2", "value3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("DynamicFilteringBean", filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(dynamicFilteringBean);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }
}
