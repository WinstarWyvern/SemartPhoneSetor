package database;

import java.util.ArrayList;
import java.util.Scanner;

import model.user.User;

public class ProxyUserDatabase implements IUserDatabase {
    private UserDatabase db;
    Scanner sc = new Scanner(System.in);

    private final String captcha = "iamnotabot";

    public ProxyUserDatabase() {
        this.db = UserDatabase.getInstance();
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
    public User checkUserLogin(String email, String password) {
        boolean checked = userCaptchaValidation();
        User searched = db.checkUserLogin(email, password);

        if (searched != null && checked) {
            return searched;
        }
        return null;
    }

    private boolean userCaptchaValidation() {
        System.out.print("Input [iamnotarobot] to prove you are not a bot: ");
        String validation = sc.nextLine();

        if (validation.equals(captcha)) {
            return true;
        }
        return false;
    }
}
