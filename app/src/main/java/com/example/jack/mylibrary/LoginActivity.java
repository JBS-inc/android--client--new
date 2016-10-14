package com.example.jack.mylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

//
//    public boolean login(){
//
//    }

    public void btnLogin (View view){
        Intent intent = new Intent(LoginActivity.this, AchievementsActivity.class);
        startActivity(intent);

    }
}
