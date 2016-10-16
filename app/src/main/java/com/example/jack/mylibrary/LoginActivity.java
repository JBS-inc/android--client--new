package com.example.jack.mylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import ctrl.UserHandler;

public class LoginActivity extends AppCompatActivity {
    public static UserHandler handler = new UserHandler("http://138.68.146.164:3000");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_login);
        MultiDex.install(this);

    }




    public void btnLogin (View view){
        EditText mUsername   = (EditText)findViewById(R.id.input_username);
        EditText mPassword   = (EditText)findViewById(R.id.input_password);



        handler.loadUser(mUsername.getText().toString(),mPassword.getText().toString());
        handler.loadAchievements();
        Log.d("whatever:", handler.getAMessageFromServer());

        if (handler.isReady()) {

            Intent intent = new Intent(LoginActivity.this, AchievementsActivity.class);
            startActivity(intent);

      }

    }
}
