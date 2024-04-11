package MrCooper.FoodTracker;

import java.util.Scanner;

public class Admin {
    String name;
    String password;

    public Admin (String name,String password ) {
        this.name = name;
        this.password=password;
    }
    public static Admin createAdmin() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name: ");
        String name = sc.nextLine();

        System.out.println("Enter password: ");
        String password = sc.nextLine();

        return new Admin(name, password);
    }
}
