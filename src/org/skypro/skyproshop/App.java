package org.skypro.skyproshop;

public class App {
    public static void main(String[] args) {
        ProductBasket basket1 = new ProductBasket();
        basket1.addProduct(new Product("Банан", 150));
        basket1.addProduct(new Product("Клубника", 300));
        basket1.addProduct(new Product("Хлеб", 80));
        basket1.addProduct(new Product("Мандарины", 100));
        basket1.addProduct(new Product("Йогурт", 50));
        basket1.addProduct(new Product("Колбаса", 600));
        ProductBasket basket2 = new ProductBasket();
        basket2.addProduct(new Product("Колбаса", 600));
        basket2.addProduct(new Product("Cыр", 300));
        basket2.listOfProducts();
        System.out.println(basket2.totalPrice());
        System.out.println(basket2.isProductInBasket("Колбаса"));
        System.out.println(basket2.isProductInBasket("Йогурт"));
        basket2.clearBasket();
        basket2.listOfProducts();
        System.out.println(basket2.totalPrice());
        System.out.println(basket2.isProductInBasket("Йогурт"));
    }
}