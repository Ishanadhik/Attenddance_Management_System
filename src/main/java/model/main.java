package model;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Connection connection = Dbhandler.connect();
        Scanner scanner1=new Scanner(System.in);

        List<user> user_list = Dbhandler.getAllUsers(Dbhandler.connect());
        List<Class> class_list = Dbhandler.getAllClasses(Dbhandler.connect());
        boolean end=true;
        while(end){
            System.out.println("Choose number to do a particular task");
            System.out.println("1-add User");
            System.out.println("2-add Class");
            System.out.println("3-add Attendance");
            System.out.println("4-Display Users");
            System.out.println("5-Display Classes");
            System.out.println("6-close");
            int select = scanner1.nextInt();

            switch(select){
                case 1:
                    System.out.println("enter username");
                    String username = scanner1.next();
                    System.out.println("enter password");
                    String password = scanner1.next();
                    user user = new user(0,username,password);
                    Dbhandler.addUser(connection,user);
                    break;

                case 2:
                    System.out.println("Enter name of class");
                    String classname = scanner1.next();
                    Class classs = new Class(0,classname);
                    Dbhandler.add_class(connection,classs);
                    break;

                case 3:
                    System.out.println("Enter username");
                    username = scanner1.next();
                    System.out.println("Enter password");
                    password = scanner1.next();
                    System.out.println("Enter classname");
                    classname = scanner1.next();
                    user = new user(0,username,password);
                    classs = new Class(0,classname);
                    Dbhandler.add_attendance(connection,user,classs);

                    break;

                case 4:
                    for (user u : user_list ) {
                        System.out.println(u.getId()+"name- " + u.getUsername());
                    }
                    break;

                case 5:
                    for (Class c : class_list ) {
                        System.out.println(c.getId()+"name- " + c.getClassname());
                    }
                    break;

                case 6:
                    end = true;
                    break;

                default:
                    System.out.println("Choose correct option!!1");
                    break;
            }
        }
    }
}
