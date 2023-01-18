package main;

import java.util.Scanner;

import model.Store;
import model.user.User;

public class UserMenu {
    Scanner sc = new Scanner(System.in);
    protected User user;
    Store store = new Store();

    public UserMenu(User userLogin) {
        this.user = userLogin;
    }

    protected void showUserMenuList() {
        System.out.println("Welcome to User Menu !");
        System.out.println("1. Buy New Phone");
        System.out.println("2. Top Up Balance");
        System.out.println("3. See Announcement");
        System.out.println("4. Check Up Phone");
        System.out.println("5. Exit");
        System.out.print("Choice>> ");
    }

    protected void buyNewPhone() {
        store.showAllPhone();

        int input;
        System.out.print("Choose Phone to Buy [Type -1 to cancel]>> ");
        input = sc.nextInt();
        sc.nextLine();

        store.buyPhone(input, user);
    }

    protected void topUpBalance() {
        System.out.println("Current Balance: " + user.getBalance());

        int amount;
        System.out.print("Input Amount [min 1000]  [Type -1 to cancel]: ");
        amount = sc.nextInt();

        store.balanceTopUp(user, amount);
    }

    protected void checkUpPhone() {
        this.user.checkPhone();

        System.out.println("Thank you For Using Our Service!");
        System.out.println("Press Enter to Continue..");
        sc.nextLine();
    }

    protected void seeAnnouncement() {
        user.showNews();

        System.out.println("Press Enter to Continue..");
        sc.nextLine();
    }
}
