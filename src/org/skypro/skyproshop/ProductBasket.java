package org.skypro.skyproshop;

import org.skypro.skyproshop.product.Product;
import java.util.*;

class ProductBasket {
    private HashMap<String, List<Product>> basket = new HashMap<>();

    public void addProduct(Product product) {
        basket.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public int totalPrice() {
        int total = 0;
        for (List<Product> productList : basket.values()) {
            for (Product product : productList) {
                if (product != null) {
                    total += product.getPrice();
                }
            }

        }
        return total;
    }

    public void listOfProducts() {
        int nullNum = 0;
        for (List<Product> productList : basket.values()) {
            for (Product product : productList) {
                if (product == null) {
                    nullNum++;
                } else {
                    System.out.println(product);
                }
            }
        }
        if (nullNum == basket.size()) {
            System.out.println("в корзине пусто");
        } else System.out.println("Итого: " + totalPrice() + "\n Специальные товары: " + counter());
    }

    public boolean isProductInBasket(String name) {
        for (List<Product> productList : basket.values()) {
            for (Product product : productList) {
                if (product != null && name.equals(product.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clearBasket() {
        basket.clear();
    }

    public int counter() {
        int counter = 0;
        for (List<Product> productList : basket.values()) {
            for (Product product : productList) {
                if (product != null) {
                    if (product.isSpecial()) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public List<Product> deleteProduct(String name) {
        List<Product> deletedProducts = new ArrayList<>();
        for (List<Product> productList : basket.values()) {
            for (Product product : productList) {
                if (Objects.equals(product.getName(), name)) {
                    deletedProducts.add(product);
                    basket.remove(product.getName());
                }
            }
        }
        if (deletedProducts.isEmpty()) {
            System.out.print("Список пуст ");
        }
        return deletedProducts;
    }
}
