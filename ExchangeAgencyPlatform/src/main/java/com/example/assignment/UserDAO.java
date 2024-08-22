package com.example.assignment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {
    private static  Connection connection;

    public UserDAO(Connection connection) {
        UserDAO.connection = connection;
    }

    public void addUser(String username, String email, String hashedPassword) throws SQLException {
        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, hashedPassword);
            statement.executeUpdate();
        }
    }

    public User getUserByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int userId = resultSet.getInt("user_id");
                    String email = resultSet.getString("email");
                    String password = resultSet.getString("password");
                    return new User(userId, username, email, password);
                }
            }
        }
        return null;
    }
    public  List<User> getAllUsersExcludingUser(int userId) {
        List<User> users = new ArrayList<User>();
        String sql = "SELECT DISTINCT u.user_id, u.username" +
                        "FROM users u" +
                        "JOIN user_items ui ON u.user_id = ui.user_id" +
                        "WHERE u.user_id != ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("user_id"));
                user.setUsername(rs.getString("user_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                // Set other user fields as needed
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public static User getUserById(int userId) throws SQLException {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        User user = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Extract user details from the result set
                    int id = resultSet.getInt("id");
                    String email= resultSet.getString("email");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password"); // Or any other fields you have
                    // Create a User object
                    user = new User(id,email, username, password);
                }
            }
        }
        return user;
    }
}
