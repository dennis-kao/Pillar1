package james.mosley.com.pillar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.*;

public class Community {

    //Community is made up of all users.
    private ArrayList<User> myCommunity = new ArrayList<>();

    public Community() {

    }

    public boolean addUser(User newUser) {

        return true;
    }

    public boolean removeUser(User userToRemove) {

        return true;
    }

    public User searchUser (String name, User.UserType type, int id, String email, String phoneNum) {

        return new User();
    }

}