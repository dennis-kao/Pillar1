package james.mosley.com.pillar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ContactDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        final Button addContactButton = (Button) findViewById(R.id.add_contact);
        final Contact contact = (Contact) getIntent().getSerializableExtra(Contact.EXTRA);

        TextView myText = (TextView) findViewById(R.id.contactName);
        myText.setText(contact.getName());

        myText = (TextView) findViewById(R.id.info);
        myText.setText(contact.getType());

        myText = (TextView) findViewById(R.id.email);
        myText.setText(contact.getEmail());

        myText = (TextView) findViewById(R.id.phone);
        myText.setText(contact.getPhoneNum());

        int[] notif = contact.getNotifStatus();
        myText = (TextView) findViewById(R.id.notifyOver);

        String notifMessage = "";

        if (notif[0] == 1) notifMessage += "in-app ";
        if (notif[1] == 1) notifMessage += "email ";
        if (notif[2] == 1) notifMessage += "text ";

        myText.setText(notifMessage);

        ImageView contact_pic = (ImageView) findViewById(R.id.ContactPhoto);
        contact_pic.setImageResource(contact.getPhoto());

        // button stuff

        myText = (TextView) findViewById(R.id.status);
        switch (contact.getFriendStatus()) {
            case 0:
                myText.setText("Request not yet sent");
                addContactButton.setText("Add to contacts");
                break;
            case 1:
                myText.setText("Request pending");
                addContactButton.setText("Cancel pending request");
                break;
            case 2:
                myText.setText("Request accepted!");
                addContactButton.setText("Manage notifications");
                break;
        }


        addContactButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                //  send over the contact to the click
                Intent goBackHome = new Intent(ContactDetailActivity.this, CommunityActivity.class);
                Integer status = contact.getFriendStatus();

                switch(status)
                {
                    case 2: //  manage notifications
                        CheckmarkDialogMessage box = new CheckmarkDialogMessage();
                        box.show(getFragmentManager(), "Notifications");
                        break;
                    case 1: //  delete pending request
                        //  change status to
                        contact.setFriendStatus(Contact.FriendStatus.NEW);
                        //  print toast
                        Toast.makeText(getBaseContext(), "Deleted friend request!", Toast.LENGTH_SHORT).show();
                        //  go back to community
                        startActivity(goBackHome);
                        break;
                    case 0: //  send request
                        //  change status to 1
                        contact.setFriendStatus(Contact.FriendStatus.PENDING);
                        //  print toast
                        Toast.makeText(getBaseContext(), "Sent a friend request!", Toast.LENGTH_SHORT).show();
                        //  go back to community
                        startActivity(goBackHome);
                        break;
                }
            }
        });
    }

    public void backButtonClicked(View view) {
        //Intent intent = new Intent(this, CommunityActivity.class);
        //startActivity(intent);
        finish();
    }

}
