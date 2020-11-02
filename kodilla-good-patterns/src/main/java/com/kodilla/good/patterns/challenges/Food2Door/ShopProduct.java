package com.kodilla.good.patterns.challenges.Food2Door;

public class ShopProduct {
    private String designation;
    private double price;
    private String opis;
    private int quantityInStock;

    public ShopProduct(String designation, double price, String opis, int quantityInStock) {
        this.designation = designation;
        this.price = price;
        this.opis = opis;
        this.quantityInStock = quantityInStock;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
