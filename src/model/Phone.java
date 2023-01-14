package model;

import java.util.Random;

public class Phone {
    private String id;
    private String name;
    private String brand;
    private String price;
    private String quantity;

    public Phone(String name, String brand, String price, String quantity) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        setId();
    }

    public String getId() {
        return id;
    }

    private void setId() {
        Random rand = new Random();
        String alphanumeric = "abcdefghijklmnopqrstuvwxyz0123456789";
        String num = "";
        Integer mix = -1;
        for (int i = 0; i < 5; i++) {
            mix = rand.nextInt(alphanumeric.length());
            num += (alphanumeric.substring(mix, mix + 1));
        }
        this.id = num;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
