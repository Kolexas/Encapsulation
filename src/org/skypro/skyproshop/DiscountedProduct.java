package org.skypro.skyproshop;

class DiscountedProduct extends Product {
    private int basePrice;
    private float discount;

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