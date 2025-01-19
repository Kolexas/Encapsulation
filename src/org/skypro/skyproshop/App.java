package org.skypro.skyproshop;

import org.skypro.skyproshop.exception.BestResultNotFound;
import org.skypro.skyproshop.product.*;
import org.skypro.skyproshop.searchEngine.SearchEngine;

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
        SearchEngine engine = new SearchEngine();
        engine.addSearchable(new FixPriceProduct("Малина"));
        engine.addSearchable(new SimpleProduct("Банан", 150));
        engine.addSearchable(new SimpleProduct("Клубника", 300));
        engine.addSearchable(new SimpleProduct("Хлеб", 80));
        engine.addSearchable(new SimpleProduct("Мандарины", 100));
        engine.addSearchable(new SimpleProduct("Йогурт", 50));
        engine.addSearchable(new DiscountedProduct("Колбаса", 10, 600));
        engine.addSearchable(new Article("Мандарины", "из Абхазии"));
        engine.addSearchable(new Article("Вино", "из Грузии"));
        engine.addSearchable(new SimpleProduct("Мёд", 150));
        engine.addSearchable(new SimpleProduct("Мюсли", 220));
        engine.addSearchable(new SimpleProduct("Мясо", 250));
        System.out.println((engine.search("М")));
        ProductBasket basket3 = new ProductBasket();
        basket3.addProduct((new SimpleProduct("Малина", 150)));
        basket3.addProduct((new SimpleProduct("Мандарины", 150)));
        basket3.addProduct(new DiscountedProduct("Колбаса", 10, 600));
        basket3.addProduct(new FixPriceProduct("Малина"));
        System.out.println(basket3.deleteProduct("Малина"));
        basket3.listOfProducts();
        System.out.println(basket3.deleteProduct("Хлеб"));
        basket3.listOfProducts();
        try {
            basket3.addProduct(new SimpleProduct(" ", 120));
        } catch (IllegalArgumentException exp_name) {
            System.out.println(exp_name);
        }
        try {
            basket3.addProduct(new SimpleProduct("Банан", -150));
        } catch (IllegalArgumentException exp_price) {
            System.out.println(exp_price);
        }
        try {
            basket3.addProduct(new DiscountedProduct("Малина", 120, 150));
        } catch (IllegalArgumentException exp_discount) {
            System.out.println(exp_discount);
        }
        try {
            System.out.println(engine.findBestMatch("Малина"));
        } catch (BestResultNotFound exp_noResult) {
            System.out.println(exp_noResult);
        }
        try {
            System.out.println(engine.findBestMatch("Ручка"));
        } catch (BestResultNotFound exp_noResult) {
            System.out.println(exp_noResult);
        }
    }
}