package org.skypro.skyproshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private float discount;

    public DiscountedProduct(String name, int discount, int basePrice) {
        super(name);
        this.discount = discount;
        this.basePrice = basePrice;
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Такая скидка невозможна");
        }
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