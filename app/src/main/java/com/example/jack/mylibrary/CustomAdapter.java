package com.example.jack.mylibrary;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import model.Achievement;

/**
 * Created by jack on 14/10/2016.
 */

public class CustomAdapter extends ArrayAdapter<Achievement>{

    public CustomAdapter(Context context, Achievement[] achievements) {
        super(context,R.layout.custom_achievement, achievements);


        Log.d("Size ca ach", achievements.length +"");
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.d("position: ", position +"");


        LayoutInflater achievementInflater = LayoutInflater.from(getContext());
        View customView = achievementInflater.inflate(R.layout.custom_achievement, parent, false);


        Achievement achievementItem = getItem(position);
        TextView achievementTitle = (TextView) customView.findViewById(R.id.achievement_title);
        ImageView achievementScoreImage = (ImageView) customView.findViewById(R.id.achievement_score_image);
        TextView achievementDescription = (TextView) customView.findViewById(R.id.achievement_description);
        //TextView achievementScore = (TextView)

        achievementTitle.setText(achievementItem.getName());
        achievementScoreImage.setImageResource(R.drawable.filler);
        achievementDescription.setText(achievementItem.getDesc());

        return customView;
    }
}

