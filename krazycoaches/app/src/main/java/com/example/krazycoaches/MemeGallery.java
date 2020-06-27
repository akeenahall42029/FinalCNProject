package com.example.krazycoaches;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MemeGallery extends AppCompatActivity {
    TextView title;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.meme_gallery);
        title = findViewById(R.id.title);
    }
}
