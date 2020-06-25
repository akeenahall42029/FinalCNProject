package com.example.krazycoaches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton evelynB;
    ImageButton roebuckB;
    ImageButton uthmanB;
    ImageButton michaelB;
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
                    instructions.setText("yuuuur");
                }

                if(millisUntilFinished<=25000){
                    instructions.setText("Hello there, this is sample code ");
                }
                if (millisUntilFinished<=20000){
                    instructions.setText("Kayley please edit me ");
                }
                if (millisUntilFinished<=15000){
                    instructions.setText("the coaches are great");

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
}