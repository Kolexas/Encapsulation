package org.skypro.skyproshop;

import SearchEngine.SearchEngine;
import SearchEngine.Article;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket basket1 = new ProductBasket();
        basket1.addProduct(new SimpleProduct("Банан", 150));
        basket1.addProduct(new SimpleProduct("Клубника", 300));
        basket1.addProduct(new SimpleProduct("Хлеб", 80));
        basket1.addProduct(new SimpleProduct("Мандарины", 100));
        basket1.addProduct(new SimpleProduct("Йогурт", 50));
        basket1.addProduct(new SimpleProduct("Колбаса", 600));
        ProductBasket basket2 = new ProductBasket();
        basket2.addProduct(new SimpleProduct("Колбаса", 600));
        basket2.addProduct(new SimpleProduct("Cыр", 300));
        basket2.listOfProducts();
        System.out.println(basket2.totalPrice());
        System.out.println(basket2.isProductInBasket("Колбаса"));
        System.out.println(basket2.isProductInBasket("Йогурт"));
        basket2.clearBasket();
        basket2.listOfProducts();
        System.out.println(basket2.totalPrice());
        System.out.println(basket2.isProductInBasket("Йогурт"));
        basket2.addProduct(new FixPriceProduct("Малина"));
        basket2.addProduct(new DiscountedProduct("Колбаса", 10, 600));
        basket2.addProduct(new FixPriceProduct("Малина"));
        basket2.addProduct(new DiscountedProduct("Колбаса", 10, 600));
        basket2.addProduct(new SimpleProduct("Мандарины", 100));
        basket2.listOfProducts();
        SearchEngine engine = new SearchEngine(10);
        engine.addSearchable(new FixPriceProduct("Малина"));
        engine.addSearchable(new SimpleProduct("Банан", 150));
        engine.addSearchable(new SimpleProduct("Клубника", 300));
        engine.addSearchable(new SimpleProduct("Хлеб", 80));
        engine.addSearchable(new SimpleProduct("Мандарины", 100));
        engine.addSearchable(new SimpleProduct("Йогурт", 50));
        engine.addSearchable(new DiscountedProduct("Колбаса", 10, 600));
        engine.addSearchable(new Article("Мандарины", "Из Абхазии"));
        engine.addSearchable(new Article("Вино", "Из Грузии"));
        System.out.println(Arrays.toString(engine.search("Мандарины")));

    }
}