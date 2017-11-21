package james.mosley.com.pillar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import james.mosley.com.pillar.Models.LoginObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User client = new User();
        Medication med = new Medication();
        Community friends = new Community();

        //Testing API calls... Won't be in this activity for final version
        PillarAPI pillarAPI = new PillarAPI();
        pillarAPI.testCall();
        try {
            Boolean status = pillarAPI.createAccount("test@gmail.com", "password", "CLC Client");
        } catch (Exception e) {
            Log.e("createAccountError",e.getMessage());
        }

        try {
            LoginObject temp = pillarAPI.login("God","thing");
        } catch (Exception e) {
            Log.e("LoginError",e.getMessage());
        }


        //sets up recycler view
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MedicationListAdapter adapter = new MedicationListAdapter();
        recyclerView.setAdapter(adapter);
    }

}
