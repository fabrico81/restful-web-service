package com.rest.webservice.restfulwebservice.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;
    @Past()
    private LocalDate birthDate;

}
