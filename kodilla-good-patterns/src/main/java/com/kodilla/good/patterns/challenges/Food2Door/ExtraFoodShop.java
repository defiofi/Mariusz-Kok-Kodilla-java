package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.List;

public class ExtraFoodShop implements Producer{
    private List<ShopProduct> EFSlistOfProdukts;
    ExtraFoodShop(List<ShopProduct> EFSlistOfProdukts){
        this.EFSlistOfProdukts = EFSlistOfProdukts;
    }
    public OrderToRealizeDTO process(OrderProductDTO orderDTO){
        int amountOnStock = EFSlistOfProdukts.get(orderDTO.getNumberOfProduct()).getQuantityInStock();
        double priceToPay=0;
        boolean itIsDone;
        if (EFSlistOfProdukts.size()<= orderDTO.getNumberOfProduct()){
            itIsDone = false;
            OrderToRealizeDTO orderToRealizeDTO = new OrderToRealizeDTO(itIsDone, orderDTO.getUserDate(), 0,
                    "", new ShopProduct("",0,"",0), 0);
            return orderToRealizeDTO;
        } else if (amountOnStock >= orderDTO.getAmountOfProduct()){
            amountOnStock -= orderDTO.getAmountOfProduct();
            ShopProduct shopProduct = EFSlistOfProdukts.get(orderDTO.getNumberOfProduct());
            priceToPay = shopProduct.getPrice()*orderDTO.getAmountOfProduct();
            EFSlistOfProdukts.get(orderDTO.getNumberOfProduct()).setQuantityInStock(amountOnStock);
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
