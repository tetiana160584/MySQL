import objects.User;
import org.junit.Assert;
import org.junit.Test;
import selection.Students;

import java.sql.SQLException;

public class TestJDBC {

    @Test
    public void testAddStud() throws SQLException {
        Assert.assertFalse(Students.addUser("Anna", "Moris", "Dnipro"));
    }

    @Test
    public void testGetDateByName() {
        for (User l : Students.getUserObjects("Tetiana")) {
            System.out.println(l.date);
        }
    }


    }



