package james.mosley.com.pillar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.content.Intent;
import java.util.*;
import android.widget.*;


public class AddMedication extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medication);

        DatePicker currentDate = (DatePicker) findViewById(R.id.datePicker);
        //currentDate.init(2017, 11, 21, showCalendar(View view));
    }

    //Info from UI.
    private int startMonth = 0;
    private int startDay = 0;
    private int startYear = 0;
    private boolean notificationStatus = false;
    private int notifyBefore = 0;
    private int dosage = 0;

    private String dosageUnit = "";
    private String Medication = "";
    private String name = "";
    private String time = "";
    private String startDate = "";
    private String endDate = "";
    private String notes = "";
    private ArrayList<String> days = new ArrayList<>();



    private final int CALENDAR_RESULT_START = 1;

    //Date Functionality. Must be fixed for Start & End dates.
    public void showCalendar(View view) {

        Intent showCalIntent = new Intent(this, DatePopup.class);
        startActivityForResult(showCalIntent, CALENDAR_RESULT_START);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CALENDAR_RESULT_START)
        {
            startMonth = data.getIntExtra("month", 0);
            startDay = data.getIntExtra("day", 0);
            startYear = data.getIntExtra("year", 0);

        }
    }



    public void medicationSubmitted(View view) {

        //error message init.
        TextView error = (TextView) findViewById(R.id.errorMessage);

        //Notification Information
        Switch notification = (Switch) findViewById(R.id.switch2);
        if (notification.isChecked()) {
            notificationStatus = true;
            Spinner notifySpinner = (Spinner) findViewById(R.id.notificationTimeDD);
            notifyBefore = Integer.parseInt(notifySpinner.getSelectedItem().toString());
        }

        //Name Information
        EditText nameText = (EditText) findViewById(R.id.nameTextfield);
        if ((!nameText.getText().toString().isEmpty()) && nameText.getText().toString() != "Enter Name...") {
            name = nameText.toString();
            System.out.println(name + "ADDED!******");
        }
        else {
            //let the user know they must enter a name.
            error.setText("Please enter Medication name!");
            days.clear();
            return;
        }

        //Adding Days to Arraylist. Clean the ArrayList at end of method.
        RadioButton sun = (RadioButton) findViewById(R.id.sundayRadio);
        RadioButton mon = (RadioButton) findViewById(R.id.mondayRadio);
        RadioButton tues = (RadioButton) findViewById(R.id.tuesdayRadio);
        RadioButton wed = (RadioButton) findViewById(R.id.wednesdayRadio);
        RadioButton thurs = (RadioButton) findViewById(R.id.thursdayRadio);
        RadioButton fri = (RadioButton) findViewById(R.id.fridayRadio);
        RadioButton sat = (RadioButton) findViewById(R.id.saturdayRadio);

        if (sun.isChecked()) {
            days.add("sunday");
        }
        if (mon.isChecked()) {
            days.add("monday");
        }
        if (tues.isChecked()) {
            days.add("tuesday");
        }
        if (wed.isChecked()) {
            days.add("wednesday");
        }
        if (thurs.isChecked()) {
            days.add("thursday");
        }
        if (fri.isChecked()) {
            days.add("friday");
        }
        if (sat.isChecked()) {
            days.add("saturday");
        }
        if (days.isEmpty()) {
            error.setText("Please Select the Days Taken!");
            return;
        }


        //Dosage Information
        EditText dosageText = (EditText) findViewById(R.id.dosageInput);
        Spinner dosageType = (Spinner) findViewById(R.id.dosageDD);

        System.out.println("<<<" + dosageText.getText().toString() + ">>>");
        if (!dosageText.getText().toString().isEmpty()) {
            dosage = Integer.parseInt(dosageText.getText().toString());
            dosageUnit = dosageType.getSelectedItem().toString();
            System.out.println("dosage: " + dosage + "units: " + dosageUnit);
        }
        else {
            //Tell user to input proper dosage.
            error.setText("Please Enter Dosage!");
            days.clear();
            return;
        }

        //Time Information
        Spinner hour = (Spinner) findViewById(R.id.hour);
        Spinner min = (Spinner) findViewById(R.id.minute);
        Spinner amPm = (Spinner) findViewById(R.id.am_pm);

        time = hour.getSelectedItem().toString() + ":" +  min.getSelectedItem().toString() + amPm.getSelectedItem().toString();

        //Start and end date.
        startDate = "20171122";
        endDate = "20180101";

        //Notes
        EditText extraNotes = (EditText) findViewById(R.id.notesTextField);
        notes = extraNotes.getText().toString();

        Medication newMed = new Medication();
        error.setText("");
        Toast toast = Toast.makeText(getApplicationContext(), "Medication Successfully Added", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();

    }

    //RadioButton Toggle.
    public void changeRadioButtons(View view) {

       /* int id = view.getId();

        RadioButton r = null;

        System.out.println("***********" + view.getId() + "************");

        switch (view.getId()) {
            case R.id.sundayRadio:
                System.out.println("Sunday Radio is clicked");
                r = (RadioButton) findViewById(R.id.sundayRadio);
                r.toggle();
                break;
            case R.id.mondayRadio:
                System.out.println("Monday Radio is clicked");
                r = (RadioButton) findViewById(R.id.mondayRadio);
                if (r.isChecked()) {
                    r.setChecked(false);
                }
                else {
                    r.setChecked(true);
                }

                if (r.isChecked()) {
                    r.setChecked(true);
                }
                else {
                    r.setChecked(false);
                }
                break;
            case R.id.tuesdayRadio:
                r = (RadioButton) findViewById(R.id.tuesdayRadio);
                break;
            case R.id.wednesdayRadio:
                r = (RadioButton) findViewById(R.id.wednesdayRadio);
                break;
            case R.id.thursdayRadio:
                r = (RadioButton) findViewById(R.id.thursdayRadio);
                break;
            case R.id.fridayRadio:
                r = (RadioButton) findViewById(R.id.fridayRadio);
                break;
            case R.id.saturdayRadio:
                r = (RadioButton) findViewById(R.id.saturdayRadio);
                break;
            default:
                break;
        }

        if (r != null) {
            r.toggle();
        }*/
    }

}


