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

    public static List<user> getAllUsers(Connection connection) {
        String sql = "SELECT * FROM " + TABLE_USER;

        List<user> usersList = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(COLUMN_ID);
                String username = rs.getString(COLUMN_USERNAME);
                String password = rs.getString(COLUMN_PASSWORD);
                user user_info= new user(id,username,password);
                usersList.add(user_info);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usersList;
    }

    public static List<Class> getAllClasses(Connection connection) {

        String sql = "SELECT * FROM " + TABLE_CLASS;

        List<Class> classList = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(COLUMN_ID);
                String classname = rs.getString(COLUMN_CLASSNAME);

                Class class_entry= new Class(id,classname);
                classList.add(class_entry);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return classList;
    }
    public static void add_class(Connection conn, Class c) {

        String sql = "INSERT INTO " + TABLE_CLASS + " (classname)" + "VALUES (?)";
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, c.getClassname());
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void add_attendance(Connection conn,user u ,Class c){

        String sql = "INSERT INTO " + TABLE_ATTENDANCE + " (user_id,class_id)" + "VALUES (?,?)";
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, u.getId());
            statement.setInt(2, c.getId());
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addUser(Connection conn, user u) {

        String sql = "INSERT INTO " + TABLE_USER + " (username,password)" + "VALUES (?,?)";
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, u.getUsername());
            statement.setString(2, u.getPassword());
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    }

