package com.kodilla.good.patterns.challenges.Food2Door;

public class OrderProductDTO {
    private String supplierName;
    private int numberOfProduct;
    private int amountOfProduct;
    private UserDate userDate;

    public OrderProductDTO(String supplierName, int numberOfProduct, int amountOfProduct, UserDate userDate) {
        this.supplierName = supplierName;
        this.numberOfProduct = numberOfProduct;
        this.amountOfProduct = amountOfProduct;
        this.userDate = userDate;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getNumberOfProduct() {
        return numberOfProduct;
    }

    public void setNumberOfProduct(int numberOfProduct) {
        this.numberOfProduct = numberOfProduct;
    }

    public int getAmountOfProduct() {
        return amountOfProduct;
    }

    public void setAmountOfProduct(int amountOfProduct) {
        this.amountOfProduct = amountOfProduct;
    }

    public UserDate getUserDate() {
        return userDate;
    }

    public void setUserDate(UserDate userDate) {
        this.userDate = userDate;
    }
}
