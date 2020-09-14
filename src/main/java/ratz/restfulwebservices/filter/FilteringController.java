package ratz.restfulwebservices.filter;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean retrieveSomeBean(){

        return new SomeBean("Value1" , "Value2", "Value3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> retrieveListOfSomeBean(){

        return Arrays.asList( new SomeBean("Value1" , "Value2", "Value3"),
                new SomeBean("Value11" , "Value22", "Value33"));
    }

}
