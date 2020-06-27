package com.example.krazycoaches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button evelynB;
    Button roebuckB;
    Button uthmanB;
    Button michaelB;
    TextView instructions;
    TextView title;
    CountDownTimer instruction_timer;
    int instruct_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        evelynB = findViewById(R.id.evelynB);
        roebuckB = findViewById(R.id.roebuckB);
        uthmanB = findViewById(R.id.uthmanB);
        michaelB = findViewById(R.id.michaelB);
        instructions = findViewById(R.id.instructions);
        title = findViewById(R.id.titleTd);

        //instruction countdown
        instruct_time = 30000;
        instruction_timer = new CountDownTimer(instruct_time,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished<=30000) {
                    instructions.setText("Welcome to Krazy Coaches ");
                }

                if(millisUntilFinished<=25000){
                    instructions.setText("This app is to show appreciation to our coaches at our Google Code Next Program ");
                }
                if (millisUntilFinished<=20000){
                    instructions.setText("Over the years we've created glorious memes of our coaches and we wanted to create a platform to share them");
                }
                if (millisUntilFinished<=15000){
                    instructions.setText("Please enjoy our app and note that its not made for bullying, thanks :)");

                }
            }

            @Override
            public void onFinish() {

               instructions.setText("Choose a coach!");
            }
        }.start();


    }


    public void toTemplate(View view) {
        Intent coachInfo = new Intent(this,Selection.class);
       //conditional  checking w/ th ids of the buttons then packing info according to button pressed
        if(view.getId()==evelynB.getId()){
          coachInfo.putExtra("evelynInfo",1);
        }else if(view.getId()==roebuckB.getId()){
            coachInfo.putExtra("roebuckInfo",2);
        }else if(view.getId()==uthmanB.getId()){
            coachInfo.putExtra("uthmanInfo",3);
        }else{
            coachInfo.putExtra("michaelInfo",4);
        }
        startActivity(coachInfo);
        }

    public void toAbout(View view) {
        Intent toAbout = new Intent(this,aboutActivity.class);
        startActivity(toAbout);
    }

    public void toMemes(View view) {
        Intent goToMemes = new Intent(this,MemeGallery.class);
        startActivity(goToMemes);
    }
}