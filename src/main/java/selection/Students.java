package selection;

import config.State;
import objects.User;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Students extends State {


    public static void printInfo() throws SQLException {
        ResultSet resultSet = getStatement().executeQuery("SELECT * FROM sys.`students`;");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + " " + resultSet.getString("date"));
        }
    }

    public static void getUser(String name) throws SQLException {
        ResultSet resultSet = getStatement().executeQuery("SELECT * FROM sys.`students` where name=\"" + name + "\";");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("family") + " " + resultSet.getString("date"));
        }
    }

    public static boolean addUser(String name, String family, String cityName) throws SQLException {
        return getStatement().execute("INSERT INTO `sys`.`students` (`name`, `family`, `city`) VALUES ('" + name + "', '" + family + "', '" + cityName + "');");
    }

    public static List<User> getUserObjects(String name) {
        ResultSet resultSet = null;
        List<User> list = new ArrayList<>();
        try {
            resultSet = getStatement().executeQuery("SELECT * FROM sys.`students` where name=\"" + name + "\";");


            while (resultSet.next()) {
                list.add(new User(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



    public static User getUserById(String id) {
        String query = "SELECT * FROM sys.`students` WHERE id=?";
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();

        try (PreparedStatement preparedStatement = getStatement().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                userList.add(new User(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!userList.isEmpty()) {
            return userList.get(0); //
        } else {
            return null; // если пользователь с указанным ID не найден, вернётся null
        }
    }

    public static List<User> getUsersByCity(String city) {
        String query = "SELECT * FROM sys.`students` WHERE city=?";
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();

        try (PreparedStatement preparedStatement = getStatement().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, city);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                userList.add(new User(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    }


