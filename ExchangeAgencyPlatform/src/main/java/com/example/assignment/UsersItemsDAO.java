package com.example.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class UsersItemsDAO {
    private static final String DB_URL = "jdbc:sqlite:C:\\db\\items.db";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";
    

    
    public static int  getUserIdByUserName(String UserName) {
        String sql = "SELECT user_id FROM users WHERE username = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, UserName);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("user_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public static int getItemIdByItemName(String itemName) {
        String query = "SELECT id FROM items WHERE name = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, itemName);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public static List<Integer> getItemsByUserId(int userId) {
        List<Integer> items = new ArrayList<>();
        String query = "select item_id from user_items where user_id=?";
        try (Connection connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                items.add(resultSet.getInt("item_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
    
    public static void addUserItem(int itemid, int userid) {
        if (userid == -1 || itemid == -1) {
            return ; // User or item does not exist or failed to add
        }

        String query = "INSERT INTO user_items (user_id, item_id) VALUES (?, ?)";
        try (Connection connection =DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userid);
            statement.setInt(2, itemid);
            int rowsAffected = statement.executeUpdate();
            
            if (rowsAffected > 0) {
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ;
    
    }
    public void addLikedItem(int userId, int itemId) {
        String query = "INSERT INTO user_liked_items (user_id, item_id) VALUES (?, ?)";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            statement.setInt(2, itemId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
