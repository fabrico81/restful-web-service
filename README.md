## Restful Web Services ( REST API )


- What is the dispatcher servlet?
- Who is configuring dispatcher servlet?
- What does dispatcher servlet do?
- How the Objects get converted to JSON?
- Who is configuration the error mapping?


Enable debug mode
Starting the application we can see all the Positive Matched
Ones is: `DispatcherServletAutoConfiguration matched:` because Spring found the class in the classpath. Spring Boot has dependency on Spring MVC. 
Also we can see
`ErrorMvcAutoConfiguration matched:` to configure errors.
`HttpMessageConvertersAutoConfiguration matched:` to convert the Object in Json with Jackson to Object mapping.

We can find in the logs:
`Mapping servlets: dispatcherServlet urls=[/]` The dispatcher servlet is handling all requests, this follows the Front Controller model. 
Therefore, the requests arrive at the Dispatcher Servlet which knows all the bean mapped and responds to the correct bean thanks
to the "@RestController" Annotation which contains the @ResponseBody

HATEOAS
Hypermedia as the Engine of Application State

#### Internationalization for RESTful Services

##### Configuration
- LocaleResolver
    - Default Locale - Locale.US
- ResourceBundleMessageSource

##### Usage
- Autowire MessageSource
- @RequestHeader(value = "Accept-Language", required = false) Locale locale
- messageSource.getMessage("helloWord.message", null, locale)

#### Monitoring API with Spring Boot Actuator


#### Filtering (Static and Dynamic)

######Static
//on the field to filter
@JsonIgnore 
private String field1

// on the controller class
@JsonIgnoreProperties(value={"field1","", ..."}) 
######Dynamic
SimpleFilter SimpleFilterProvider
MappingJacksonValue

#### Versioning RestFul Service

- Uri versioning, 
- param request versioning,
- header request versioning, 
- Media type versioning (a.k.a "content negotiation" or "Accept header") ( https://tools.ietf.org/html/rfc4288#section-3.2 , https://tools.ietf.org/html/draft-ietf-httpbis-p3-payload-16#section-5.2)
 

#### Basic Authentication with Spring security
add spring security dependency  
configure user and password in the properties file or see the log for the password, the default user value is 'user'

#### Connecting RestFul service to JPA and H2 database