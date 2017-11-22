package james.mosley.com.pillar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import james.mosley.com.pillar.Shared.PillarAPI;
import james.mosley.com.pillar.Shared.SessionInformation;
import james.mosley.com.pillar.Shared.UserType;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String date = "20170101";

        User newUser = new User("John","Doe","jd@pillar.ca","123-456-789","password", UserType.Participant,date,1);



        Medication med = new Medication();
        Community friends = new Community();

        //Testing API calls... Won't be in this activity for final version
        PillarAPI pillarAPI = new PillarAPI();
        pillarAPI.testCall();

        SessionInformation temp = pillarAPI.login("iamadmin@clc.ca","iamadmin");
        Boolean status = pillarAPI.createAccount(newUser,temp);




        //sets up recycler view
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MedicationListAdapter adapter = new MedicationListAdapter();
        recyclerView.setAdapter(adapter);

        Intent toAddmediacton = new Intent(this,CommunityActivity.class);
        startActivity(toAddmediacton);
    }

}
