package com.example.krazycoaches;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AboutAdapter extends ArrayAdapter<AboutInfo> {
    public AboutAdapter(Context context, ArrayList list){
        super(context,0,list);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.about_template, parent, false);

        //populate class with api info


        //last thing to do; ends the function
        return convertView;
    }
}
