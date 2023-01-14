package database.phoneDatabase;

import java.util.ArrayList;

import model.Phone;

public interface IPhoneDatabase {
    public ArrayList<Phone> getAllPhone();

    public void addNewPhone(Phone p);

    public void updatePhone(Phone p);
}
