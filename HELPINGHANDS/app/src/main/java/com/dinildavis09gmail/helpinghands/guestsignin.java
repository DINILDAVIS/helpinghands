package com.dinildavis09gmail.helpinghands;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class guestsignin extends AppCompatActivity {
    Firebase myFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Firebase.setAndroidContext(this);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guestsignin);


        myFirebaseRef = new Firebase("https://thehelpinghand.firebaseio.com/details");



        myFirebaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<String> ar = new ArrayList<String>();
                if (dataSnapshot.getValue() != null) {


                    for(DataSnapshot snapshot : dataSnapshot.getChildren())
                    {
                            ar.add(snapshot.getValue().toString()+"\n"+snapshot.getKey().toString());
                        Log.d("shitnhg", snapshot.getValue().toString());
                    }


                }

                String[] a=ar.toArray(new String[0]);
                Log.d("shit", a.toString());
                ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.listitem,a);

                ListView listView = (ListView) findViewById(R.id.listView);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }}