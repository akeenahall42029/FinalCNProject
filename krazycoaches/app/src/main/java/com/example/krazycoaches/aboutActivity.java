package com.example.krazycoaches;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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


public class aboutActivity extends AppCompatActivity {
    Button holder;
    TextView testTest;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_page);


// The code down below isn't neeeded until the about page is set up correctly, then it needs to be modtified

//        RequestQueue queue = Volley.newRequestQueue(this);
//        String apiUrl = "https://mikestonecolumbia.github.io/Coaches-API/CoachesInfo.json";
//        //Request a string response from the api, going to pull the college
//        JsonObjectRequest collegeRequest = new JsonObjectRequest(Request.Method.GET, apiUrl, null,
//                new Response.Listener<JSONObject>(){
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        //try/catch is a special if statement, ex. trying to read a file w/ data on, sending data on internet is dangerous, when things go wrong, your code is going to crash; this can lead to mega problems. Try/catch attempts to open this file, if I fail, catch it and print an error message
//                        try {
//                            JSONArray coach = response.getJSONArray("CoachInfo");
//                            JSONObject uthmanDawg = coach.getJSONObject(0);
//                            //code for toasts
//                            String uthamnName= uthmanDawg.getString("quotes");
//                            String [] uthmanQuotes = uthamnName.split("%");
//                            //if(timer >20000){ uthmanQuotes[0]}; this would get the first quote
//
//                            testTest.setText("College" + uthmanQuotes[0]);
//                        } catch (JSONException e) {
//                            //programmers use this to figure out what went wrong, trouble shooting tactic
//                            e.printStackTrace();
//                        }
//           }
//        }, new Response.ErrorListener() {
//            @Override
//          public void onErrorResponse(VolleyError error) {
//               testTest.setText("Fix the code, bro :/");
//          }
//        });
//




////        //adding the request to RequestQueue
//        queue.add(collegeRequest);



    }

    public void testIntent(View view) {
        Intent tester = new Intent(this,MainActivity.class);
        startActivity(tester);
    }
}
