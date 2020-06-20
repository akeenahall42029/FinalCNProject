package com.example.krazycoaches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageButton evelynB;
    ImageButton roebuckB;
    ImageButton uthmanB;
    ImageButton michaelB;
    TextView instructions;
    TextView title;

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