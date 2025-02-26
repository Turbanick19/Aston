package Lesson_5;

public class Main {

    public static void main(String[] args) {


        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 70000, true);
        productsArray[1] = new Product("Nokia 5130", "01.01.2010", "Nokia Corp.", "Finland", 3000, false);
        productsArray[2] = new Product("Redmi 14C", "01.08.2024", "Xiaomi Corp.", "China", 10000, true);
        productsArray[3] = new Product("iPhone 16", "09.09.2024", "Apple Corp.", "USA", 100000, false);
        productsArray[4] = new Product("Honor magic 7 pro", "01.02.2025", "Honor Corp.", "China", 130000, false);

        for (Product products : productsArray) {
            products.info();

        }

       
        Park sokolniki = new Park("Сокольники");
        Park.Attraction[] attractionsArray = new Park.Attraction[4];
        attractionsArray[0] = sokolniki.new Attraction("Качели", "10:00-20:00", 500);
        attractionsArray[1] = sokolniki.new Attraction("Тир", "12:00-20:00", 300);
        attractionsArray[2] = sokolniki.new Attraction("Молот", "10:00-18:00", 700);
        attractionsArray[3] = sokolniki.new Attraction("Американские горки", "10:00-19:00", 600);
        for (Park.Attraction attraction : attractionsArray) {
            System.out.println(attraction);
        }
    }
}