package database.userDatabase;

import java.util.ArrayList;
import model.user.User;

public interface IUserDatabase {
    public ArrayList<User> getAllUser();

    public void addNewUser(User u);
    
    public User searchUser(String email, String password);

    public void updateUser(User u);
}
