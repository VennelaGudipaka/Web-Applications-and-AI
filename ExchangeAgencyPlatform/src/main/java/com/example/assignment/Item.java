package com.example.assignment;

public class Item {
    private int id;
    private String category;
    private String name;
    private String brand;
    private String ram;
    private String model;
    private String size;
    private String color;
    private String type;
    private String description;
    private String condition;
    private String photo;
// add userid
    // Constructor with all fields
    public Item(int id, String category, String name, String brand,String ram,String model, String size, String color, String type, String description, String condition, String photo) {
        this.id=id;
        this.category = category;
        this.name = name;
        this.brand = brand;
        this.ram = ram;
        this.model = model;
        this.size = size;
        this.color = color;
        this.type = type;
        this.description = description;
        this.condition = condition;
        this.photo = photo;
    }

    public Item() {
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", ram='" + ram + '\'' +
                ", model='" + model + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", condition='" + condition + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

}
