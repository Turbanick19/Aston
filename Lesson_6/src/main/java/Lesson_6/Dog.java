package Lesson_6;

public class Dog extends Animal {
    final static int maxRun = 500;
    final static int maxSwim = 10;
    public static int dogPerson;

    public Dog(String name) {
        super(name);
        dogPerson += 1;
    }

    public static void printCount() {
        System.out.println("Собак: " + dogPerson);
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + (distance > maxRun ? maxRun : distance) + " м");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + (distance > maxSwim ? maxSwim : distance) + " м");
    }
}
