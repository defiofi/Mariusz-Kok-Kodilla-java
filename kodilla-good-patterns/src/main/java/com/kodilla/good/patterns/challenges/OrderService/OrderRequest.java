package com.kodilla.good.patterns.challenges.OrderService;

public class OrderRequest {
    private User user;
    private Product product;
    private int amount;

    public OrderRequest(User user, Product product, int amount) {
        this.user = user;
        this.product = product;
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
