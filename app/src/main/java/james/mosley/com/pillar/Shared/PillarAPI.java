package james.mosley.com.pillar.Shared;

import android.support.annotation.NonNull;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by mosleyj on 2017-11-18.
 */

public class PillarAPI {
    private OkHttpClient client = new OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .build();

    private Boolean done;
    private Boolean result;
    private JSONObject toReturn;
    private String baseURL = "http://131.104.180.41:8000/";
    private MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public void testCall() {
        
        Request request = new Request.Builder()
                .url(baseURL)
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

    public Boolean createAccount(String email, String password, String accountType) {
        done = false;
        result = false;
        toReturn = null;
        String url = baseURL+"users/createAccount";

        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        params.put("accountType",accountType);
        JSONObject jsonObject = new JSONObject(params);

        RequestBody body = RequestBody.create(JSON,jsonObject.toString());
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .header("Content-Type", "application/json; charset=utf-8")
                .build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("createAccountFailure",e.toString());
                result = false;
                done = true;
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("CreateAccountCall","Login Successful!");
                try {
                    String resp = response.body().string();
                    JSONObject jsonObject = new JSONObject(resp);
                    result = true;
                    done = true;
                }catch (Exception e){
                    Log.e("CreateAccountCall",e.getMessage());
                }
            }
        });
        while (!done);
        return result;
    }

    public LoginObject login(String email, String password) {
        result = false;
        done = false;
        toReturn = null;
        String url = baseURL+"users/login";

        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        JSONObject jsonObject = new JSONObject(params);

        RequestBody body = RequestBody.create(JSON,jsonObject.toString());
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .header("Content-Type", "application/json; charset=utf-8")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, IOException e) {
                Log.e("LoginFailure",e.toString());
                result = false;
                done = true;
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                try {
                    Log.i("LoginSuccess","Login Successful!");
                    String resp = response.body().string();
                    toReturn = new JSONObject(resp);
                }catch (Exception e) {
                    Log.e("LoginResponseParseError",e.getMessage());
                }
                result = true;
                done = true;
            }
        });
        while (!done);

        String error = null;
        String userID = null;
        String loginToken = null;
        String loginTokenExpires = null;
        String accountType = null;

        try {
            userID = toReturn.getString("id");
            loginToken = toReturn.getString("loginToken");
            loginTokenExpires = toReturn.getString("loginTokenExpires");
            accountType = toReturn.getString("accountType");


        } catch (JSONException e) {
            e.printStackTrace();
        }
        LoginObject loginObject = new LoginObject(error,userID,loginToken,loginTokenExpires,accountType);

        return loginObject;
    }
}
