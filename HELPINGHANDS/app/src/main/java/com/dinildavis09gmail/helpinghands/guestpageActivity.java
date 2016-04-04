package com.dinildavis09gmail.helpinghands;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class guestpageActivity extends AppCompatActivity {
    Firebase myFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Firebase.setAndroidContext(this);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_guestpage);


    }
    public void notify(View v)
    {
        myFirebaseRef = new Firebase("https://thehelpinghand.firebaseio.com");

        SharedPreferences sharedpreferences = getSharedPreferences("shit", Context.MODE_PRIVATE);
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        myFirebaseRef.child("details").child(sharedpreferences.getString("phone","error")).setValue(((EditText) findViewById(R.id.id_fd)).getText().toString()+"\n"+df.format(today));


    }
}