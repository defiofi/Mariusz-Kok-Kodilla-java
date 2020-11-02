package com.kodilla.good.patterns.challenges.Food2Door;

public class OrderToRealizeDTO {
    private boolean itIsDone;
    private UserDate user;
    private double price;
    private String supplierName;
    private ShopProduct shopProduct;
    private int amountOfProduct;

    public OrderToRealizeDTO(boolean itIsDone, UserDate user, double price, String supplierName, ShopProduct shopProduct,
                             int amountOfProduct) {
        this.itIsDone = itIsDone;
        this.user = user;
        this.price = price;
        this.supplierName = supplierName;
        this.shopProduct = shopProduct;
        this.amountOfProduct = amountOfProduct;
    }

    public UserDate getUser() {
        return user;
    }

    public void setUser(UserDate user) {
        this.user = user;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public ShopProduct getShopProduct() {
        return shopProduct;
    }

    public void setShopProduct(ShopProduct shopProduct) {
        this.shopProduct = shopProduct;
    }

    public int getAmountOfProduct() {
        return amountOfProduct;
    }

    public void setAmountOfProduct(int amountOfProduct) {
        this.amountOfProduct = amountOfProduct;
    }

    public boolean isItIsDone() {
        return itIsDone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderToRealizeDTO that = (OrderToRealizeDTO) o;

        if (itIsDone != that.itIsDone) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (amountOfProduct != that.amountOfProduct) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (supplierName != null ? !supplierName.equals(that.supplierName) : that.supplierName != null) return false;
        return shopProduct != null ? shopProduct.equals(that.shopProduct) : that.shopProduct == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (itIsDone ? 1 : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (supplierName != null ? supplierName.hashCode() : 0);
        result = 31 * result + (shopProduct != null ? shopProduct.hashCode() : 0);
        result = 31 * result + amountOfProduct;
        return result;
    }
}
