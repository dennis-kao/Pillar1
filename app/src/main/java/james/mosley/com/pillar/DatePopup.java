package james.mosley.com.pillar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.content.Intent;

public class DatePopup extends AppCompatActivity {

    private int month = 0;
    private int day = 0;
    private int year = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_popup);
    }


    public void selectDate(View view) {

        //Getting date info.
        DatePicker temp = (DatePicker) findViewById(R.id.datePicker);
        month = temp.getMonth() + 1;
        day = temp.getDayOfMonth();
        year = temp.getYear();

        //Returning the date to Add Medication.
        Intent intent =  new Intent();
        intent.putExtra("month", month);
        intent.putExtra("day", day);
        intent.putExtra("year", year);
        setResult(1, intent);
        finish();


    }
}
