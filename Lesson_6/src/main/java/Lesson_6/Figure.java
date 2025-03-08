package Lesson_6;

public interface Figure {
    double getPerimeter();
    double getArea();
    String getBgColor();
    String getBorderColor();

    default void printCharacteristics() {
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет фона: " + getBgColor());
        System.out.println("Цвет границы: " + getBorderColor());
    }


}