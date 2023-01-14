package database.phoneDatabase;

import java.util.ArrayList;

import model.Phone;

public class PhoneDatabase implements IPhoneDatabase {
    private static PhoneDatabase phoneDb = null;

    private PhoneDatabase() {
    }

    public static PhoneDatabase getInstance() {
        if (phoneDb == null) {
            phoneDb = new PhoneDatabase();
        }
        return phoneDb;
    }

    private static ArrayList<Phone> phones = new ArrayList<>();

    @Override
    public ArrayList<Phone> getAllPhone() {
        return phones;
    }

    @Override
    public void addNewPhone(Phone p) {
        phones.add(p);
    }

    @Override
    public void updatePhone(Phone p) {
        for (Phone phone : phones) {
            if (phone.getId().equals(p.getId())) {
                phone = p;
            }
        }
    }

}
