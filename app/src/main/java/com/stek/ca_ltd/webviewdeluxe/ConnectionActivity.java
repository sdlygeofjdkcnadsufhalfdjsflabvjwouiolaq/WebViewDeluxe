package com.stek.ca_ltd.webviewdeluxe;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ConnectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);
        AppCompatButton button = (AppCompatButton)findViewById(R.id.connectionCheck);
        final ProgressBar bar = (ProgressBar)findViewById(R.id.progress);
        final TextView connection = (TextView)findViewById(R.id.status);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                connection.setText("Checking....");
                bar.setVisibility(View.VISIBLE);
                if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                    connection.setText("You are online!");

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);



                }
                else {

                 connection.setText("Still no connection...");
                 bar.setVisibility(View.INVISIBLE);

                }
            }
        });

    }
}
