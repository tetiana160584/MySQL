import objects.User;
import org.junit.Assert;
import org.junit.Test;
import selection.Students;

import java.sql.SQLException;
import java.util.List;

public class TestJDBC_2 {
    @Test
    public void testGetUserById() throws SQLException {
        String userId = "1";
        User user = Students.getUserById(userId);
            System.out.println("" + userId + ": " + user.name);
        }

    @Test
    public void testGetUsersByCity() throws SQLException {
        String city = "Kharkiv";
        List<User> users = Students.getUsersByCity(city);
        Assert.assertFalse(users.isEmpty());
        System.out.println(" " + city + ":");
        for (User user : users) {
            System.out.println("ID: " + user.id + ", " + user.name + " " + user.family+", "+user.date);
        }
    }
}
