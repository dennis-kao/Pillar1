package james.mosley.com.pillar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import james.mosley.com.pillar.Shared.SessionInformation;
import james.mosley.com.pillar.Shared.PillarAPI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User creator = new User();
        Medication med = new Medication();
        Community friends = new Community();

        //Testing API calls... Won't be in this activity for final version
        PillarAPI pillarAPI = new PillarAPI();
        pillarAPI.testCall();

        Boolean status = pillarAPI.createAccount(creator, "test@gmail.com", "password", "CLC Client");
        SessionInformation temp = pillarAPI.login("God","thing");



        //sets up recycler view
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MedicationListAdapter adapter = new MedicationListAdapter();
        recyclerView.setAdapter(adapter);
    }

}
