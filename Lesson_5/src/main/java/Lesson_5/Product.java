package Lesson_5;

public class Product {
    private String name;
    private String date;
    private String producer;
    private String country;
    private int price;
    private boolean booking;

    public Product(String name, String date, String producer, String country, int price, boolean booking) {
        this.name = name;
        this.date = date;
        this.producer = producer;
        this.country = country;
        this.price = price;
        this.booking = booking;
    }


    public void info() {
        System.out.println("Название: " + name +
                ", дата производства: " + date +
                ", производитель: " + producer +
                ", страна происхождения: " + country +
                ", цена: " + price +
                ", состояние бронирования покупателем: " + booking + ";");
    }
}
