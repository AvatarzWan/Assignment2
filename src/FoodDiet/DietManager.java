package FoodDiet;

/**
 * This is the diet manager containing the initializer and user input to the
 * diet contains main method with methods to modifying and add the arrays
 *
 * @author hazwanizzani
 */
import java.util.*;

public class DietManager {

    public static DietPlan diet;
    public static Scanner sc;

    public static void main(String[] args) {
        FoodItem food = null;
        diet = new DietPlan(0); // initializer
        sc = new Scanner(System.in);

        char menuEntry;
        do {
            menuEntry = getMenu(); // gets the menu and input for the menu selection
            switch (menuEntry) { // using switch allows multiple cases easily
                case '1':
                    addFood();
                    break;
                case '2':
                    displayDiet();
                    break;
                case '3':
                    searchFood();
                    break;
                case '4':
                    alterFood();
                    break;
                case '5':
                    recordMeal();
                    break;
                case '6':
                    removeFood();
                    break;
                case '7':
                    System.out.println("Thanks for using this program!");
                    break;
                default:
                    System.out.println("Invalid entry.");
                    break;

            }
        } while (menuEntry != '7'); // as long as its not quit

    }

    public static char getMenu() { // menu containing the options and request user input
        System.out.println("Enter a number (1-7) for options");
        System.out.println("1. Add new food item to diet plan. ");
        System.out.println("2. Show diet plan information. ");
        System.out.println("3. Search food item by keyword. ");
        System.out.println("4. Change food item attributes. ");
        System.out.println("5. Record servings for meal type. ");
        System.out.println("6. Remove food item. ");
        System.out.println("7. Quit. ");
        char menu = sc.nextLine().charAt(0);
        return menu;
    }

    public static void addFood() { // adding food based on name, meal type, calories and servings
        System.out.println("Enter food name: ");
        String name = sc.nextLine();
        System.out.println("Enter meal type (Breakfast,Lunch,Dinner): ");
        String meal = sc.nextLine();
        System.out.println("Enter the amount of calories per servings: ");
        double cal = sc.nextDouble();
        System.out.println("Enter the servings for the food : ");
        int serv = sc.nextInt();
        sc.nextLine();
        FoodItem food = new FoodItem(name, meal, cal, serv);
        if (diet.add(food)) {
            System.out.println("Successful Entry."); // if array is not full it will add
        } else {
            System.out.println("Full entry. Cannot add more."); // if array is full it will not add.
        }

    }

    public static void displayDiet() {
        System.out.println(diet.getAllFood()); // display all the food
    }

    public static void searchFood() {
        System.out.println("Enter the name of food to search: ");
        String search = sc.nextLine();
        System.out.println(diet.keyFoodItem(search));
    }

    public static void alterFood() {
        System.out.println("Enter the name of food to change: "); // request food name
        String namefood = sc.nextLine();
        FoodItem food = diet.searchFood(namefood); // search array for food
        char change;
        if (food != null) {
            do { // loop to edit which attributes
                System.out.println("Which attribute do you want to change? ");
                System.out.println("1. Name");
                System.out.println("2. Meal Type.");
                System.out.println("3. Calories per Serving.");
                System.out.println("4. Amount of Servings.");
                System.out.println("5. Exit."); // quit the loop
                change = sc.nextLine().charAt(0);
                switch (change) {
                    case '1':
                        System.out.println("Enter name to change: ");
                        String name = sc.nextLine();
                        diet.searchFood(namefood).setName(name); // setter
                        break;
                    case '2':
                        System.out.println("Enter the meal type to change: (Breakfast,Lunch,Dinner) ");
                        String type = sc.nextLine();
                        diet.searchFood(namefood).setMealType(type);
                        break;
                    case '3':
                        System.out.println("Enter the amount of calories to change: ");
                        double calo = sc.nextDouble();
                        sc.nextLine();
                        diet.searchFood(namefood).setCaloriePerServing(calo);
                        break;
                    case '4':
                        System.out.println("Enter the amount of servings to change: ");
                        int serv = sc.nextInt();
                        sc.nextLine();
                        diet.searchFood(namefood).setNumOfServing(serv);
                        break;
                    case '5':
                        System.out.println("Exiting editor.");
                        break;
                    default:
                        System.out.println("Invalid entry");
                        break;
                }
            } while (change != '5');

        }
    }

    public static void recordMeal() {
        System.out.println("Enter the meal type to update: ");
        String meal = sc.nextLine();
        FoodItem[] food = new FoodItem[0];
        food = diet.searchMeal(meal); // puts array of same meal types
        System.out.println("Enter the value to update servings: ");
        int serv = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < food.length; i++) { // search the array of the selected meal type
            food[i].setNumOfServing(serv); // set the number of servings
            System.out.println(food[i].toString()); // prints the food item arrays to show the changed value of servings
        }

    }

    public static void removeFood() {
        System.out.println("Enter the name of the food to remove: ");
        String name = sc.nextLine();
        System.out.println("Do you really want to remove " + name + " ? (y)es or (n)o "); // verify for removal
        char yesno = sc.nextLine().charAt(0);
        if (yesno == 'y') {
            diet.remove(name); // remove method from diet plan
            System.out.println(name + " is removed from diet plan.");
        }
    }
}
