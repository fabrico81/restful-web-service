package com.rest.webservice.restfulwebservice.helloworld;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * @author faber
 */

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloWordBean {

    private String message;

//    public HelloWordBean(String message) {
//        this.message = message;
//    }
}
