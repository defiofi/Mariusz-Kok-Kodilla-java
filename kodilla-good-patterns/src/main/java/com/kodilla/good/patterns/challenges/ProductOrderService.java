package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.OrderService.*;

import java.util.Set;

public class ProductOrderService {

    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public ProductOrderService(InformationService informationService, OrderService orderService, OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }
    public String process( OrderRequest orderRequest) {
        /*for (int i = 0 ; i < informationService.getNumberOfProducts() ; i++){
            informationService.showProduct(i);
        }*/
        if (orderService.checkPosibility(orderRequest)) {
            OrderDTO orderDTO = orderService.order(orderRequest);
            orderRepository.addOrder(orderDTO);
            return "Produkt zamówiono.";
        } else {
            return "Nie ma w magazynie wystarczającej ilości produktu.";
        }
    }
    public Set<OrderDTO> getOrderList(){
        return orderRepository.getOrderList();
    }
}

