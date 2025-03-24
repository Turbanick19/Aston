package org.Lessone_12_testiNG;

import java.lang.Math;

public class TriangleArea {

    public static double calculateArea(double sideA, double sideB, double sideC) {
        // Вычисляем полупериметр
        double semiPerimeter = (sideA + sideB + sideC) / 2;

        // Применяем формулу Герона
        return Math.sqrt(semiPerimeter * (semiPerimeter - sideA) *
                (semiPerimeter - sideB) * (semiPerimeter - sideC));
    }
}
