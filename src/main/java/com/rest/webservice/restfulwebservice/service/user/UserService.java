package com.rest.webservice.restfulwebservice.service.user;


import java.util.List;

public interface UserService {
    public List<User> findAll();

    User save(UserRequest user);

    User findUserById(int id);

    void  delete(int id);

    UserResponse saveEmail(String email);
}
