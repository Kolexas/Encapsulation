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

class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return getName() + ": " + price;
    }

    public boolean isSpecial() {
        return false;
    }
}

class DiscountedProduct extends Product {
    int basePrice;
    float discount;

    public DiscountedProduct(String name, int discount, int basePrice) {
        super(name);
        this.discount = discount;
        this.basePrice = basePrice;
    }


    public int getPrice() {
        return (int) (basePrice * (1 - discount / 100f));
    }

    public String toString() {
        return getName() + " со скидкой: " + getPrice();
    }

    public boolean isSpecial() {
        return true;
    }
}


class FixPriceProduct extends Product {
    static final int FIX_PRICE = 1551;

    public FixPriceProduct(String name) {
        super(name);
    }

    public int getPrice() {
        return FIX_PRICE;
    }

    public String toString() {
        return getName() + " : Фиксированная цена " + FIX_PRICE;
    }

    public boolean isSpecial() {
        return true;
    }
}

