package com.restaurant.model;

public class Dish {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private Integer available;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public Integer getAvailable() { return available; }
    public void setAvailable(Integer available) { this.available = available; }
}