package pl.coderslab.entity;

import java.util.Arrays;

public class MainDao {
    public static void main(String[] args) {

        UserDao userDao1 = new UserDao();
        User user1 = new User();
        user1.setUserName("Jan Kowalski");
        user1.setEmail("jkowalski@gmail.com");
        user1.setPassword("password1");
        User user2 = new User();
        user2.setUserName("Anna Kowalska");
        user2.setEmail("ankowal@onet.pl");
        user2.setPassword("password2");
        User user3 = new User();
        user3.setUserName("John Doe");
        user3.setEmail("jdoe@o2.pl");
        user3.setPassword("password3");

        userDao1.create(user1);
        userDao1.create(user2);
        userDao1.create(user3);


       userDao1.delete(1);
       User tempUser = userDao1.read(2);
       tempUser.setUserName("Zofia Malinowska");
       tempUser.setEmail("zmalin@gmail.com");
       tempUser.setPassword("passwd4");
       userDao1.update(tempUser);

        User[] findAllUsers= userDao1.findAll();
        for (User person : findAllUsers) {
            System.out.println(person);
        }

    }
}
