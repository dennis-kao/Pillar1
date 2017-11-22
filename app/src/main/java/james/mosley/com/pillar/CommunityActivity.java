package james.mosley.com.pillar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import java.io.Serializable;
import java.util.ArrayList;

public class CommunityActivity extends AppCompatActivity {

    private final ArrayList<Contact> ContactList = new ArrayList<Contact>();
    private ListView listView;
    private CommunityListAdapter adapter;
    private int created = 0;

    protected void onCreate(Bundle savedInstanceState) {

        int[] notifstatus = {0, 1, 1};
        int[] notifstatus2 = {1, 0, 1};

        if (created == 0)
        {
            ContactList.add(new Contact("Dan", "Gillis", "dan.gillis@gmail.com", "519-798-2313", Contact.UserType.ADMIN, R.drawable.dan, notifstatus, Contact.FriendStatus.ACCEPTED, 0));
            ContactList.add(new Contact("Bill", "Nye", "stan.francisco@gmail.com", "519-445-3591",Contact.UserType.PARTICIPANT, R.drawable.bill, notifstatus2, Contact.FriendStatus.PENDING, 1));
            ContactList.add(new Contact("Grace", "Fazooli", "g.fazooli@gmail.com", "519-445-2200",Contact.UserType.PARTICIPANT, R.drawable.girl, notifstatus2, Contact.FriendStatus.ACCEPTED, 3));
            ContactList.add(new Contact("Tommy", "Paul", "t.paul@gmail.com", "519-445-2200",Contact.UserType.PARTICIPANT, R.drawable.boy, notifstatus2, Contact.FriendStatus.ACCEPTED, 3));
            ContactList.add(new Contact("Emily", "Watson", "em.watson@gmail.com", "519-445-2200",Contact.UserType.PARTICIPANT, R.drawable.teen, notifstatus2, Contact.FriendStatus.ACCEPTED, 3));
            ContactList.add(new Contact("Tupac", "Shakur", "2PAC@gmail.com", "519-445-0000",Contact.UserType.STAFF, R.drawable.tupac, notifstatus2, Contact.FriendStatus.NEW, 2));
//            ContactList.add(new Contact("Mr.", "Dressup", "mr.dressup@gmail.com", "519-445-2200",Contact.UserType.STAFF, R.drawable.dressup, notifstatus2, Contact.FriendStatus.NEW, 3));
            //        ContactList.add(new Contact("Lil", "Pump", "lil.pump@gmail.com", "519-445-0000",Contact.UserType.PARTICIPANT, R.drawable.lilpump, notifstatus2, Contact.FriendStatus.NEW));

            created = 1;
        }
        else
        {
            //  get the list from the server
            //  this way the list is gaurenteed to be updated and I don't have to
            //  terrible hack i know im sorry
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        adapter = new CommunityListAdapter(this, ContactList);
        listView = (ListView) findViewById(R.id.listviewID);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Intent intent = new Intent(CommunityActivity.this, ContactDetailActivity.class);
                Contact contact = ContactList.get(position);

                intent.putExtra(contact.EXTRA, (Serializable) contact);

                startActivity(intent);
            }
        });
    }
}
