package org.skypro.skyproshop;

class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        this.price = price;
        if (price <= 0) {
            throw new IllegalArgumentException("Отрицательная цена");
        }
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