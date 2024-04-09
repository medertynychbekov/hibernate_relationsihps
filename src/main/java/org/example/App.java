package org.example;

import org.example.model.Passport;
import org.example.model.User;
import org.example.service.UserService;
import org.example.service.impl.UserServiceImpl;

/**
 * Hello world!
 */
public class App {
    private static final UserService USER_SERVICE = new UserServiceImpl();

    public static void main(String[] args) {

        Passport foreignPassport = new Passport("foreign_passport", 73);
        Passport innerPassport = new Passport("inner_passport", 97);

//        User user = new User("user_name", "user_last_name", innerPassport);
//        User user2 = new User("user_name2", "user_last_name2", foreignPassport);


        User user1 = USER_SERVICE.findById(3L);

        user1.setPassport(foreignPassport);
        USER_SERVICE.save(user1);
        System.out.println(user1.getPassport());

//        USER_SERVICE.deleteById(2L);

    }
}
