package com.stek.ca_ltd.webviewdeluxe;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;
    boolean connected = false;

    TextView mauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        }
        else{
            connected = false;}
        mauncher = (TextView) findViewById(R.id.textView12);
        //  Typeface typeface0 = Typeface.createFromAsset(getAssets(), "Baloo-Regular.ttf");
        // mauncher.setTypeface(typeface0);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
           /*     if(connected = true){
                Intent welcomeintent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(welcomeintent);}
                else if(connected = false){
                    Intent welcomeintent = new Intent(WelcomeActivity.this, ConnectionActivity.class);
                    startActivity(welcomeintent);
                }   */
                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                    //we are connected to a network
                    Intent welcomeintent = new Intent(WelcomeActivity.this, MainActivity.class);
                    startActivity(welcomeintent);
                }
                else{
                    Intent welcomeintent = new Intent(WelcomeActivity.this, ConnectionActivity.class);
                    startActivity(welcomeintent);
                    }
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
