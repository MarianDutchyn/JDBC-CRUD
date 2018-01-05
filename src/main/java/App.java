import java.sql.*;
import java.util.Scanner;

public class App {

    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
    public static String username = "root";
    public static String password = "root";

    public static void addUser(String name, int age){
        String sql = "INSERT INTO Users (name, age) VALUES (?, ?)";

        try(Connection con = DriverManager.getConnection(JDBC_URL, username, password)) {
            con.setAutoCommit(false);
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.execute();
            con.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showUsers(){
        String sql = "SELECT id, name, age FROM Users";

        try(Connection con = DriverManager.getConnection(JDBC_URL, username, password)) {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
               int id = resultSet.getInt("id");
               String name = resultSet.getString("name");
               int age = resultSet.getInt("age");
                System.out.println("Id: " + id + ", Name: " + name + ", Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editUser(String name){
        String sql = "UPDATE Users SET name = ?, age = ? WHERE Users.name = ?";
        try(Connection con = DriverManager.getConnection(JDBC_URL, username, password)) {
            PreparedStatement statement = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter new name:");
            String newName= sc.next();
            System.out.println("Enter new age");
            int newAge = Integer.parseInt(sc.next());
            statement.setString(1, newName);
            statement.setInt(2, newAge);
            statement.setString(3, name);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(String name){
        String sql = "DELETE FROM Users WHERE Users.name = ?";

        try(Connection con = DriverManager.getConnection(JDBC_URL, username, password)) {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, name);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
