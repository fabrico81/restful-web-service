package com.rest.webservice.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author faber
 */

@Service
public class UserService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "user1", LocalDate.of(1918, 06, 12)));
        users.add(new User(2, "user2", LocalDate.of(1916, 06, 12)));
        users.add(new User(3, "user3", LocalDate.of(1919, 06, 12)));
    }

    private static int counterUser = 3;

    public List<User> findAll() {
        return users;
    }


    public User save(User user) {
        users.add(user);
        return user;
    }
    public User findOne(int id) {
        for(User user:users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User delete(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
