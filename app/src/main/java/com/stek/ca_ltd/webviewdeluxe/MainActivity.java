package com.stek.ca_ltd.webviewdeluxe;

import android.app.FragmentManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static com.stek.ca_ltd.webviewdeluxe.R.id.toolbar;

public class MainActivity extends AppCompatActivity {
    public WebView webView;
    String url = "http://youtube.com";
    private static int SPLASH_TIME_OUT = 21600000;
   // private static int SPLASH_TIME_OUT = 60000;
    NotificationCompat.Builder notification;
    Context mContext;
    private static final int notID = 31212;
    boolean Clicked = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
        FloatingActionButton home = (FloatingActionButton) findViewById(R.id.home);
        FloatingActionButton contacts = (FloatingActionButton) findViewById(R.id.contacts);




        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
        webView.getSettings().setMediaPlaybackRequiresUserGesture(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setPluginState (WebSettings.PluginState.ON);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setAppCachePath(getApplicationContext().getFilesDir().getAbsolutePath() + "/cache");
        webView.getSettings().setDatabaseEnabled(true);
        webView.getSettings().setDatabasePath(getApplicationContext().getFilesDir().getAbsolutePath() + "/databases");
        //    webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient(){});


        //  WebSettings webSettings = webView.getSettings();
        //webSettings.setJavaScriptEnabled(true);
      //  FloatingActionButton home = (FloatingActionButton) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                    webView.loadUrl(url);}
                else{
                    Intent intent = new Intent(getApplicationContext(), ConnectionActivity.class);
                    startActivity(intent);
                }    }
        });

                //    FloatingActionButton contacts = (FloatingActionButton) findViewById(R.id.contacts);
        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Contacts.class);
                startActivity(intent);
            }
        });
       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Clicked) {



                }
                else{

                    home.setVisibility(View.VISIBLE);
                    contacts.setVisibility(View.VISIBLE);
                    home.setClickable(true);
                    contacts.setClickable(true);
                }
            }
        }); */




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                notification.setSmallIcon(R.mipmap.ic_launcher);
                notification.setTicker("Check out new posts!");
                notification.setWhen(System.currentTimeMillis());
                notification.setContentTitle("New content");
                notification.setContentText("Newsroom has all new posts for you!");

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                notification.setContentIntent(pendingIntent);

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(notID, notification.build());

                finish();
            }
        },SPLASH_TIME_OUT);

    }

    @Override
    public void onBackPressed(){
        if(webView.canGoBack()) {

            webView.goBack();
        }

        else{
            super.onBackPressed();

        }

    }



}
