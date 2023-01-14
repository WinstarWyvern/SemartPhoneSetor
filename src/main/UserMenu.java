package main;

import java.util.Scanner;

import model.user.User;

public class UserMenu {
    Scanner sc = new Scanner(System.in);
    protected User user;

    public UserMenu(User userLogin) {
        this.user = userLogin;
    }

    protected void showUserMenuList() {
        System.out.println("Welcome to User Menu !");
        System.out.println("1. Buy New Phone");
        System.out.println("2. Set Payment Method");
        System.out.println("3. See Announcement");
        System.out.println("4. Exit");
        System.out.print("Choice>>");
    }

    protected void buyNewPhone() {

    }

    protected void setPaymentMethod() {

    }

    protected void seeAnnouncement() {
        user.showNews();

        System.out.println("Press Enter to Continue");
        sc.nextLine();
    }
}
