package com.rest.webservice.restfulwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    @GetMapping("/v1/person")
    public PersonV1 retrievePerson1() {
        return new PersonV1("Bob Chalton");
    }

    @GetMapping("/v2/person")
    public PersonV2 retrievePerson2() {
        return new PersonV2(new Name("Gigi", "D'Agostino"));
    }

    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 retrievePersonParam1() {
        return new PersonV1("Lauren Garnier");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 retrievePersonParam2() {
        return new PersonV2(new Name("Bob", "Sinclar"));
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 retrievePersonHeader1() {
        return new PersonV1("Gigi D'Agostino");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 retrievePersonHeader2() {
        return new PersonV2(new Name("Bob", "Sinclar"));
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 retrievePersonProduces1() {
        return new PersonV1("Gigi D'Agostino");
    }

    @GetMapping(value = "/person/produces", produces = "application/company.app-v2+json")
    public PersonV2 retrievePersonProduces2() {
        return new PersonV2(new Name("Bob", "Sinclar"));
    }
}
