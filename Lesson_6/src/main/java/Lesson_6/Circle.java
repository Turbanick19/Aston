package Lesson_6;

public class Circle implements Figure {
    private int r;
    private String bgColor;
    private String borderColor;

    public Circle(int r, String bgColor, String borderColor) {
        this.r = r;
        this.bgColor = bgColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * r;
    }

    @Override
    public double getArea() {
        return Math.PI * r * r;
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
