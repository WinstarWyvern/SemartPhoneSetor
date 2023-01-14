package factory;

import model.user.Regular;
import model.user.User;
import model.user.VIP;

public class UserFactory {
    public User createUser(String name, String email, String password, String role) {
        if (role.equalsIgnoreCase("regular")) {
            return new Regular(name, email, password, role);
        } else if (role.equalsIgnoreCase("vip")) {
            return new VIP(name, email, password, role);
        } else
            return null;
    }
}
