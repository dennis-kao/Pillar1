package james.mosley.com.pillar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Testing Dev Branch");

        User client = new User();
        Medication med = new Medication();
        Community friends = new Community();
    }


}
