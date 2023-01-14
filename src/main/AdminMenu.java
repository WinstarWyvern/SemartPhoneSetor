package main;

import model.user.User;

public class AdminMenu {
    protected User user;

    public AdminMenu(User userLogin) {
        this.user = userLogin;
    }
    
    protected void showAdminMenuList() {
        System.out.println("Welcome to Admin Menu !");
        System.out.println("1. Register New Phone");
        System.out.println("2. Register New Admin");
        System.out.println("3. Make Announcement");
        System.out.println("4. Exit");
        System.out.print("Choice>>");
    }

    protected void registerNewPhone() {

    }

    protected void registerNewAdmin() {

    }

    protected void showAllUser() {

    }

    protected void makeAnnouncement() {
        
    }
}
