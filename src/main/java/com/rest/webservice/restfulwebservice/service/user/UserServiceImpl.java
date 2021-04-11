package com.rest.webservice.restfulwebservice.service.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author faber
 */

@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> findAll() {

       return userRepository.findAll();
    }

    @Override
    public User save(UserRequest userRequest) {

        return userRepository.save(buildUser(userRequest));
    }

    @Override
    public User findUserById(int id) {
        log.info("Finding user id {}",id);

        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("No user with id: " + id));
    }

    @Override
    public void  delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponse saveEmail(String email) {
        log.info("Saving email: {}", email);

        User user = new User();
        user.setEmail(email);
        return buildUserResp(userRepository.save(user));
    }

    private User buildUser(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .id(userRequest.getId())
                .birthDate(userRequest.getBirthDate())
                .email(userRequest.getEmail()).build();
    }

    private UserResponse buildUserResp(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .birthDate(user.getBirthDate())
                .id(user.getId())
                .build();
    }

}
