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

    public void registerPhone(Phone p) {
        Phone existingPhone = phoneDb.searchPhone(p.getBrand(), p.getName());

        if (existingPhone != null) {
            System.out.println("Phone already Exist, Phone Registration Failed !");
            System.out.println("Press Enter to Continue..");
            sc.nextLine();
            return;
        } else {
            phoneDb.addNewPhone(p);
        }
    }

    public void showAllUser() {
        int i = 0;
        System.out.println("User List: ");
        for (User user : customers) {
            System.out.println((i + 1) + ".");
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Role: " + user.getRole());
            System.out.println();
            System.out.println();
            i++;
        }
    }

    public void balanceTopUp(User user, int amount) {

        if (amount < 1000) {
            System.out.println("You input invalid price, Returning to previus menu !");
            System.out.println("Press Enter to Continue..");
            sc.nextLine();
            return;
        }

        user.setBalance(user.getBalance() + amount);
        userDb.updateUser(user);
    }

    public void buyPhone(int index, User user) {
        if (!indexChecking(index)) {
            return;
        }

        int quantity;
        System.out.println("Choose Quantity: ");
        quantity = sc.nextInt();
        sc.nextLine();

        if (quantity < 0 || quantity > phones.get(index - 1).getQuantity()) {
            System.out.println("You input invalid quantity, Returning to previus menu !");
            System.out.println("Press Enter to Continue..");
            sc.nextLine();
            return;
        } else {
            Phone updatedPhone = phones.get(index - 1);
            updatedPhone.setQuantity(updatedPhone.getQuantity() - quantity);
            phoneDb.updatePhone(updatedPhone);

            User searched = userDb.searchUser(user.getEmail(), user.getPassword());

            if (searched.getBalance() < updatedPhone.getPrice()) {
                System.out.println("You don't have enough balance, Returning to previus menu !");
                System.out.println("Press Enter to Continue..");
                sc.nextLine();
                return;
            }
            searched.setBalance(searched.getBalance() - updatedPhone.getPrice());
            userDb.updateUser(searched);

            System.out.println("Thank you for buying our product, please come back again !");
            System.out.println("Press Enter to Continue..");
            sc.nextLine();
        }
    }

    public void promoteUser(int index) {
        if (!indexChecking(index)) {
            return;
        }

        User candidate = customers.get(index - 1);
        userDb.updateUser(candidate);
    }

    private boolean indexChecking(int index) {
        if (index <= 0 || index > phones.size()) {
            System.out.println("Invalid Input, Returning to previus menu !");
            System.out.println("Press Enter to Continue..");
            sc.nextLine();
            return false;
        }
        return true;
    }
}
