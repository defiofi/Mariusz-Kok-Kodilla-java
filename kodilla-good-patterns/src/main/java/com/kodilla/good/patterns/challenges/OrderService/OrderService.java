package com.kodilla.good.patterns.challenges.OrderService;

import java.time.LocalDate;

public class OrderService {
    public OrderDTO order(OrderRequest orderRequest) throws RuntimeException{
        if (orderRequest.getProduct().getQuantityInStock() >= orderRequest.getAmount()){
            orderRequest.getProduct().subtract(orderRequest.getAmount());
            LocalDate localDate = LocalDate.now();
            OrderDTO orderDTO = new OrderDTO(orderRequest.getUser(), orderRequest.getProduct(),
                    orderRequest.getAmount() *orderRequest.getProduct().getPrice(), localDate);
            return orderDTO;
        } else
            throw new RuntimeException("Nie ma w magazynie wystarczającej ilości produktu.");

    }
    public boolean checkPosibility(OrderRequest orderRequest){
        if (orderRequest.getProduct().getQuantityInStock() >= orderRequest.getAmount()) {
            return true;
        } else {
            return false;
        }
    }
}
