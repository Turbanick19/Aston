package Lesson_6;

public class Rectangle implements Figure {
    private int a;
    private int b;
    private String bgColor;
    private String borderColor;

    public Rectangle(int a, int b, String bgColor, String borderColor) {
        this.a = a;
        this.b = b;
        this.bgColor = bgColor;
        this.borderColor = borderColor;
    }

    @Override

    public double getPerimeter() {
        return (a + b) * 2;
    }

    @Override
    public double getArea() {
        return a * b;
    }

    public String getBgColor() {
        return bgColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

