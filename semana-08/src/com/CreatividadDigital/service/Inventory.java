package com.CreatividadDigital.service;
import com.CreatividadDigital.Modelo.Product;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public boolean removeProduct(String id) {
        return products.removeIf(p -> p.getId().equals(id));
    }

    public Product getProduct(String id) {
        for (Product p : products) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    public ArrayList<Product> getAll() {
        return products;
    }

    public int size() {
        return products.size();
    }
}
