package com.example.jack.mylibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static com.example.jack.mylibrary.LoginActivity.handler;

public class QRActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

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


        boolean success = handler.handleQRscan(result.getText());

        Log.d("QR scanning", "" + success);

        Log.v("handleResult", result.getText());

        finish();
    }
}
