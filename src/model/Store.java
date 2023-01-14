package model;

import java.util.ArrayList;

import database.userDatabase.ProxyUserDatabase;
import model.user.User;

public class Store {
    private ArrayList<User> customers;
    ProxyUserDatabase userDb = new ProxyUserDatabase();

    public Store() {
        customers = userDb.getAllUser();
    }

    public void notifyCustomer(News news, String type) {
        for (User user : customers) {
            user.receiveNews(news, type);
        }
    }
}
