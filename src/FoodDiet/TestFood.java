package FoodDiet;

/**
 *
 * @author hazwanizzani
 */
public class TestFood {

    public static void main(String[] args) {
        FoodItem food1 = new FoodItem("Rice", "breakfast", 200.5, 3);
        System.out.println(food1.toString());
        
        DietPlan diet1 = new DietPlan(0);       

    }
}
