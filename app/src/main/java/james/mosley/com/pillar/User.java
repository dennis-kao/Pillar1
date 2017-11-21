package james.mosley.com.pillar;

import java.util.ArrayList;
import java.util.Date;



public class User {

    //Types of users
    public enum UserType {PARTICIPANT, STAFF, ADMIN}

    //User info.
    private String firstName = "";
    private String lastName = "";
    private String email = "";
    private String phoneNum = "";
    private String password = "";
    private UserType type = UserType.PARTICIPANT;
    private Date lastLogin = null;
    private int userID = 0;
    private ArrayList<Medication> medications = new ArrayList<>();
    //photo, not sure how to do

    public User() {

    }

}