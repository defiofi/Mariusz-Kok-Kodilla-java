package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.ArrayList;
import java.util.List;

public class GlutenFreeShop implements Producer{
    private List<ShopProduct> GFSlistOfProdukts = new ArrayList<>();
    GlutenFreeShop(List<ShopProduct> GFSlistOfProdukts){
        this.GFSlistOfProdukts = GFSlistOfProdukts;
    }
    public OrderToRealizeDTO process(OrderProductDTO orderDTO){
        int amountOnStock = GFSlistOfProdukts.get(orderDTO.getNumberOfProduct()).getQuantityInStock();
        double priceToPay=0;
        boolean itIsDone;
        if (GFSlistOfProdukts.size()<= orderDTO.getNumberOfProduct()){
            itIsDone = false;
            OrderToRealizeDTO orderToRealizeDTO = new OrderToRealizeDTO(itIsDone, orderDTO.getUserDate(), 0,
                    "", new ShopProduct("",0,"",0), 0);
            return orderToRealizeDTO;
        } else if (amountOnStock >= orderDTO.getAmountOfProduct()){
            amountOnStock -= orderDTO.getAmountOfProduct();
            ShopProduct shopProduct = GFSlistOfProdukts.get(orderDTO.getNumberOfProduct());
            priceToPay = shopProduct.getPrice()*orderDTO.getAmountOfProduct();
            GFSlistOfProdukts.get(orderDTO.getNumberOfProduct()).setQuantityInStock(amountOnStock);
            itIsDone = true;
            OrderToRealizeDTO orderToRealizeDTO = new OrderToRealizeDTO(itIsDone, orderDTO.getUserDate(), priceToPay,
                    orderDTO.getSupplierName(), shopProduct, orderDTO.getAmountOfProduct());
            return orderToRealizeDTO;
        } else {
            itIsDone = false;
            OrderToRealizeDTO orderToRealizeDTO = new OrderToRealizeDTO(itIsDone, orderDTO.getUserDate(), 0,
                    "", new ShopProduct("",0,"",0), 0);
            return orderToRealizeDTO;
        }
    }
}
