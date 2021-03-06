package com.rest.webservice.restfulwebservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path ="/users")
    public List<User> retrieveAllUsers() {
        return userService.findAll();
    }


    @GetMapping(path = "/user/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = userService.findOne(id);
        if(user == null) {
            throw new UserNotFoundException("id-" + id);
        }

        //HATEOAS

        EntityModel<User> resource = EntityModel.of(user);
        WebMvcLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).retrieveAllUsers());
        resource.add(linkTo.withRel("all-users"));

        return user;
    }

    @DeleteMapping(path = "/user/{id}")
    public User deleteUser(@PathVariable int id) {

        User user = userService.delete(id);
        if(user == null) {
            throw new UserNotFoundException("id-" + id);
        }
        return user;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        User savedUser = userService.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
