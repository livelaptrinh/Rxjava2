package team.kiti.rxjava2_android.operators.map;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thien on 1/22/2018.
 */

public class User {
    private int id;
    private String fullName;

    public static List<User> convertUserApisToUsers(List<UserApi> list) {
        ArrayList<User> users = new ArrayList<>();
        for (UserApi item : list) {
            users.add(new User(item.getId(), item.getLastName()+" "+item.getMidlleName()+" "+item.getFirstName()));
        }
        return users;
    }

    public User() {
    }

    public User(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
