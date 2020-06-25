package com.example.krazycoaches;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class AboutAdapter extends ArrayAdapter<AboutAdapter> {
    public AboutAdapter(Context context, ArrayList list){
        super(context,0,list);
    }
}
