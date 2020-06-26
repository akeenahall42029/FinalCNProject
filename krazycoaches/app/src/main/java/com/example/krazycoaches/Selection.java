package com.example.krazycoaches;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Selection extends AppCompatActivity {
    ImageView coachImg;
    Button feed;
    Button hobby;
    ProgressBar hungerBar;
    ProgressBar hobbyBar;
    Button memeBtn;
    Coaches coach;
    TextView coachName;
    CountDownTimer hungerTimer;
    CountDownTimer hobbyTimer;
    long hungerTime;
    long hobbyTime;
    int index = 0;
    String [] quoteResult;
    //code for toast
    int duration = Toast.LENGTH_LONG;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coachtemplate);
        //linking/ finding ids in coachtemplate.xml
        coachImg = findViewById(R.id.coachImg);
        feed = findViewById(R.id.Feed);
        hobby = findViewById(R.id.hobbyBtn);
        hungerBar= findViewById(R.id.hungerBar);
        hobbyBar = findViewById(R.id.hobbybar);
        memeBtn = findViewById(R.id.photoG);
        coachName = findViewById(R.id.coachName);
        //getting intent variable used for getting info from mainActivity.java intent conditional 
        Intent intIntent = getIntent();
        int flag = intIntent.getIntExtra("evelynInfo", 0); //changed default value from 1 to 0 because the econditional would always return true because eof the deefalut being 1
        int flag2 = intIntent.getIntExtra("roebuckInfo", 0);
        int flag3 = intIntent.getIntExtra("uthmanInfo", 0);
        if (flag == 1){
            //pull quote info for the String array for each quote
            coach = new Coaches(R.drawable.evelyntester,40000,40000,"Evelyn");
//            Toast testerToast  = Toast.makeText()

        } else if (flag2 == 2) {
            coach = new Coaches(R.drawable.roebucktester,40000,40000, "Roebuck");
        } else if (flag3 == 3) {
            coach = new Coaches(R.drawable.uthmantester,40000,40000,"Uthman");


        }else{
            coach = new Coaches(R.drawable.michaeltester,40000,40000,"Michael");
        }

        //info input depending on which button was clicked
        //coachImg.setImageResource(coach.getImage());
        coachName.setText(coach.getName());
        //progress bar amounts declared
        hungerBar.setMax(coach.getHunger());
        hobbyBar.setMax(coach.getHobby());
        getQuotes();
        //countdown time for hunger declaration
         hungerTime = 40000;
         hobbyTime = 40000;
         //ADD COD FROM CLONE
        resetTime(hungerTime,hobbyTime);

//        if(hobbyTime<40000 && hobbyTime>20000){
//            hungerBar.setProgress();
//        }
        //onClick listener for feed button and hobby button
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hungerTimer.cancel();
                hobbyTimer.cancel();
                hungerTime+=5000;
                resetTime(hungerTime,hobbyTime);

            }
        });
        //bug with code, the hobby button increases the hunger progress bar as well, ask for peer help

        hobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hobbyTimer.cancel();
                hungerTimer.cancel();
                hobbyTime+=5000;
                resetTime(hungerTime,hobbyTime);
            }
        });
        //pulling from api for toasts
        //
        if(hungerTime==0){
            //play toast
            Toast testToast = Toast.makeText(getApplication(),quoteResult[3],duration);
            testToast.show();
        }



    }
    public void resetTime(long newHunger,long newHobby){
        hungerTime=newHunger;
        hobbyTime=newHobby;
        hungerTimer = new CountDownTimer(hungerTime,5500) {
            @Override
            public void onTick(long millisUntilFinished) {
                //setting the progress bar value to the amount of the countdown timer
                hungerBar.setProgress((int)millisUntilFinished);
                hungerTime = millisUntilFinished;
                //conditional for changing animations


            }

            @Override
            public void onFinish() {
                hungerTime= 0;
                hungerBar.setProgress(0);


            }
        }.start();


        hobbyTimer = new CountDownTimer(hobbyTime,6500) {
            @Override
            public void onTick(long millisUntilFinished) {
                hobbyBar.setProgress((int)millisUntilFinished);
                hobbyTime = millisUntilFinished;
            }

            @Override
            public void onFinish() {
                hobbyTime=0;
                hobbyBar.setProgress(0);

            }
        }.start();
    }
    //this function pulls the quotes according to the coach that was clicked on
    public void getQuotes(){

        if (coach.getName().equals("Evelyn")){
            //pull quote info for the String array for each quote
            index = 2;
        } else if (coach.getName().equals("Roebuck")) {
            index= 1;
        } else if (coach.getName().equals("Uthman")) {
          index = 0;
        }else{
           index = 4;
        }
        RequestQueue queue = Volley.newRequestQueue(this);
        String apiUrl = "https://mikestonecolumbia.github.io/Coaches-API/CoachesInfo.json";
        //Request a string response from the api, going to pull the college
        JsonObjectRequest collegeRequest = new JsonObjectRequest(Request.Method.GET, apiUrl, null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        //try/catch is a special if statement, ex. trying to read a file w/ data on, sending data on internet is dangerous, when things go wrong, your code is going to crash; this can lead to mega problems. Try/catch attempts to open this file, if I fail, catch it and print an error message
                        try {
                            JSONArray coach = response.getJSONArray("CoachInfo");
                            JSONObject coachObject = coach.getJSONObject(index);
                            //code for toasts
                            String coachQuote= coachObject.getString("quotes");
                            quoteResult = coachQuote.split("%");

                        } catch (JSONException e) {
                            //programmers use this to figure out what went wrong, trouble shooting tactic
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


//        //adding the request to RequestQueue
        queue.add(collegeRequest);
    }
}
