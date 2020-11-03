package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.List;

public class HealthyShop implements Producer{
    private List<ShopProduct> HSlistOfProdukts;
    HealthyShop(List<ShopProduct> HSlistOfProdukts){
        this.HSlistOfProdukts = HSlistOfProdukts;
    }
    public OrderToRealizeDTO process(OrderProductDTO orderDTO){
        int amountOnStock = HSlistOfProdukts.get(orderDTO.getNumberOfProduct()).getQuantityInStock();
        double priceToPay=0;
        if (HSlistOfProdukts.size()<= orderDTO.getNumberOfProduct()){
            OrderToRealizeDTO orderToRealizeDTO = new OrderToRealizeDTO(false, orderDTO.getUserDate(), 0,
                    "", new ShopProduct("",0,"",0), 0);
            return orderToRealizeDTO;
        } else if (amountOnStock >= orderDTO.getAmountOfProduct()){
            amountOnStock -= orderDTO.getAmountOfProduct();
            ShopProduct shopProduct = HSlistOfProdukts.get(orderDTO.getNumberOfProduct());
            priceToPay = shopProduct.getPrice()*orderDTO.getAmountOfProduct();
            HSlistOfProdukts.get(orderDTO.getNumberOfProduct()).setQuantityInStock(amountOnStock);
            OrderToRealizeDTO orderToRealizeDTO = new OrderToRealizeDTO(true, orderDTO.getUserDate(), priceToPay,
                    orderDTO.getSupplierName(), shopProduct, orderDTO.getAmountOfProduct());
            return orderToRealizeDTO;
        } else {
            OrderToRealizeDTO orderToRealizeDTO = new OrderToRealizeDTO(false, orderDTO.getUserDate(), 0,
                    "", new ShopProduct("",0,"",0), 0);
            return orderToRealizeDTO;
        }
    }
}
