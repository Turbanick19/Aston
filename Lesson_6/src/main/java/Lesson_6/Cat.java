package Lesson_6;

public class Cat extends Animal {

    final static int maxRun = 200;
    final static int portion = 20;
    public int portionSize;
    public static int catPerson;
    public boolean isWellfed;

    public Cat(String name) {
        this(name, portion);
    }

    public Cat(String name, int portionSize) {
        super(name);
        this.portionSize = portionSize;
        isWellfed = false;
        catPerson += 1;
    }

    public static void printCount() {
        System.out.println("Котов: " + catPerson);
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + (distance > maxRun ? maxRun : distance) + " м");
    }

    public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
    }

    public void eat(Bowl bowl) {
        if (!isWellfed && bowl.foodAmount > portionSize) {
            isWellfed = true;
            System.out.println(name + " съел " + portionSize);
            bowl.decFood(portionSize);
        } else {
            System.out.println(name + " не поел. Ему нужно " + portionSize + " - в миске " + bowl.foodAmount);
        }

    }

    public void printWellfed() {
        System.out.println(name + (isWellfed ? " сытый" : " голодный"));
        ;
    }
}
