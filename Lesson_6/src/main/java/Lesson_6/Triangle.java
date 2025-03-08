package Lesson_6;

public class Triangle implements Figure {
    private int a;
    private int b;
    private int c;
    private String bgColor;
    private String borderColor;

    public Triangle(int a, int b, int c, String bgColor, String borderColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.bgColor = bgColor;
        this.borderColor = borderColor;
    }


    @Override
    public double getPerimeter() {
        return a + b + c;
    }


    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }


    @Override
    public String getBgColor() {
        return bgColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}