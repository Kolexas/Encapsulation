package org.skypro.skyproshop;

import java.util.Arrays;

class ProductBasket {
    private Product[] basket = new Product[5];

    public int findSpace() {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void addProduct(Product product) {
        int i = findSpace();
        if (i == -1) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        basket[i] = product;
    }

    public int totalPrice() {
        int total = 0;
        for (Product product : basket) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void listOfProducts() {
        int nullNum = 0;
        for (Product product : basket) {
            if (product == null) {
                nullNum++;
            } else {
                System.out.println(product);
            }
        }
        if (nullNum == basket.length) {
            System.out.println("в корзине пусто");
        } else System.out.println("Итого: " + totalPrice() + "\n Специальные товары: " + counter());
    }

    public boolean isProductInBasket(String name) {
        for (Product product : basket) {
            if (product != null && name.equals(product.getName())) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        Arrays.fill(basket, null);
    }

    public int counter() {
        int counter = 0;
        for (Product product : basket) {
            if (product != null) {
                if (product.isSpecial()) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
