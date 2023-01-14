package model;

import java.util.Random;

public class Phone {
    private String id;
    private String name;
    private String brand;
    private int price;
    private int quantity;

    public Phone(String name, String brand, int price, int quantity) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
