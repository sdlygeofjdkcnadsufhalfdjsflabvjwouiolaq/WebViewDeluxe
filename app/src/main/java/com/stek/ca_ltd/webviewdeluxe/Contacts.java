package com.stek.ca_ltd.webviewdeluxe;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Contacts extends AppCompatActivity {
    TextView c1;
    TextView c2;
    TextView c3;
    TextView c4;
    String portal1;
    String portal2;
    String portal3;
    String portal4;
    String adres1;
    String adres2;
    String adres3;
    String adres4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        c1 = (TextView) findViewById(R.id.contact1);
        c2 = (TextView) findViewById(R.id.contact2);
        c3 = (TextView) findViewById(R.id.contact3);
        c4 = (TextView) findViewById(R.id.contact4);
        adres1 ="https://www.youtube.com/user/PewDiePie";
        adres2 ="https://www.facebook.com/";
        adres3 ="https://www.instagram.com/nick__bateman/?hl=en";
        adres4 ="   ";

        portal1 = "Facebook: " + adres1;
        portal2 = "YouTube " + adres2;
        portal3 = "Instagram " + adres3;
        portal4 = " " + adres4;

        c1.setText(portal1);
        c2.setText(portal2);
        c3.setText(portal3);
        c4.setText(portal4);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(adres1));
                startActivity(intent);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(adres2));
                startActivity(intent);

            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(adres3));
                startActivity(intent);
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(adres4));
                startActivity(intent);

            }
        });







    }
}
