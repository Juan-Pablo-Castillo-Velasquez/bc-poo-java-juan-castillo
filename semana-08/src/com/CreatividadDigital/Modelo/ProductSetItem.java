package com.CreatividadDigital.Modelo;

public class ProductSetItem {
    private String name;

    public ProductSetItem(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductSetItem)) return false;
        ProductSetItem p = (ProductSetItem) o;
        return name.equalsIgnoreCase(p.name);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return "ProductoSet { nombre='" + name + "' }";
    }
}
