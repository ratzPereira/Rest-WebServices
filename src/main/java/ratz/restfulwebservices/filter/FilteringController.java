package ratz.restfulwebservices.filter;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {


    //value1, value2
    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean(){

        SomeBean someBean = new SomeBean("Value1", "Value2", "Value3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1", "value2");


        // dont forget to add @JsonFilter("SomeBeanFilter") in SomeBean class
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(filters);

        return mapping;
    }

    //value2, value3
    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveListOfSomeBean(){

        List<SomeBean> someBeans = Arrays.asList(new SomeBean("Value1", "Value2", "Value3"),
                new SomeBean("Value11", "Value22", "Value33"));


        SimpleBeanPropertyFilter filter2 = SimpleBeanPropertyFilter.filterOutAllExcept("value2", "value3");


        // dont forget to add @JsonFilter("SomeBeanFilter") in SomeBean class
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter2);

        MappingJacksonValue mapping = new MappingJacksonValue(someBeans);
        mapping.setFilters(filters);

        return mapping;
    }

}
