package com.example.jack.mylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

public class AchievementsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);


        String[] achievements = {"Score","Goal","sufuhgh","jdfhkhdfk","hsdfgsdhf","husdihfuih"};

        ListAdapter CustomAdapter = new CustomAdapter(this, achievements);
        ListView achievementListView = (ListView) findViewById(R.id.achievements_list_view);
        achievementListView.setAdapter(CustomAdapter);
    }
}
