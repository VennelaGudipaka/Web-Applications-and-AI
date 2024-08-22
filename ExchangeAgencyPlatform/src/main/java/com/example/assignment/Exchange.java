package com.example.assignment;

public class Exchange {

    private int id;
    private int itemIdFrom;
    private int itemIdTo;
    private int userIdFrom;
    private int userIdTo;
    private String status;


    // Default constructor
    public Exchange(int id, int itemIdFrom, int itemIdTo, int userIdFrom, int userIdTo, String status) {
        this.id = id;
        this.itemIdFrom = itemIdFrom;
        this.itemIdTo = itemIdTo;
        this.userIdFrom = userIdFrom;
        this.userIdTo = userIdTo;
        this.status = status;
    }

    

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemIdFrom() {
        return itemIdFrom;
    }

    public void setItemIdFrom(int itemIdFrom) {
        this.itemIdFrom = itemIdFrom;
    }

    public int getItemIdTo() {
        return itemIdTo;
    }

    public void setItemIdTo(int itemIdTo) {
        this.itemIdTo = itemIdTo;
    }

    public int getUserIdFrom() {
        return userIdFrom;
    }

    public void setUserIdFrom(int userIdFrom) {
        this.userIdFrom = userIdFrom;
    }

    public int getUserIdTo() {
        return userIdTo;
    }

    public void setUserIdTo(int userIdTo) {
        this.userIdTo = userIdTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        // Validate status value
        if (status.equals("Pending") || status.equals("Accepted") || status.equals("Rejected")) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid status value");
        }
    }


    @Override
    public String toString() {
        return "ExchangeRequest{" +
                "id=" + id +
                ", itemIdFrom=" + itemIdFrom +
                ", itemIdTo=" + itemIdTo +
                ", userIdFrom=" + userIdFrom +
                ", userIdTo=" + userIdTo +
                ", status='" + status + '\'' +
                '}';
    }
}
