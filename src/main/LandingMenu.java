package main;

import java.util.Scanner;

import database.userDatabase.ProxyUserDatabase;
import factory.UserFactory;
import model.user.User;

public class LandingMenu {
	Scanner sc = new Scanner(System.in);
	UserFactory uf = new UserFactory();
	ProxyUserDatabase userDb = new ProxyUserDatabase();

	public void showLandingMenuList() {
		System.out.println("Welcome to Landing Menu !");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Exit");
		System.out.print("Choice>>");
	}

	public void loginMenu() {
		String email = "";
		String password = "";

		System.out.print("Input Email: ");
		email = sc.nextLine();
		System.out.print("Input Password: ");
		password = sc.nextLine();

		User userLogin = userDb.checkUserLogin(email, password);

		int input = -1;

		if (userLogin == null) {
			return;
		} else if (userLogin.getRole().equalsIgnoreCase("admin")) {
			AdminMenu am = new AdminMenu(userLogin);

			while (input != 4) {
				am.showAdminMenuList();
				input = sc.nextInt();
				sc.nextLine();
				if (input == 1) {
					am.registerNewPhone();
				} else if (input == 2) {
					am.registerNewAdmin();
				} else if (input == 3) {
					am.makeAnnouncement();
				} else if (input == 4) {
					System.out.println("Return to Landing Menu");
					return;
				} else {
					System.out.println("Invalid Choice, Please Try Again");
				}
			}
		} else {
			UserMenu um = new UserMenu(userLogin);

			while (input != 4) {
				um.showUserMenuList();
				input = sc.nextInt();
				sc.nextLine();
				if (input == 1) {
					um.buyNewPhone();
				} else if (input == 2) {
					um.setPaymentMethod();
				} else if (input == 3) {
					um.seeAnnouncement();
				} else if (input == 4) {
					System.out.println("Return to Landing Menu");
					return;
				} else {
					System.out.println("Invalid Choice, Please Try Again");
				}
			}
		}
	}

	public void registerMenu() {
		String email = "", password = "", name = "", role = "";

		System.out.print("Input Email: ");
		email = sc.nextLine();

		System.out.print("Input Name: ");
		name = sc.nextLine();

		System.out.print("Input Password: ");
		password = sc.nextLine();

		System.out.print("Input User Role [Regular|VIP]: ");
		role = sc.nextLine();

		User newUser = uf.createUser(name, email, password, role);

		if (newUser != null) {
			userDb.addNewUser(newUser);
		}

		System.out.println("User Successfully Added to Database");
		System.out.println("Proceed to User Menu");
		System.out.println("Press Enter to Continue");
		sc.nextLine();
	}

}
