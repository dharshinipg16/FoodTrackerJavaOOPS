package MrCooper.FoodTracker;

import java.util.ArrayList;
import java.util.Scanner;

//Import all the classes
import MrCooper.FoodTracker.*;

public class MAINAPP {

    public static ArrayList<User> AllUsers = new ArrayList<>();
    public static ArrayList<Admin> AllAdmins = new ArrayList<>();
    public static ArrayList<FoodDetails> Inventory = new ArrayList<>();

    private static int getinto() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.println("1. NewAdmin Register");
        System.out.println("2. Admin login");
        System.out.println("3. NewUser Register");
        System.out.println("4. UserLogin");
        System.out.println("5. Exit");
        choice = sc.nextInt();
        // donot close the scanner
        return choice;
    }

    private static int choiceaskeruser() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.println("1. Calculate BMI");
        System.out.println("2. Goto MealPlans");
        System.out.println("3. Goto Inventory");
        choice = sc.nextInt();
        // donot close the scanner
        return choice;
    }

    private static int choicesakeradmin() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.println("1. Manage Inventory");
        System.out.println("2. Manage Users");
        System.out.println("3. Exit");
        choice = sc.nextInt();
        // donot close the scanner
        return choice;
    }

    private static void worker() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int choice = getinto();
            String person = "";
            // Declare admincred and usercred variables outside the switch statement
            Admin admincred = null;
            User usercred = null;

            // JUST TO GET THE CRED AND WHAT TYPE OF PERSON - USER OR ADMIN
            switch (choice) {
                case 1:
                    Admin newadmin = Admin.createAdmin();
                    AllAdmins.add(newadmin);

                case 2:
                    System.out.println("\n************* ADMIN LOGIN **************");
                    System.out.print("Enter name:");
                    String adname = sc.nextLine();
                    System.out.print("Enter password:");
                    String pwd = sc.nextLine();
                    boolean foundadmin = false;
                    for (Admin admintemp : AllAdmins) {
                        if (admintemp.name.equals(adname)) { // Use .equals() for string comparison
                            foundadmin = true;
                            if (pwd.equals(admintemp.password)) {
                                person = "admin";
                                admincred = admintemp;
                                break; // Add break statement to exit loop once admin is found
                            } else {
                                System.out.println("Wrong password");
                            }
                        }
                    }
                    if (!foundadmin) {
                        System.out.println("No such admin, Register if you are a new Admin !!!");
                    }
                    break;
                case 3:
                    User newuser = User.createUser();
                    AllUsers.add(newuser);

                case 4:
                    System.out.println("\n************* USER LOGIN **************");
                    System.out.print("Enter name:");
                    String usname = sc.nextLine();
                    System.out.print("Enter password:");
                    String uspwd = sc.nextLine();
                    boolean founduser = false;
                    for (User usertemp : AllUsers) {
                        if (usertemp.name.equals(usname)) {
                            founduser = true;
                            if (uspwd.equals(usertemp.password)) {
                                person = "user";
                                usercred = usertemp;
                                break; // Add break statement to exit loop once user is found
                            } else {
                                System.out.println("Wrong password");
                            }
                        }
                    }
                    if (!founduser) {
                        System.out.println("No such user, Register if you are a new User !!!");
                    }
                    break;
                case 5:
                    break;
                default:
                    break;
            }

            if ("admin".equals(person) && admincred != null) {
                while (true) {
                    int choiceadmin = choicesakeradmin();
                    switch (choiceadmin) {
                        case 1: // MANAGE INVENTORY
                            while (true) {
                                System.out.println("****** WELCOME TO MANAGING INVENTORY (admin login) *******");
                                System.out.println("1. Add Food details");
                                System.out.println("2. Delete Food Details");
                                System.out.println("3. Display Food Details");
                                int michoice = sc.nextInt();
                                switch (michoice) {
                                    case 1:
                                        while (true) {
                                            FoodDetails newfoodDetail = FoodDetails.createFoodDetails();
                                            Inventory.add(newfoodDetail);
                                            sc.nextLine();
                                            System.out.print("Do you want to add still more foods  ? (yes/no): "); // addfood
                                            String continueChoice = sc.nextLine();
                                            if (!continueChoice.equalsIgnoreCase("yes")) {
                                                break;
                                            }
                                        }
                                        break;

                                    case 2:
                                        while (true) {
                                            if (Inventory.size()==0){
                                                System.out.print("No Foods In the INVENTORY\n");
                                                break;
                                            }
                                            System.out.print("\nThe foods in the INVENTORY are ------- > \n");
                                            int iter = 1;
                                            for (FoodDetails food : Inventory) {
                                                System.out.print(iter + ". ");
                                                FoodDetails.displayFooddetails(food);
                                                iter += 1;
                                            }
                                            System.out.print("Enter the index of the meal plan to delete ");
                                            int index = sc.nextInt();
                                            Inventory.remove(index - 1);
                                            System.out.print("FOOD DETAIL DELETED SUCCESFULLY\n");
                                            sc.nextLine();
                                            System.out.print("Do you want to delete still more foods  ? (yes/no): "); // addfood
                                            String continueChoice = sc.nextLine();
                                            if (!continueChoice.equalsIgnoreCase("yes")) {
                                                break;
                                            }
                                        }
                                        break;
                                    case 3:
                                        if (Inventory.size()==0){
                                            System.out.print("No Foods In the INVENTORY\n");
                                            break;
                                        }
                                        System.out.print("\nThe foods in the INVENTORY are ------- > \n");
                                        int iter = 1;
                                        for (FoodDetails food : Inventory) {
                                            System.out.print(iter + ". ");
                                            FoodDetails.displayFooddetails(food);
                                            iter += 1;
                                        }

                                    default:
                                        break;
                                }
                                sc.nextLine();
                                System.out.print("Do you want to continue MANAGING INVENTORY ? (yes/no): "); // manage

                                String continueChoice = sc.nextLine();
                                if (!continueChoice.equalsIgnoreCase("yes")) {
                                    break;
                                }
                            }
                            break;
                        case 2: // MANAGE USERS
                            System.out.println("****** WELCOME TO USER MANAGEMENT *******");
                            System.out.println("1. View Users");
                            System.out.println("2. Delete Users");
                            int manageuserchoice = sc.nextInt();
                            switch (manageuserchoice) {
                                case 1:
                                    System.out.println("There are " + AllUsers.size() + " Users");
                                    sc.nextLine();
                                    if (AllUsers.size() == 0) {
                                        break;
                                    }
                                    int index = 1;
                                    for (User user0 : AllUsers) {
                                        System.out.print("User " + index + " ");
                                        System.out.println(user0.name);
                                        index++;
                                    }
                                    break;
                                case 2:
                                    while (true) {
                                        System.out.println("There are " + AllUsers.size() + " Users");
                                        sc.nextLine();
                                        if (AllUsers.size() == 0) {
                                            break;
                                        }
                                        index = 1;
                                        for (User user0 : AllUsers) {
                                            System.out.print("User " + index + " ");
                                            System.out.println(user0.name);
                                            index++;
                                        }
                                        System.out.print("Enter the index of the user to delete ");
                                        index = sc.nextInt();
                                        AllUsers.remove(index - 1);
                                        System.out.print("USER DELETED SUCCESFULLY\n");

                                        sc.nextLine();
                                        System.out.print("Do you want to delete any another user? (yes/no): ");
                                        String continueChoice = sc.nextLine();
                                        if (!continueChoice.equalsIgnoreCase("yes")) {
                                            break;
                                        }
                                    }
                                    break;

                                default:
                                    break;
                            }
                        case 3: // EXIT
                            break;
                        default:
                            break;
                    }
                    System.out.print("Do you want to continue inside your admin login ? (yes/no): "); // inside ADMIN
                    String continueChoice = sc.nextLine();
                    if (!continueChoice.equalsIgnoreCase("yes")) {
                        break;
                    }
                }
            }
            // USER CHOICE ASKING AND TASKS
            else if ("user".equals(person) && usercred != null) {
                while (true) {
                    int choiceuser = choiceaskeruser();

                    switch (choiceuser) {

                        case 1: // CALCULATE BMI
                            double bmi = usercred.weight * 10000 / (usercred.height * usercred.height);
                            System.out.println(usercred.name.toUpperCase() + " , your BMI is = " + bmi);
                            break;

                        case 2: // GOTO MEALPLANS
                            while (true) {
                                System.out.println("****** WELCOME TO YOUR MEALPLANS *******");
                                System.out.println("1. Add MealPlan");
                                System.out.println("2. Delete MealPlan");
                                System.out.println("3. Display MealPlan");
                                int mealplanchoice = sc.nextInt();
                                switch (mealplanchoice) {
                                    case 1:
                                        while (true) {
                                            MealPlan mealplan1 = MealPlan.creatMealPlan();
                                            usercred.mymealplans.add(mealplan1);
                                            System.out.print("MEAL PLAN SUCCESSFULLY ADDED\n");

                                            System.out.print("Do you want to add another mealplan? (yes/no): ");
                                            sc.nextLine();
                                            String continueChoice = sc.nextLine();
                                            if (!continueChoice.equalsIgnoreCase("yes")) {
                                                break;
                                            }
                                        }
                                        break;

                                    case 2:
                                        while (true) {
                                            System.out
                                                    .println("You have " + usercred.mymealplans.size() + " MealPlans");
                                            if (usercred.mymealplans.size() == 0) {
                                                break;
                                            }
                                            int index = 1;
                                            for (MealPlan plan : usercred.mymealplans) {
                                                System.out.println("MEAL PLAN " + index);
                                                index++;
                                                MealPlan.displayMealPlan(plan);
                                            }
                                            System.out.print("Enter the index of the meal plan to delete ");
                                            index = sc.nextInt();
                                            usercred.mymealplans.remove(index - 1);
                                            System.out.print("MEAL PLAN DELETED SUCCESFULLY\n");

                                            sc.nextLine();
                                            System.out.print("Do you want to delete another mealplan? (yes/no): ");
                                            String continueChoice = sc.nextLine();
                                            if (!continueChoice.equalsIgnoreCase("yes")) {
                                                break;
                                            }
                                        }
                                        break;
                                    case 3:
                                        System.out.println("You have " + usercred.mymealplans.size() + " MealPlans");
                                        int i = 1;
                                        for (MealPlan plan : usercred.mymealplans) {
                                            System.out.println("\nMEAL PLAN " + i);
                                            i++;
                                            MealPlan.displayMealPlan(plan);
                                        }
                                        break;
                                    default:
                                        break;
                                }
                                sc.nextLine();
                                System.out.print("Do you want to continue inside meal plans? (yes/no): ");
                                String continueChoice = sc.nextLine();
                                if (!continueChoice.equalsIgnoreCase("yes")) {
                                    break;
                                }
                            }

                        case 3: // GOTO INVENTORY
                            System.out.print("The foods in the INVENTORY are ------- > \n");
                            int iter = 1;
                            for (FoodDetails food : Inventory) {
                                System.out.print(iter + ". ");
                                FoodDetails.displayFooddetails(food);
                            }
                            break;

                        default:
                            break;
                    }

                    System.out.println("Do you want to continue inside your User login ? (yes/no): "); // inside USER
                    String continueChoice = sc.nextLine();
                    if (!continueChoice.equalsIgnoreCase("yes")) {
                        break;
                    }
                }
            }
            // TO CHANGE THE PERSON OF LOGIN
            System.out.println("Do you want to change the LOGIN type ? (yes/no): "); // inside the entire site, after logout
            String continueChoice = sc.nextLine();
            if (!continueChoice.equalsIgnoreCase("yes")) {
                break;
            }

        }

    }

    public static void main(String[] args) {
        worker();
    }
}
