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