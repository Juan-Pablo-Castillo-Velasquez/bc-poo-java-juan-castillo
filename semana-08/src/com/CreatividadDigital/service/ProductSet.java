package com.CreatividadDigital.service;

import com.CreatividadDigital.Modelo.ProductSetItem;

import java.util.HashSet;
import java.util.Set;

public class ProductSet {
    private Set<ProductSetItem> items = new HashSet<>();

    public void add(ProductSetItem item) {
        items.add(item);
    }

    public boolean remove(String name) {
        return items.remove(new ProductSetItem(name));
    }

    public Set<ProductSetItem> getAll() {
        return items;
    }

    public Set<ProductSetItem> union(Set<ProductSetItem> b) {
        Set<ProductSetItem> result = new HashSet<>(items);
        result.addAll(b);
        return result;
    }

    public Set<ProductSetItem> intersection(Set<ProductSetItem> b) {
        Set<ProductSetItem> result = new HashSet<>(items);
        result.retainAll(b);
        return result;
    }

    public Set<ProductSetItem> difference(Set<ProductSetItem> b) {
        Set<ProductSetItem> result = new HashSet<>(items);
        result.removeAll(b);
        return result;
    }
}
