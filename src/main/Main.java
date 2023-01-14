package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to SemartPhoneSetor");
        int choice = -1;

        LandingMenu landingMenu = new LandingMenu();

        while (choice != 3) {
            landingMenu.showLandingMenuList();
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                landingMenu.loginMenu();
            } else if (choice == 2) {
                landingMenu.registerMenu();
            } else if (choice == 3) {
                System.out.println("Terminating the program...");
                System.exit(0);
            } else {
                System.out.println("Invalid Choice, Please Try Again");
            }
        }
        sc.close();
    }
}
