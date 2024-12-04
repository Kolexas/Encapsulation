package org.skypro.skyproshop;

import java.util.Objects;

public abstract class Product {
    private final String name;

    public Product(String name) {
        this.name = name;
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
}