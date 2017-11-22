package james.mosley.com.pillar;

import android.app.Activity;
import android.view.*;
import android.widget.*;

import java.util.ArrayList;

/**
 * Created by dkao on 11/19/2017.
 */

public class CommunityListAdapter extends ArrayAdapter {

        //to reference the Activity
        private final Activity context;
        private final ArrayList<Contact> ContactList;

        public CommunityListAdapter(Activity context, ArrayList<Contact> ContactList){

            super(context,R.layout.community_row, ContactList);

            this.context = context;
            this.ContactList = ContactList;
        }

        public View getView(int position, View view, ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.community_row, null,true);

            //this code gets references to objects in the community_row.xmll file
            TextView nameTextField = (TextView) rowView.findViewById(R.id.nameTextViewID);
            TextView infoTextField = (TextView) rowView.findViewById(R.id.infoTextViewID);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView1ID);
            ImageView statusIcon = (ImageView) rowView.findViewById(R.id.status);

            //this code sets the values of the objects to values from the arrays
            nameTextField.setText(ContactList.get(position).getName());
            infoTextField.setText(ContactList.get(position).getType());
            imageView.setImageResource(ContactList.get(position).getPhoto());

            switch(ContactList.get(position).getFriendStatus()) {

                case 0:
                    statusIcon.setImageResource(R.drawable.add);
                    break;
                case 1:
                    statusIcon.setImageResource(R.drawable.pending);
                    break;
                case 2:
                    statusIcon.setImageResource(R.drawable.done);
                    break;
            }

            return rowView;
        };
}
