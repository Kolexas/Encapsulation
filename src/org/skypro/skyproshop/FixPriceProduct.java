package org.skypro.skyproshop;

class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 1551;

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
