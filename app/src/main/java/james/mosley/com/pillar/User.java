package james.mosley.com.pillar;

import java.util.ArrayList;

import james.mosley.com.pillar.Shared.UserType;


public class User {

    //Types of users

    //User info.
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNum;
    private String password;
    private UserType type;
    private String lastLogin;
    private int userID;
    private ArrayList<Medication> medications;
    //photo, not sure how to do

    public User(String firstName, String lastName, String email, String phoneNum, String password,
                    UserType type, String lastLogin, int userID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.password = password;
        this.type = type;
        this.lastLogin = lastLogin;
        this.userID = userID;
        this.medications = new ArrayList<>();
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public String getFirstName() {
        return firstName;
    }

    public ArrayList<Medication> getMedications() {
        return medications;
    }

    public int getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public UserType getType() {
        return type;
    }
}