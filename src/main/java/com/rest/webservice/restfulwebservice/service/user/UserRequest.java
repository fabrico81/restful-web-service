package com.rest.webservice.restfulwebservice.service.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @JsonProperty("id")
    private int id;

    @Size(min = 2, message = "Name should have at least 2 characters")
    @ApiModelProperty(notes = "Name should have at least 2 characters")
    @JsonProperty("name")
    private String name;

    @Past()
    @ApiModelProperty(notes = "Birthdate should be in the past")
    @JsonProperty("birthDate")
    private OffsetDateTime birthDate;

    @Email(message = "User email validation fails")
    @ApiModelProperty(notes = "User email")
    @JsonProperty("email")
    private String email;
}
