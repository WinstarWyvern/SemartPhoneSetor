package database.phoneDatabase;

import java.util.ArrayList;
import java.util.Scanner;

import model.Phone;

public class ProxyPhoneDatabase implements IPhoneDatabase {
    Scanner sc = new Scanner(System.in);
    private PhoneDatabase db;
    private final String password = "iamadmin";

    public ProxyPhoneDatabase() {
        if (db == null) {
            this.db = PhoneDatabase.getInstance();
        }
    }

    @Override
    public ArrayList<Phone> getAllPhone() {
        ArrayList<Phone> phones = db.getAllPhone();
        return phones;
    }

    @Override
    public void addNewPhone(Phone p) {
        boolean checked = adminValidation();

        if (checked) {
            db.addNewPhone(p);
        }
    }

    @Override
    public void updatePhone(Phone p) {
        boolean checked = adminValidation();

        if (checked) {
            db.updatePhone(p);
        }
    }

    private boolean adminValidation() {
        System.out.print("Input admin special password: ");
        String validation = sc.nextLine();
        System.out.println();

        if (validation.equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public Phone searchPhone(String brand, String name) {
        boolean checked = adminValidation();
        Phone searched = db.searchPhone(brand, name);

        if (checked) {
            return searched;
        }
        return null;
    }

}
