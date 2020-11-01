package com.kodilla.good.patterns.challenges.OrderService;

public class Product {
    private String designation;
    private double price;
    private String opis;
    private int quantityInStock;

    public Product(String designation, double price, String opis, int quantityInStock) {
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
    public void subtract(int amount){
        this.quantityInStock -= amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.price, price) != 0) return false;
        if (designation != null ? !designation.equals(product.designation) : product.designation != null) return false;
        return opis != null ? opis.equals(product.opis) : product.opis == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = designation != null ? designation.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (opis != null ? opis.hashCode() : 0);
        return result;
    }
}
