package com.example.jack.mylibrary;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class AchievementsActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);


        String[] achievements = {"Score","Goal","sufuhgh","jdfhkhdfk","hsdfgsdhf","husdihfuih"};

        ListAdapter CustomAdapter = new CustomAdapter(this, achievements);
        ListView achievementListView = (ListView) findViewById(R.id.achievements_list_view);
        achievementListView.setAdapter(CustomAdapter);
    }

    public void onScan(View view){
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    protected void onPause(){
        super.onPause();
        mScannerView.stopCamera();
    }

    public void handleResult(Result result){
        //Do something with our result here

        Log.v("handleResult", result.getText());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setMessage(result.getText());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

}
