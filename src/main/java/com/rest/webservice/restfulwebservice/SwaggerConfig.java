package com.rest.webservice.restfulwebservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig  {

    public static final Contact DEFAULT_CONTACT = new Contact("Faber", "", "");
    public static final ApiInfo DEFAULT_API_INFO;
    private static final Set<String> DEFAULT_PRODUCER_AND_CONSUMER;

    static {
        DEFAULT_API_INFO = new ApiInfo("Api Documentation", "Api Documentation", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
        DEFAULT_PRODUCER_AND_CONSUMER = new HashSet<String>(Arrays.asList("application/json"));
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCER_AND_CONSUMER)
                .consumes(DEFAULT_PRODUCER_AND_CONSUMER);
    }

}
