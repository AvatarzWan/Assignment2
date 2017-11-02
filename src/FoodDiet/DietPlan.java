package FoodDiet;

/**
 *
 * @author hazwanizzani
 */
public class DietPlan {

    private FoodItem[] foodItem;
    private int count;
    static final int DefaultSize = 20;

    public DietPlan(int size) {
        if (size <= 0) {
            foodItem = new FoodItem[DefaultSize];
        } else {
            foodItem = new FoodItem[size];
        }
        count = 0;

    }

    public boolean add(FoodItem InFoodItem) {
        if (count == foodItem.length) {
            return false;
        }
        foodItem[count] = InFoodItem;
        count++;
        return true;

    }

    public String getAllFood() {
        String list = " This diet contains : \n";
        for (int i = 0; i < count; i++) {
            list += foodItem[i].toString() + " \n";
        }
        return list;
    }

    public FoodItem searchFood(String foodName) {
        for (int i = 0; i < count; i++) {
            if (foodItem[i].getName().equalsIgnoreCase(foodName)) {
                return foodItem[i];
            }
        }
        return null;
    }
}

