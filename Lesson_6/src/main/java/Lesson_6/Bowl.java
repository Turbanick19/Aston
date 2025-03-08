package Lesson_6;

public class Bowl {
    final static int maxFood = 50;
    public int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public void addFood(int addedFoodAmount) {
        System.out.print("В миске было еды: " + foodAmount);
        foodAmount += addedFoodAmount;
        if (foodAmount > maxFood) {
            foodAmount = maxFood;
        }
        System.out.println(". Стало: " + foodAmount);
    }

    public void decFood(int reducedFoodAmount) {
        System.out.print("В миске было еды: " + foodAmount);
        foodAmount -= reducedFoodAmount;
        if (foodAmount < 0) {
            foodAmount = 0;
        }
        System.out.println(" Стало: " + foodAmount);
    }
}
