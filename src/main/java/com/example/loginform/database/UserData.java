package com.example.loginform.database;

import com.example.loginform.dbRunTime.Users;
import com.example.loginform.model.User;

import java.sql.*;

public class UserData {
    static final String DB_URL = "jdbc:mysql://localhost:3306/logindb";
    static final String USER = "root";
    static final String PASS = "OpQw120-";

    private Users users;

    public UserData() {
        this.users = new Users();
    }

    public Users getDatabaseContent() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM users")) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setName(resultSet.getString("name"));
                user.setBirthday(resultSet.getString("birthdate"));
                user.setAddress(resultSet.getString("address"));
                user.setPassword(resultSet.getString("password"));
                this.users.addUser(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.users;
    }

    public void setNewUser(User newUser) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO users(username, name, birthdate, password, address) VALUES(?,?,?,?,?)")) {
            preparedStatement.setString(1, newUser.getUsername());
            preparedStatement.setString(2, null);
            preparedStatement.setDate(3, null);
            preparedStatement.setString(4, newUser.getPass());
            preparedStatement.setString(5, null);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User newUser) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE users SET name=?, address=?, birthdate=? WHERE username=?;")) {
            preparedStatement.setString(1, newUser.getName());
            preparedStatement.setString(2, newUser.getAddress());
            preparedStatement.setString(3, newUser.getBirthday());
            preparedStatement.setString(4, newUser.getUsername());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePassword(User newUser) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement preparedStatement = conn.prepareStatement("UPDATE users SET password=? WHERE username=?;")) {
            preparedStatement.setString(1, newUser.getPass());
            preparedStatement.setString(2, newUser.getUsername());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
