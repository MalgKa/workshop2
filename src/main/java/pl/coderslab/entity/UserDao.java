package pl.coderslab.entity;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.DbUtil;

import java.sql.*;

public class UserDao {
    private static final String CREATE_USER_QUERY =
            "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";

    private static final String UPDATE_USER_QUERY =
            "update  users set username=?, email=?, password=? where id =?";

    private static final String SELECT_USER_QUERY =
            "select * from users where id =?";

    private static final String DELETE_USER_QUERY =
            "delete from users where id =?";

    private static final String SELECT_ALL_USER_QUERY =
            "select * from users";

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public User create(User user) {
        try (Connection conn = DbUtil.connectWorkshop()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_USER_QUERY);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.executeUpdate();

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public void delete(int id) {

        try (Connection conn = DbUtil.connectWorkshop()) {

            PreparedStatement statement = conn.prepareStatement(DELETE_USER_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

}
