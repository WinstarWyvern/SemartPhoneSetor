package model;

import java.util.ArrayList;
import java.util.Scanner;

import database.phoneDatabase.ProxyPhoneDatabase;
import database.userDatabase.ProxyUserDatabase;
import model.user.User;

public class Store {
    Scanner sc = new Scanner(System.in);
    private ArrayList<User> customers = new ArrayList<>();
    private ArrayList<Phone> phones = new ArrayList<>();
    ProxyUserDatabase userDb = new ProxyUserDatabase();
    ProxyPhoneDatabase phoneDb = new ProxyPhoneDatabase();

    public Store() {
        if (customers.size() < 0 && phones.size() < 0) {
            customers = userDb.getAllUser();
            phones = phoneDb.getAllPhone();
        }
    }

    public void notifyCustomer(News news, String type) {
        for (User user : customers) {
            user.receiveNews(news, type);
        }
    }

    public void showAllPhone() {
        int i = 0;
        System.out.println("Phone List: ");
        for (Phone phone : phones) {
            System.out.println((i + 1) + ".");
            System.out.println("Name: " + phone.getName());
            System.out.println("Brand: " + phone.getBrand());
            System.out.println("Price: " + phone.getPrice());
            System.out.println("Quantity: " + phone.getQuantity());
            System.out.println();
            System.out.println();
            i++;
        }
    }

    public void phoneBought(int index) {
        int quantity;
        System.out.println("Choose Quantity: ");
        quantity = sc.nextInt();
        sc.nextLine();

        if (quantity < 0 || quantity > phones.get(index - 1).getQuantity()) {
            System.out.println("You input invalid quantity, please try again !");
            System.out.println("Press Enter to Continue..");
            sc.nextLine();
            return;
        } else {
            Phone updatedPhone = phones.get(index - 1);
            updatedPhone.setQuantity(updatedPhone.getQuantity() - quantity);
            phoneDb.updatePhone(updatedPhone);
            System.out.println("Thank you for buying our product, please come back again!");
            System.out.println("Press Enter to Continue..");
            sc.nextLine();
        }
    }
}
