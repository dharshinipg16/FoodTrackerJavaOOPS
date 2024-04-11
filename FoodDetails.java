package MrCooper.FoodTracker;

import java.util.*;

//FOOD ITEMS
public class FoodDetails {
    String name;
    String category;
    String quantity;
    String calories;
    public FoodDetails (String name , String category, String quantity,String calories) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.calories = calories;
    }

    public static void displayFooddetails (FoodDetails food) {
        System.out.print (food.name.toUpperCase() +" under the category "+food.category.toUpperCase()+" contains "+ food.calories.toUpperCase()+" calories in "+ food.quantity.toUpperCase()+"quantities\n");
    }
    public static FoodDetails createFoodDetails () {
        Scanner sc = new Scanner (System.in);
        System.out.print("\nEnter the details of the food");
        System.out.print("\nEnter the name: ");
        String name = sc.nextLine();
        System.out.print("\nEnter the category: ");
        String category = sc.nextLine();
        System.out.print("\nEnter the quantity: ");
        String quantity = sc.nextLine();
        System.out.print("\nEnter the calories: ");
        String calories = sc.nextLine();
        return new FoodDetails(name, category, quantity, calories);
    }
}
