package FoodDiet;

/**
 *
 * @author hazwanizzani
 */
public class FoodItem {

    private String name;
    private String mealType;
    private double caloriePerServing;
    private int numOfServing;

    public FoodItem() {
        name = " ";
        mealType = " ";
        caloriePerServing = 0.0;
        numOfServing = 0;

    }

    public FoodItem(String InName, String InMealType, double InCaloriePerServing, int InNumOfServing) {

        if (!InName.isEmpty()) {
            name = InName;
        }

        if (!InMealType.isEmpty()) {
            if (InMealType.equalsIgnoreCase("breakfast") || InMealType.equalsIgnoreCase("lunch") || InMealType.equalsIgnoreCase("dinner")) {
                mealType = InMealType;
            }
        }
        if (InCaloriePerServing > 0) {
            caloriePerServing = InCaloriePerServing;
        }

        if (InNumOfServing > 0) {
            numOfServing = InNumOfServing;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String InName) {
        name = InName;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String InMealType) {
        mealType = InMealType;
    }

    public double getCaloriePerServing() {
        return caloriePerServing;
    }

    public void setCaloriePerServing(double InCaloriePerServing) {
        caloriePerServing = InCaloriePerServing;
    }

    public int getNumOfServing() {
        return numOfServing;
    }

    public void setNumOfServing(int InNumOfServing) {
        numOfServing = InNumOfServing;
    }

    public double calorieConsumed() {
        return numOfServing * caloriePerServing;

    }

    public String toString() {
        return getName() + " is a " + getMealType() + " meal, has  " + getCaloriePerServing() + " calories per serving and " + getNumOfServing() + " servings \nTotal calories of " + calorieConsumed();
    }

}
