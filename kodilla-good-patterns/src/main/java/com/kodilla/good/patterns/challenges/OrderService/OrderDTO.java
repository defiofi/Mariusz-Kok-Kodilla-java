package com.kodilla.good.patterns.challenges.OrderService;

import java.time.LocalDate;

public class OrderDTO {
    private User user;
    private Product product;
    private double price;
    private LocalDate dateOfOrder;

    public OrderDTO(User user, Product product, double price, LocalDate dateOfOrder) {
        this.user = user;
        this.product = product;
        this.price = price;
        this.dateOfOrder = dateOfOrder;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }
}
