package com.example.managefood.Model;

public class Food {
    private String Type,Name,Description ,Image,Status;
    private int Price;

    public Food() {
    }

    public Food(String type, String name, String description, int price, String status, String image) {
        Type = type;
        Name = name;
        Description = description;
        Price = price;
        Status = status;
        Image = image;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }



    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getStatus() {
        return Status;
    }
}
