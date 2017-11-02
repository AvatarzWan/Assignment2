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
    
    public double totalCalorie(){
        double total=0.0;
        for (int i = 0; i < count; i++){
            total +=foodItem[i].calorieConsumed();
        }
        return total;
            
    }
    
    public FoodItem highestCalorie(){
        FoodItem highest = foodItem[0];
        for (int i = 1; i < count; i++){
            if (foodItem[i].calorieConsumed()>highest.calorieConsumed())
                highest= foodItem[i];
        }
        return highest;
    }
    
    public String keyFoodItem (String keyword){
        String keyfood = "Matching food : \n";
        for (int i = 0; i < count; i++){
            if (foodItem[i].getName().toLowerCase().contains(keyword.toLowerCase()))
                keyfood+=foodItem[i].toString() + " \n";
        }
        return keyfood;
    }
    
    public  FoodItem [] searchMeal (String InMealType){
        FoodItem [] mealArray = new FoodItem [count];
        for (int i = 0 ; i < count; i++){
            if (foodItem[i].getMealType().equalsIgnoreCase(InMealType))
               mealArray[i]=foodItem[i];
        }
        return mealArray;
    }
    
}

