package database.userDatabase;

import java.util.ArrayList;

import model.user.User;

public class UserDatabase implements IUserDatabase{
    private static UserDatabase userDb = null;

    private UserDatabase() {
    }

    public static UserDatabase getInstance() {
        if (userDb == null) {
            userDb = new UserDatabase();
        }
        return userDb;
    }

    private static ArrayList<User> users = new ArrayList<>();

    @Override
    public ArrayList<User> getAllUser() {
        return users;
    }

    @Override
    public void addNewUser(User u) {
        users.add(u);
    }

    @Override
    public User checkUserLogin(String email, String password) {
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                return users.get(i);
            }
        }
        return null;
    }
}
