package com.rest.webservice.restfulwebservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author faber
 */
@RestController
public class HelloWordController {

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello Word";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWordBean helloWorldBean() {
        return new HelloWordBean("Hello World");
    }
}
