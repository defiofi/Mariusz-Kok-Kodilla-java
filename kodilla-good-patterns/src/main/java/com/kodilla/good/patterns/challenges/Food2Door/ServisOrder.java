package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.HashSet;
import java.util.Set;

public class ServisOrder {
    Producer producer;
    private Set<OrderToRealizeDTO> orderList = new HashSet<>();
    ServisOrder(Producer producer){
        this.producer = producer;
    }
    public void changeProducer(Producer producer){
        this.producer = producer;
    }
    public boolean run(OrderProductDTO orderDTO){
        OrderToRealizeDTO orderToRealizeDTO = producer.process(orderDTO);
        if (orderToRealizeDTO.isItIsDone()) {
            orderList.add(orderToRealizeDTO);
            return orderToRealizeDTO.isItIsDone();
        } else {
            return orderToRealizeDTO.isItIsDone();
        }
    }
    public Set<OrderToRealizeDTO> getOrderList(){
        return orderList;
    }
}
