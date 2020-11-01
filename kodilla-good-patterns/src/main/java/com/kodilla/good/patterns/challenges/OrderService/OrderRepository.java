package com.kodilla.good.patterns.challenges.OrderService;

import java.util.HashSet;
import java.util.Set;

public class OrderRepository {
    Set<OrderDTO> orderList = new HashSet<>();
    public void addOrder(OrderDTO orderDTO){
        orderList.add(orderDTO);
    }
    public Set<OrderDTO> getOrderList(){
        return orderList;
    }
}
