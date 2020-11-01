package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.OrderService.*;

public class OrderMain {
    public static void main(String[] Args){
        Product product1 = new Product("Krzesło",300, "To jest krzesło.", 10);
        Product product2 = new Product("Stół",700, "To jest stół.", 4);
        Product product3 = new Product("Lóżko",1200, "To jest łóżko.", 3);
        InformationService informationService = new InformationService();
        informationService.addProduct(product1);
        informationService.addProduct(product2);
        informationService.addProduct(product3);
        OrderService orderService = new OrderService();
        OrderRepository orderRepository = new OrderRepository();
        User user = new User("Antoni" ,"Waciak", "86051100765", "antoni.waciak@gmail.com");
        OrderRequest orderRequest = new OrderRequest(user,product1,1);
        ProductOrderService productOrderService = new ProductOrderService(informationService, orderService, orderRepository);
        System.out.println(productOrderService.process(orderRequest));
    }
}
