package org.skypro.skyproshop;

import org.skypro.skyproshop.product.Product;
import java.util.*;
import java.util.stream.Collectors;

class ProductBasket {
    private HashMap<String, List<Product>> basket = new HashMap<>();

    public void addProduct(Product product) {
        basket.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public int totalPrice() {
        return basket.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void listOfProducts() {
        basket.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);
        System.out.println("Итого: " + totalPrice() + "\nСпециальные товары: " + getSpecialCount());
    }

    public long getSpecialCount() {
        return basket.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public boolean isProductInBasket(String name) {
        return basket.containsKey(name);
    }

    public void clearBasket() {
        basket.clear();
    }

    public List<Product> deleteProduct(String searchName) {
        List<Product> removedProducts = basket.values().stream()
                .flatMap(Collection::stream)
                .filter(product -> product.getName().contains(searchName))
                .collect(Collectors.toList());

        basket.forEach((name, products) -> products.removeIf(product -> product.getName().contains(searchName)));
        return removedProducts;
    }
}
