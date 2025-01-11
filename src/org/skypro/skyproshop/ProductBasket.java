package org.skypro.skyproshop;

import org.skypro.skyproshop.product.Product;
import java.util.*;

class ProductBasket {
    private List<Product> basket = new ArrayList<>();


    public void addProduct(Product product) {
        basket.add(product);
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
        if (nullNum == basket.size()) {
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
        basket.clear();
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

    public List<Product> deleteProduct(String name) {
        List<Product> deletedProducts = new ArrayList<>();
        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product element = iterator.next();
            if (Objects.equals(element.getName(), name)) {
                deletedProducts.add(element);
                iterator.remove();
            }
        }
        if (deletedProducts.isEmpty()) {
            System.out.print("Список пуст ");
        }
        return deletedProducts;
    }
}
