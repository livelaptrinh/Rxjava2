package team.kiti.rxjava2_android.operators.map;

import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thien on 1/22/2018.
 */

public class UserApi {
    private int id;
    private String firstName;
    private String lastName;
    private String midlleName;

    public static List<UserApi> getListUserApi() {
        ArrayList<UserApi> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new UserApi(i, "First", "Last", "Name "+ i));
        }
        return list;
    }

    public UserApi() {
    }

    public UserApi(int id, String firstName, String lastName, String midlleName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.midlleName = midlleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMidlleName() {
        return midlleName;
    }

    public void setMidlleName(String midlleName) {
        this.midlleName = midlleName;
    }
}
