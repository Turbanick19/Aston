package Lesson_12_junit_5;

import java.lang.Math;

public class TriangleArea {

    public static double triangleArea(double sideA, double sideB, double sideC) {
        // Вычисляем полупериметр
        double semiPerimeter = (sideA + sideB + sideC) / 2;

        // Применяем формулу Герона
        return Math.sqrt(semiPerimeter * (semiPerimeter - sideA) *
                (semiPerimeter - sideB) * (semiPerimeter - sideC));
    }
}
