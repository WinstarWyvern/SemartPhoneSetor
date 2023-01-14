package main;

import java.util.Scanner;

import model.News;
import model.Phone;
import model.Store;
import model.user.User;

public class AdminMenu {
    Scanner sc = new Scanner(System.in);
    protected User user;
    Store store = new Store();

    public AdminMenu(User userLogin) {
        this.user = userLogin;
    }

    protected void showAdminMenuList() {
        System.out.println("Welcome to Admin Menu !");
        System.out.println("1. Register New Phone");
        System.out.println("2. Register New Admin");
        System.out.println("3. Make Announcement");
        System.out.println("4. Exit");
        System.out.print("Choice>> ");
    }

    protected void registerNewPhone() {
        String name;
        String brand;
        int quantity;
        int price;

        System.out.print("Input Phone Name: ");
        name = sc.nextLine();

        System.out.print("Input Phone Brand: ");
        brand = sc.nextLine();

        System.out.print("Input Phone Quantity: ");
        quantity = sc.nextInt();
        sc.nextLine();

        System.out.print("Input Phone Price: ");
        price = sc.nextInt();
        sc.nextLine();

        Phone newPhone = new Phone(name, brand, price, quantity);

        store.registerPhone(newPhone);
    }

    protected void registerNewAdmin() {
        store.showAllUser();

        int input;
        System.out.print("Choose Admin Candidate [Type -1 to cancel]>> ");
        input = sc.nextInt();
        sc.nextLine();

        store.promoteUser(input);
    }

    protected void makeAnnouncement() {
        String title;
        String content;
        String target;

        System.out.print("Input Title: ");
        title = sc.nextLine();
        System.out.print("Input Content: ");
        content = sc.nextLine();

        News news = new News(title, content);

        System.out.print("Input Customer Target [All|Regular|VIP]: ");
        target = sc.nextLine();

        store.notifyCustomer(news, target);
    }
}
