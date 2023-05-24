package pl.coderslab.entity;

public class MainDao {
    public static void main(String[] args) {
        User user1 = new User();
        UserDao userDao1 = new UserDao();
        User user2 = new User();
        user1.setUserName("Jan");
        user1.setEmail("janek@gmail.com");
        user1.setPassword("dmuchawceLatawce");
        user2.setUserName("Robert");
        user2.setEmail("tradd@.gmail.com");
        user2.setPassword("ogórekKiszony");


        userDao1.create(user1);
        userDao1.create(user2);

    }
}
