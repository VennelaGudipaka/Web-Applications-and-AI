package com.example.assignment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    private static final String DB_URL = "jdbc:sqlite:C:\\db\\items.db";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";
    private Connection jdbcConnection = null;
    public ItemDAO() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

protected void connect() throws SQLException {
    if (jdbcConnection == null || jdbcConnection.isClosed()) {
        jdbcConnection = DriverManager.getConnection(DB_URL);
    }
}

protected void disconnect() throws SQLException {
    if (jdbcConnection != null && !jdbcConnection.isClosed()) {
        jdbcConnection.close();
    }
}

    public static List<Item> getAllItems(int userId) throws SQLException {
        List<Item> items = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT user_items.item_id, items.*,"+
            "user_items.user_id FROM items LEFT JOIN user_items on items.id=user_items.item_id where user_items.user_id=? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt("item_id"));
                item.setCategory(resultSet.getString("category"));
                item.setName(resultSet.getString("name"));
                item.setBrand(resultSet.getString("brand"));
                item.setRam(resultSet.getString("ram"));
                item.setModel(resultSet.getString("model"));
                item.setSize(resultSet.getString("size"));
                item.setColor(resultSet.getString("color"));
                item.setType(resultSet.getString("type"));
                item.setDescription(resultSet.getString("description"));
                item.setCondition(resultSet.getString("condition"));
                item.setPhoto(resultSet.getString("photo"));
                //item.set(resultSet.getInt("item_id"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
    public static int  addItem(String name, String category, String brand, String ram, String model, String size, String color, String type, String description, String condition, String photo) {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        long itemId=0;
        int affectedRows=0;
        String sql = "INSERT INTO items (name, category, brand, ram, model, size, color, type, description, condition, photo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try  {
            Connection connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, category);
            statement.setString(3, brand);
            statement.setString(4, ram);
            statement.setString(5, model);
            statement.setString(6, size);
            statement.setString(7, color);
            statement.setString(8, type);
            statement.setString(9, description);
            statement.setString(10, condition);
            statement.setString(11, photo);

            affectedRows = statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()){
                itemId=generatedKeys.getLong(1);
            }
            
            if (affectedRows == 0) {
                throw new SQLException("Creating item failed, no rows affected.");
            }
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();

        }
        return (int) itemId;
    }

    public void expressInterest(int userId, int itemId) throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
            String sql = "INSERT INTO exchange_requests (user_id, item_id, status) VALUES (?, ?, 'Pending')";
            try (Connection connection=DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, userId);
                statement.setInt(2, itemId);
                statement.executeUpdate();
            }
            catch (SQLException e) {
                e.printStackTrace(); // Log the error for debugging
            }
        }
        public static Item getItemDetailsByItemId(int itemId) {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Item item = new Item();
            String query = "SELECT * FROM items WHERE id = ?";
            try (Connection connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
                PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, itemId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        item.setId(resultSet.getInt("id"));
                        item.setCategory(resultSet.getString("category"));
                        item.setName(resultSet.getString("name"));
                        item.setBrand(resultSet.getString("brand"));
                        item.setRam(resultSet.getString("ram"));
                        item.setModel(resultSet.getString("model"));
                        item.setSize(resultSet.getString("size"));
                        item.setColor(resultSet.getString("color"));
                        item.setType(resultSet.getString("type"));
                        item.setDescription(resultSet.getString("description"));
                        item.setCondition(resultSet.getString("condition"));
                        item.setPhoto(resultSet.getString("photo"));
                        // return item;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return item;
        }
        
    
    public Item getItem(int id) throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM items WHERE item_id = ?"; // Is this item_id or id?
        try (Connection connection= DriverManager.getConnection(DB_URL, DB_URL, DB_PASSWORD);
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Item(rs.getInt("id"), rs.getString("name"),rs.getString("category"), rs.getString("brand"), rs.getString("ram"), rs.getString("model"), rs.getString("size"), rs.getString("color"), rs.getString("type"), rs.getString("description"), rs.getString("condition"), rs.getString("photo"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace(); // Log the error for debugging
        }
        return null;
    }
    public static List<Item> getItemsByUserId(int userId) {
        List<Item> items = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
        String sql = "SELECT * FROM items WHERE user_id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setCategory(rs.getString("category"));
                item.setBrand(rs.getString("brand"));
                item.setRam(rs.getString("ram"));
                item.setModel(rs.getString("model"));
                item.setSize(rs.getString("size"));
                item.setColor(rs.getString("color"));
                item.setType(rs.getString("type"));
                item.setDescription(rs.getString("description"));
                item.setCondition(rs.getString("condition"));
                item.setPhoto(rs.getString("photo"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
    public  List<Item> getAllItemsExcludingUser(int userId) {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT items.id, items.name, items.category, items.brand, items.ram, items.model, items.size, items.color, items.type, items.description, items.condition, items.photo " +
                     "FROM items LEFT JOIN user_items ON items.id = user_items.item_id WHERE user_items.user_id <> ? OR user_items.user_id IS NULL";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setCategory(rs.getString("category"));
                item.setBrand(rs.getString("brand"));
                item.setRam(rs.getString("ram"));
                item.setModel(rs.getString("model"));
                item.setSize(rs.getString("size"));
                item.setColor(rs.getString("color"));
                item.setType(rs.getString("type"));
                item.setDescription(rs.getString("description"));
                item.setCondition(rs.getString("condition"));
                item.setPhoto(rs.getString("photo"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public static boolean updateItem(Item item) {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "UPDATE items SET name = ?, category = ?, brand = ?, ram = ?, model = ?, size = ?, color = ?, type = ?, description = ?, condition = ?, photo = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, item.getName());
            stmt.setString(2, item.getCategory());
            stmt.setString(3, item.getBrand());
            stmt.setString(4, item.getRam());
            stmt.setString(5, item.getModel());
            stmt.setString(6, item.getSize());
            stmt.setString(7, item.getColor());
            stmt.setString(8, item.getType());
            stmt.setString(9, item.getDescription());
            stmt.setString(10, item.getCondition());
            stmt.setString(11, item.getPhoto());
            stmt.setInt(12, item.getId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Log error to server logs
            return false;
        }
    }

    public Item getItemById(int id) {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Item item = null;
        try (Connection connection = DriverManager.getConnection(DB_URL,DB_PASSWORD,DB_USER);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    item = new Item(
                        resultSet.getInt("id"),
                        resultSet.getString("category"),
                        resultSet.getString("name"),
                        resultSet.getString("brand"),
                        resultSet.getString("ram"),
                        resultSet.getString("model"),
                        resultSet.getString("size"),
                        resultSet.getString("color"),
                        resultSet.getString("type"),
                        resultSet.getString("description"),
                        resultSet.getString("condition"),
                        resultSet.getString("photo")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    public void deleteItem(int id) {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "DELETE FROM items WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getItemByIdforExchange(int id) throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM items WHERE id = ?";
        try{Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            return statement.executeQuery();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


