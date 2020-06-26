package com.example.krazycoaches;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class aboutActivity extends AppCompatActivity {
    Button holder;
    TextView testTest;
    ListView aboutListView;
    Context context;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_page);
        final ArrayList<AboutInfo> coaches = new ArrayList<>();
        aboutListView = findViewById(R.id.listview_about);
        context = this;



// The code down below isn't neeeded until the about page is set up correctly, then it needs to be modtified

        RequestQueue queue = Volley.newRequestQueue(this);
        String apiUrl = "https://mikestonecolumbia.github.io/Coaches-API/CoachesInfo.json";
        //Request a string response from the api, going to pull the college
        JsonObjectRequest coachRequest = new JsonObjectRequest(Request.Method.GET, apiUrl, null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        //try/catch is a special if statement, ex. trying to read a file w/ data on, sending data on internet is dangerous, when things go wrong, your code is going to crash; this can lead to mega problems. Try/catch attempts to open this file, if I fail, catch it and print an error message
                        try {
                            JSONArray coach = response.getJSONArray("CoachInfo");
                            //for loop to get info from  api
                            for(int i =0; i < coach.length();i++){
                                JSONObject coachesInfo = coach.getJSONObject(i);
                                String name = coachesInfo.getString("name");
                                String college = coachesInfo.getString("college");
                                String asso = coachesInfo.getString("association");
                                String quality = coachesInfo.getString("quality");
                                String fav_food = coachesInfo.getString("favorite_food");
                                String hobby = coachesInfo.getString("hobby");
                                //conditional for image view
                                    //uthman drawable
                                    coaches.add(new AboutInfo(R.drawable.ic_launcher_background,name,asso,college,hobby,fav_food,quality));




                            }

                        } catch (JSONException e) {
                            //programmers use this to figure out what went wrong, trouble shooting tactic
                            e.printStackTrace();
                        }
                        AboutAdapter aboutAdapter = new AboutAdapter(context,coaches);
                        aboutListView.setAdapter(aboutAdapter);
           }
        }, new Response.ErrorListener() {
            @Override
          public void onErrorResponse(VolleyError error) {
               testTest.setText("Fix the code, bro :/");
          }
        });





////        //adding the request to RequestQueue
        queue.add(coachRequest);


        Log.d("coaches",coaches.size()+"");

    }


}
