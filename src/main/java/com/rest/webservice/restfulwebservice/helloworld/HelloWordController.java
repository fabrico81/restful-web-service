package com.rest.webservice.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWordBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWordBean(String.format("Hello World, %s", name));
    }
}
