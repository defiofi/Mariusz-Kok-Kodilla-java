package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    /** KLASA JEST DLA SYMULACJI LIST PRODUKTÓW KAŻDEGO Z DOSTAWCÓW ORAZ DO WYGENEROWANIA ZAMÓWIEN DO DANEGO DOSTAWCY */
    public static final String EFSNameSuplier = "ExtraFoodShop";
    public static final String GFSNameSuplier = "GlutenFreeShop";
    public static final String HSNameSuplier = "HealthyShop";
    private List<ShopProduct> EFSlistOfProdukts = new ArrayList<>();
    private List<ShopProduct> GFSlistOfProdukts = new ArrayList<>();
    private List<ShopProduct> HSlistOfProdukts = new ArrayList<>();
    DataBase(){
        ShopProduct shopProduct[] = new ShopProduct[5];
        shopProduct[0] = new ShopProduct("Kiełbasa śląska - 1kg",50 ,"To jest kiełbasa",20);
        shopProduct[1] = new ShopProduct("Pizza Peperoni prosto z pieca",35 ,"Pizza, zawsze świeża",30);
        shopProduct[2] = new ShopProduct("Chlep żytni ",50 ,"To jest smaczny chleb",50);
        shopProduct[3] = new ShopProduct("Kasza gryczana - 1kg",20 ,"To jest kasza gryczana",10);
        shopProduct[4] = new ShopProduct("Smalec - 0,5kg",17 ,"To jest pyszny smalec",7);
        for (int i = 0 ; i< shopProduct.length; i++) {
            this.EFSlistOfProdukts.add(shopProduct[i]);
        }
        shopProduct[0] = new ShopProduct("Kiełbasa myśliwska - 1kg",60 ,"To jest kiełbasa dla myśliwych",10);
        shopProduct[1] = new ShopProduct("Pizza bezguteinowa",45 ,"Pizza, bez glutenu",20);
        shopProduct[2] = new ShopProduct("Chlep gryczany bez glutenu ",20 ,"To jest chleb bez glutenu",30);
        shopProduct[3] = new ShopProduct("Kasza gryczana - 1kg",22 ,"To jest kasza gryczana",25);
        shopProduct[4] = new ShopProduct("Smalec śląski- 0,5kg",23 ,"To jest bardzo pyszny smalec",10);
        for (int i = 0 ; i< shopProduct.length; i++) {
            this.GFSlistOfProdukts.add(shopProduct[i]);
        }
        shopProduct[0] = new ShopProduct("Kiełbasa wegetariańska - 0,5kg",60 ,"To jest kiełbasa dla wegetarian",7);
        shopProduct[1] = new ShopProduct("Pizza wegetariańska",50 ,"Najzdrowsza pizza na świecie",15);
        shopProduct[2] = new ShopProduct("Wafle ryżowe ",15 ,"To jest samo zdrowie",50);
        shopProduct[3] = new ShopProduct("Kasza gryczana BIO - 1kg",25 ,"To jest kasza ekologiczna gryczana",15);
        shopProduct[4] = new ShopProduct("Oliwa z oliwek- 0,5kg",30 ,"To jest bardzo zdrowa oliwa",10);

        for (int i = 0 ; i< shopProduct.length; i++) {
            this.HSlistOfProdukts.add(shopProduct[i]);
        }
    }
    public List<ShopProduct> EFSproductDatabase(){
        return EFSlistOfProdukts;
    }
    public OrderProductDTO getOrderEFS(int numberOfProduct, int amount, UserDate userDate) throws RuntimeException{
        if (numberOfProduct< EFSlistOfProdukts.size()){
            OrderProductDTO orderProductDTO = new OrderProductDTO(EFSNameSuplier, numberOfProduct, amount, userDate);
            return orderProductDTO;
        } else {
            throw new RuntimeException("Nie ma takiego produktu na liście.");
        }
    }
    public List<ShopProduct> GFSproductDatabase(){
        return GFSlistOfProdukts;
    }
    public OrderProductDTO getOrderGFS(int numberOfProduct, int amount, UserDate userDate) throws RuntimeException{
        if (numberOfProduct< GFSlistOfProdukts.size()){
            OrderProductDTO orderProductDTO = new OrderProductDTO(GFSNameSuplier, numberOfProduct, amount, userDate);
            return orderProductDTO;
        } else {
            throw new RuntimeException("Nie ma takiego produktu na liście.");
        }
    }
    public List<ShopProduct> HSproductDatabase(){
        return HSlistOfProdukts;
    }
    public OrderProductDTO getOrderHS(int numberOfProduct, int amount, UserDate userDate) throws RuntimeException{
        if (numberOfProduct< HSlistOfProdukts.size()){
            OrderProductDTO orderProductDTO = new OrderProductDTO(HSNameSuplier, numberOfProduct, amount, userDate);
            return orderProductDTO;
        } else {
            throw new RuntimeException("Nie ma takiego produktu na liście.");
        }
    }
}
