package MrCooper.FoodTracker;

import java.util.Scanner;

class Foodset {
    String food1;
    String food2;
    String food3;
    public Foodset (String food1,String food2,String food3) {
        this.food1 = food1;
        this.food2 = food2;
        this.food3 = food3;
    }
}

public class MealPlan {
    Foodset breakfast;
    Foodset lunch;
    Foodset snacks;
    Foodset dinner;

    public MealPlan (Foodset breakfast, Foodset lunch , Foodset snacks, Foodset dinner) {
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.snacks = snacks;
        this.dinner = dinner;
    }

    public static MealPlan creatMealPlan() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER 3 ITEMS FOR BREAKFAST");
        Foodset breakfast = new Foodset(sc.nextLine(),sc.nextLine(),sc.nextLine());

        System.out.println("ENTER 3 ITEMS FOR LUNCH");
        Foodset lunch = new Foodset(sc.nextLine(),sc.nextLine(),sc.nextLine());

        System.out.println("ENTER 3 ITEMS FOR SNACKS");
        Foodset snacks = new Foodset(sc.nextLine(),sc.nextLine(),sc.nextLine());

        System.out.println("ENTER 3 ITEMS FOR DINNER");
        Foodset dinner = new Foodset(sc.nextLine(),sc.nextLine(),sc.nextLine());
            
        return new MealPlan(breakfast, lunch, snacks, dinner);
        
    }

    public static void displayMealPlan(MealPlan plan){
        System.out.println("BREAKFAST FOODS ------>");
        System.out.print (plan.breakfast.food1+", "+plan.breakfast.food2+" and "+plan.breakfast.food3+"\n");
        System.out.println("LUNCH FOODS ------>");
        System.out.print (plan.lunch.food1+", "+plan.lunch.food2+" and "+plan.lunch.food3+"\n");
        System.out.println("SNACKS ALLOWED ------> ");
        System.out.print (plan.snacks.food1+", "+plan.snacks.food2+" and "+plan.snacks.food3+"\n");
        System.out.println("DINNER FOODS ------> ");
        System.out.print (plan.dinner.food1+", "+plan.dinner.food2+" and "+plan.dinner.food3+"\n");
    }
    

}
