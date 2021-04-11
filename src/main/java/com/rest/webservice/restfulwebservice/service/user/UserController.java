package com.rest.webservice.restfulwebservice.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path ="/users")
    public List<User> retrieveAllUsers() {
        return userService.findAll();
    }


    @GetMapping(path = "/user/{id}")
    public EntityModel retrieveUser(@PathVariable int id) {

        User user = userService.findUserById(id);
        //HATEOAS
        EntityModel<User> resource = EntityModel.of(user);
        WebMvcLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).retrieveAllUsers());
        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @DeleteMapping(path = "/user/{id}")
    public void deleteUser(@PathVariable int id) {

        userService.delete(id);
    }

    @PostMapping(
            path = "/users",
            produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest user) {

        User savedUser = userService.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @RequestMapping(
            value = "/email/",
            produces = {"application/json"},
            consumes = {"*/*"},
            method = {RequestMethod.POST})
    public ResponseEntity<UserResponse> saveEmail(@RequestBody @Valid User email) {

        UserResponse savedUser = userService.saveEmail(email.getEmail());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{email}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
