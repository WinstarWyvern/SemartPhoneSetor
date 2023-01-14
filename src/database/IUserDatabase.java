package database;

import java.util.ArrayList;
import model.user.User;

public interface IUserDatabase {
    public ArrayList<User> getAllUser();

    public void addNewUser(User u);
    
    public User checkUserLogin(String email, String password);
}
