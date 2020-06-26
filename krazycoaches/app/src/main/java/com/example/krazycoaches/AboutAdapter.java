package com.example.krazycoaches;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

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
        AboutInfo currentInfo = getItem(position);
        ImageView currentInfoImgV = convertView.findViewById(R.id.coach_img);
        TextView currentInfoName = convertView.findViewById(R.id.coach_name);
        TextView currentInfoQuality = convertView.findViewById(R.id.coach_quality);
        TextView currentInfoCol = convertView.findViewById(R.id.coach_college);
        TextView currentInfoasso = convertView.findViewById(R.id.coach_asso);
        TextView currentInfofav = convertView.findViewById(R.id.fav_food);
        TextView currentInfoHobby = convertView.findViewById(R.id.coach_hobby);
        currentInfoImgV.setImageResource(currentInfo.getCoach_img());
        currentInfoName.setText(currentInfo.getCoach_name());
        currentInfoQuality.setText(currentInfo.getCoach_quality());
        currentInfoCol.setText(currentInfo.getCoach_college());
        currentInfoasso.setText(currentInfo.getCoach_asso());
        currentInfofav.setText(currentInfo.getCoach_fav_food());
        currentInfoHobby.setText(currentInfo.getCoach_hobby());


        //last thing to do; ends the function
        return convertView;
    }
}
