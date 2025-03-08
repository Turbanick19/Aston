package Lesson_6;

public abstract class Animal {
    String name;
    public static int animalPerson;

    public Animal(String name) {
        this.name = name;
        animalPerson += 1;
    }

    public static void printCount() {
        System.out.println("Животных: " + animalPerson);
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + "м");
    }
    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + "м");
    }
}
