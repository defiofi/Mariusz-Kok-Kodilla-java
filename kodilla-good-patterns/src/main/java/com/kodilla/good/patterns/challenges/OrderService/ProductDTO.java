package com.kodilla.good.patterns.challenges.OrderService;

public class ProductDTO {
    private Product product;
    private int amountOfproducts;

    public ProductDTO(Product product, int amountOfproducts) {
        this.product = product;
        this.amountOfproducts = amountOfproducts;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmountOfproducts() {
        return amountOfproducts;
    }

    public void setAmountOfproducts(int amountOfproducts) {
        this.amountOfproducts = amountOfproducts;
    }
}
