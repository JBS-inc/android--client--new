package com.example.jack.mylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import model.Achievement;

import static com.example.jack.mylibrary.LoginActivity.handler;

public class AchievementsActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        int points= 0;
        points = points +handler.getPoints();
        TextView mPoints   = (TextView)findViewById(R.id.score_points);
        mPoints.setText("POINTS: "+ points);


        handler.loadAchievements();
        Log.d("Achievement list size", handler.getAchievements().size() + "");
        List<Achievement> achievements = handler.getAchievements();

        Achievement[] array = new Achievement[achievements.size()];
        for (int i=0;i<achievements.size();i++) {
            array[i] = achievements.get(i);
        }
        Log.d("Ach array size", achievements.toArray().length + "");

        ListAdapter CustomAdapter = new CustomAdapter(this, array);
        ListView achievementListView = (ListView) findViewById(R.id.achievements_list_view);
        achievementListView.setAdapter(CustomAdapter);
    }



    @Override
    public void onResume() {
        super.onResume();
        TextView mPoints   = (TextView)findViewById(R.id.score_points);
        handler.loadAchievements();
        mPoints.setText("POINTS: "+ handler.getPoints());


        List<Achievement> achievements = handler.getAchievements();

        Achievement[] array = new Achievement[achievements.size()];
        for (int i=0;i<achievements.size();i++) {
            array[i] = achievements.get(i);
        }

        ListAdapter CustomAdapter = new CustomAdapter(this, array);
        ListView achievementListView = (ListView) findViewById(R.id.achievements_list_view);
        achievementListView.setAdapter(CustomAdapter);

    }





    public void onScan (View view){
        Intent intent = new Intent(AchievementsActivity.this, QRActivity.class);
        startActivity(intent);

    }


}
