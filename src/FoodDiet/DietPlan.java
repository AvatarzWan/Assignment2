package FoodDiet;

/**
 *
 * @author hazwa
 */
public class DietPlan {

    private FoodItem[] foodItem;
    private int count;
    static final int Defaultsize = 20;

    public DietPlan(int size) {
        if (size <= 0) {
            foodItem = new FoodItem[Defaultsize];
        } else {
            foodItem = new FoodItem[size];
        }
        count = 0;

    }
}
