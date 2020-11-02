package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.kodilla.good.patterns.challenges.Food2Door.DataBase.*;

/** Różnica między sklepami to zupełnie inne listy produktów */
public class ShopOrderMain {
    public static void main(String[] Args){
        DataBase dataBase = new DataBase();
        List<ShopProduct> EFSList = dataBase.EFSproductDatabase();
        List<ShopProduct> GFSList = dataBase.GFSproductDatabase();
        List<ShopProduct> HSList = dataBase.HSproductDatabase();
        ExtraFoodShop extraFoodShop = new ExtraFoodShop(EFSList);
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop(GFSList);
        HealthyShop healthyShop = new HealthyShop(HSList);
        Map<String,Producer> producerMap = new HashMap<>();
        producerMap.put(EFSNameSuplier, extraFoodShop);
        producerMap.put(GFSNameSuplier, glutenFreeShop);
        producerMap.put(HSNameSuplier, healthyShop);
        UserDate userDate[] = new UserDate[3];
        userDate[0] = new UserDate("Antoni", "Kowal", "65111500652", "Antoni.Kowal@gmail.com" );
        userDate[1] = new UserDate("Zbigniew", "Nowak", "85100500325", "Zbig.Nowak@gmail.com" );
        userDate[2] = new UserDate("Daniel", "Zwierzę", "75010500212", "Daniel.Zwierz@gmail.com" );
        OrderProductDTO orderProductDTO[] = new OrderProductDTO[4];
        orderProductDTO[0] = dataBase.getOrderEFS(1,1, userDate[0]);
        orderProductDTO[1] = dataBase.getOrderGFS(2,5, userDate[1]);
        orderProductDTO[2] = dataBase.getOrderHS(3,10, userDate[2]);
        orderProductDTO[3] = dataBase.getOrderHS(4,30, userDate[2]);
        ServisOrder servisOrder = new ServisOrder(producerMap.get(EFSNameSuplier));
        boolean itIsDone;
        for (int i = 0 ; i< orderProductDTO.length ; i++) {
            servisOrder.changeProducer(producerMap.get(orderProductDTO[i].getSupplierName()));
            itIsDone = servisOrder.run(orderProductDTO[i]);
            if (itIsDone) {
                System.out.println("Zamówienie przyjęte");
            } else {
                System.out.println("Zamówienie odrzucone");
            }
        }
        Set<OrderToRealizeDTO> orderList = servisOrder.getOrderList();
    }
}
