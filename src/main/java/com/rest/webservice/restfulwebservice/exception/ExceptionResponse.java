package com.rest.webservice.restfulwebservice.exception;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ExceptionResponse {

    private Date localDateTime;
    private String message;
    private String details;
}
