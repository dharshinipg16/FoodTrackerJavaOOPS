package MrCooper.FoodTracker;

import java.util.ArrayList;
import java.util.Scanner;

/*
User:

Attributes:
username: String
password: String
age: int
weight: double
height: double
gender: enum (Male/Female/Other)

mymealplans ={{plan1food1,food2,food3...} , {plan2food1,food2,....}}


Methods:
Constructor to initialize user attributes
Getter and setter methods for user attributes
Method to calculate BMI (Body Mass Index)
Method to calculate daily caloric needs
 */

import MrCooper.FoodTracker.MealPlan;

public class User {
    String name;
    String password;
    int age;
    int weight;
    int height;
    String gender;
    ArrayList<MealPlan> mymealplans;
    ArrayList<String> mycart;

    public User (String name, String password, int age, int weight, int height, String gender,ArrayList<MealPlan> mymealplans,ArrayList<String> mycart) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.weight = weight;
        this.height=height;
        this.gender=gender;
        this.mymealplans = mymealplans; 
        this.mycart = mycart;
    }

    public static User createUser() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name: ");
        String name = sc.nextLine();

        System.out.println("Enter password: ");
        String password = sc.nextLine();

        System.out.println("Enter age: ");
        int age = sc.nextInt();

        System.out.println("Enter weight: ");
        int weight = sc.nextInt();

        System.out.println("Enter height: ");
        int height = sc.nextInt();

        System.out.println("Enter gender: ");
        String gender = sc.next();

        // initialize these arrays as empty initially
        ArrayList<MealPlan> mymealplans = new ArrayList<>();
        ArrayList<String> mycart = new ArrayList<>();

        return new User(name, password, age, weight, height, gender, mymealplans, mycart);
    } 
    //User newuser = User.createUser();

}
