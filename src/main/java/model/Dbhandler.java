package model;
import com.sun.net.httpserver.Request;
import model.user;
import model.Class;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dbhandler {
    //user table ko lagi psfs
    public static final String TABLE_USER = "user";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";

    //class table ko lagi psfs
    public static final String TABLE_CLASS = "class";
    public static final String COLUMN_CLASSNAME = "classname";

    //attendance table ko lagi psfs
    public static final String TABLE_ATTENDANCE = "attendance";
    public static final String COLUMN_CLASSID = "classId";
    public static final String COLUMN_USERID = "userId";

    public static Connection connect() {
        Connection connection = null;

        try {
            String url = "jdbc:sqlite:src/main/resources/database/attendance_management.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connection established");
        } catch (SQLException e) {
            System.out.println("Error connecting " + e.getMessage());
        }

        return connection;
    }

    public static List<model.user> getAllUsers(Connection connection) {
        String sql = "SELECT * FROM " + TABLE_USER;

        List<user> usersList = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(COLUMN_ID);
                String username = rs.getString(COLUMN_USERNAME);
                String password = rs.getString(COLUMN_PASSWORD);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usersList;
    }

    public static List<model.Class> getAllClass(Connection connection) {
        String sql = "SELECT * FROM " + TABLE_CLASS;

        List<Class> classList = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(COLUMN_ID);
                String username = rs.getString(COLUMN_CLASSNAME);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return classList;
    }

    public static void addUsers(Connection connection) {
        String classname = Request(Class.);
        String sql = "INSERT INTO " + TABLE_CLASS + " (" + COLUMN_ID + " " + COLUMN_CLASSNAME + " )" + " VALUES(?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, COLUMN_CLASSNAME);
            ps.executeQuery();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }
}
