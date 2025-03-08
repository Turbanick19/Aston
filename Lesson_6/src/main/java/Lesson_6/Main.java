package Lesson_6;

public class Main {
    public static void main(String[] args) {
        //Задание 1:

        Dog dogBobik = new Dog("Бобик");
        dogBobik.run(150);
        dogBobik.swim(20);

        Cat catBarsik = new Cat("Барсик");
        catBarsik.run(350);
        catBarsik.swim(0);

        Cat catBlack = new Cat("Черныш");
        catBlack.run(250);
        catBlack.swim(0);

        Animal.printCount();
        Dog.printCount();
        Cat.printCount();

        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Барсик");
        cats[1] = new Cat("Черныш", 15);
        cats[2] = new Cat("Рыжик", 45);

        Bowl catsBowl = new Bowl(70);
        for (Cat cat : cats) {
            cat.eat(catsBowl);
            cat.printWellfed();
        }
        
        //Задание 2:


        Circle circle = new Circle(40, "Фиолетовый", "Белый");
        System.out.println("\nКруг:");
        circle.printCharacteristics();

        Rectangle rectangle = new Rectangle(40, 50, "Синий", "Зеленый");
        System.out.println("\nПрямоугольник:");
        rectangle.printCharacteristics();

        Triangle triangle = new Triangle(10, 20, 25, "Красный", "Желтый");
        System.out.println("\nТреугольник:");
        triangle.printCharacteristics();


    }
}