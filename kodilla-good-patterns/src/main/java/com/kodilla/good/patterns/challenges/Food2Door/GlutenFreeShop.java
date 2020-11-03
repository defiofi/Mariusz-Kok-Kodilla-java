package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.List;

public class GlutenFreeShop implements Producer{
    private List<ShopProduct> GFSlistOfProdukts;
    GlutenFreeShop(List<ShopProduct> GFSlistOfProdukts){
        this.GFSlistOfProdukts = GFSlistOfProdukts;
    }
    public OrderToRealizeDTO process(OrderProductDTO orderDTO){
        int amountOnStock = GFSlistOfProdukts.get(orderDTO.getNumberOfProduct()).getQuantityInStock();
        double priceToPay=0;
        if (GFSlistOfProdukts.size()<= orderDTO.getNumberOfProduct()){
            OrderToRealizeDTO orderToRealizeDTO = new OrderToRealizeDTO(false, orderDTO.getUserDate(), 0,
                    "", new ShopProduct("",0,"",0), 0);
            return orderToRealizeDTO;
        } else if (amountOnStock >= orderDTO.getAmountOfProduct()){
            amountOnStock -= orderDTO.getAmountOfProduct();
            ShopProduct shopProduct = GFSlistOfProdukts.get(orderDTO.getNumberOfProduct());
            priceToPay = shopProduct.getPrice()*orderDTO.getAmountOfProduct();
            GFSlistOfProdukts.get(orderDTO.getNumberOfProduct()).setQuantityInStock(amountOnStock);
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
