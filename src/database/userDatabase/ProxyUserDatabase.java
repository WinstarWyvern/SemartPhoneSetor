package database.userDatabase;

import java.util.ArrayList;
import java.util.Scanner;

import model.user.User;

public class ProxyUserDatabase implements IUserDatabase {
    Scanner sc = new Scanner(System.in);
    private UserDatabase db;
    private final String captcha = "iamnotabot";

    public ProxyUserDatabase() {
        if (db == null) {
            this.db = UserDatabase.getInstance();
        }
    }

    @Override
    public ArrayList<User> getAllUser() {
        ArrayList<User> users = db.getAllUser();
        return users;
    }

    @Override
    public void addNewUser(User u) {
        boolean checked = userCaptchaValidation();

        if (checked) {
            db.addNewUser(u);
        }
    }

    @Override
    public User searchUser(String email, String password) {
        boolean checked = userCaptchaValidation();
        User searched = db.searchUser(email, password);

        if (searched != null && checked) {
            return searched;
        }
        return null;
    }

    private boolean userCaptchaValidation() {
        System.out.print("Input [iamnotarobot] to prove you are not a bot: ");
        String validation = sc.nextLine();
        System.out.println();

        if (validation.equals(captcha)) {
            return true;
        }
        return false;
    }

    @Override
    public void updateUser(User u) {
        boolean checked = userCaptchaValidation();

        if (checked) {
            db.updateUser(u);
        }
    }
}
