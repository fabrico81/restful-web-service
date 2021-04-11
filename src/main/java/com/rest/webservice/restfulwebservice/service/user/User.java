package com.rest.webservice.restfulwebservice.service.user;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
//@Table(schema = "user", name = "user")
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private OffsetDateTime birthDate;
    private String email;

}
