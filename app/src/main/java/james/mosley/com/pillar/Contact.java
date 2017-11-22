package james.mosley.com.pillar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;



public class Contact implements Serializable {

    public static final String EXTRA = "james.mosley.com.pillar.Contact";

    public enum UserType {PARTICIPANT, STAFF, ADMIN}
    public enum FriendStatus {NEW, PENDING, ACCEPTED}

    //Contact info.
    private String firstName = "";
    private String lastName = "";
    private String email = "";
    private String phoneNum = "";
    private UserType type = UserType.PARTICIPANT;
    private Integer photo = 0;
    private int[] notifStatus = {0, 0, 0};
    private FriendStatus status = FriendStatus.NEW;

    private Date lastLogin = null;
    private int userID = 0;
    private ArrayList<Medication> medications = new ArrayList();

    public Contact(String first, String last, String email, String num, UserType type, Integer photo, int[] notifStatus, FriendStatus status, int userid) {

        this.firstName = first;
        this.lastName = last;
        this.email = email;
        this.phoneNum = num;
        this.type = type;
        this.photo = photo;

        if (status == FriendStatus.ACCEPTED) this.notifStatus = notifStatus;

        this.status = status;
        this.userID = userid;
    }

    public String getPhoneNum()
    {
        return this.phoneNum;
    }

    public String getName()
    {
        return this.firstName + " " + this.lastName;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getType()
    {
        switch (this.type)
        {
            case PARTICIPANT:
                return "CLC Participant";
            case STAFF:
                return "CLC Staff";
            case ADMIN:
                return "CLC Admin";
        }

        return "CLC TYPE ERROR";
    }

    public Integer getPhoto()
    {
        return this.photo;
    }

    public int[] getNotifStatus()
    {
        int[] not_notified = {0,0,0};

        //  hack to make it so you can't notify contacts who are not friends
        if (this.status == FriendStatus.ACCEPTED) return this.notifStatus;
        else return not_notified;
    }

    public int getFriendStatus()
    {
        switch (this.status)
        {
            case NEW:
                return 0;
            case PENDING:
                return 1;
            case ACCEPTED:
                return 2;
        }

        return 0;
    }

    public int getUserID()
    {
        return this.userID;
    }

    public void setNotifStatus(int[] notif_status)
    {
        this.notifStatus = notif_status;
    }

    public void setFriendStatus(FriendStatus friend_status)
    {
        this.status = friend_status;
    }
}