package com.example.krazycoaches;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Selection extends AppCompatActivity {
    ImageView coachImg;
    Button feed;
    Button hobby;
    ProgressBar hunger;
    ProgressBar hobbyBar;
    Button memeBtn;
    Coaches coach;
    TextView coachName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coachtemplate);
        //linking/ finding ids in coachtemplate.xml
        coachImg = findViewById(R.id.coachImg);
        feed = findViewById(R.id.Feed);
        hobby = findViewById(R.id.hobbyBtn);
        hunger = findViewById(R.id.hungerBar);
        hobbyBar = findViewById(R.id.hobbybar);
        memeBtn = findViewById(R.id.photoG);
        coachName = findViewById(R.id.coachName);
        //getting intent variable used for getting info from mainActivity.java intent conditional 
        Intent intIntent = getIntent();
        int flag = intIntent.getIntExtra("evelynInfo", 0); //changed defalut value from 1 to 0 because the econditional would always return true because eof the deefalut being 1
        int flag2 = intIntent.getIntExtra("roebuckInfo", 0);
        int flag3 = intIntent.getIntExtra("uthmanInfo", 0);
        if (flag == 1){
            coach = new Coaches(R.drawable.evelyntester,100,100,new String[]{"Hello","ewonenow","rownen"},"Evelyn");

        } else if (flag2 == 2) {
            coach = new Coaches(R.drawable.roebucktester,100,100,new String[]{"Ugh, Hello, I'm Coach Roebuck, thank you for taking care of me, I like and require a lot of things *talks for five minutes about his care*","My delivery person needs to hurry with my *FAV_PIZZA*","I have a phone conference with a studenet in Ghana"}, "Roebuck");

        } else if (flag3 == 3) {
            coach = new Coaches(R.drawable.uthmantester,100,100,new String []{"Hey, wassup guys, come on down.","I'm getting a little hungry", "I want to finish a piece of artwork"},"Uthman");

        }else{
            coach = new Coaches(R.drawable.michaeltester,100,100,new String[]{"Sup,take care of me!","I'm a hungry college student, give me food human","I need to finish my project for class!"},"michael");
        }
        //info input depending on which button was clicked
        //coachImg.setImageResource(coach.getImage());
        coachName.setText(coach.getName());
        hunger.setMax(coach.getHunger());
        hobbyBar.setMax(coach.getHobby());

    }
}
