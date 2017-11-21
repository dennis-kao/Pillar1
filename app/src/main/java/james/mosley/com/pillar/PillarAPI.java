package james.mosley.com.pillar;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by mosleyj on 2017-11-18.
 */

public class PillarAPI {
    private OkHttpClient client = new OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .build();


    private String url1 = "http://131.104.180.41:8000/";

    public void testCall() {
        
        Request request = new Request.Builder()
                .url(url1)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("testCall",e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.toString());
            }
        });
    }

}