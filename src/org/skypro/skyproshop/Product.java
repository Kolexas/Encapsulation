package org.skypro.skyproshop;

import SearchEngine.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {
        this.name = name;
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Такого товара не существует");
        }
    }

    public abstract boolean isSpecial();

    public String getName() {
        return name;
    }

    public abstract int getPrice();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public String getTypeOfContent() {
        return "PRODUCT";
    }
}