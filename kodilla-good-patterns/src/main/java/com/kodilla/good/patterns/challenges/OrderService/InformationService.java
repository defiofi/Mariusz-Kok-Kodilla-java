package com.kodilla.good.patterns.challenges.OrderService;

import java.util.ArrayList;
import java.util.List;

public class InformationService {
    private List<Product> listOfProducts = new ArrayList<>();
    public void addProduct(Product product){
        listOfProducts.add(product);
    }
    public ProductDTO getDTO(int numberOfProduct, int amount)throws RuntimeException{
        if (listOfProducts.size()>numberOfProduct) {
                ProductDTO DTO = new ProductDTO(listOfProducts.get(numberOfProduct), amount);
                return DTO;
        } else
            throw new RuntimeException("Nie ma takiego produktu.");
    }
    public void showProduct(int number){
        if (listOfProducts.size()>number) {
            Product product = listOfProducts.get(number);
            System.out.println("Produkt " + product.getDesignation());
            System.out.println("Opis produktu: " + product.getOpis());
            System.out.println("Cena produktu: " + product.getPrice());
            System.out.println("ilość w magazynie: " + product.getQuantityInStock());
        }
    }
    public int getNumberOfProducts(){
        return listOfProducts.size();
    }
}
