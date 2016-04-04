

package com.dinildavis09gmail.helpinghands;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class donsigninActivity extends AppCompatActivity {
    private Button button_4;
   // private Button button_5;
    Firebase myFirebaseRef;
    String click,name,email;
    Integer phone1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donsignin);
        Firebase.setAndroidContext(this);

        Intent intent=getIntent();
click=intent.getStringExtra("click");


        button_4 = (Button) findViewById(R.id.button);
      //  button_5= (Button) findViewById(R.id.id_signin);
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.dinildavis09gmail.helpinghands.register3");
                intent.putExtra("click",click);

                startActivity(intent);
            }

        });}


       // button_5.setOnClickListener(new View.OnClickListener()

   // {
        //@Override
      //  public void onClick(View v) {
        //Intent intent = new Intent("com.dinildavis09gmail.helpinghands.guestpageActivity");

       // startActivity(intent);

   // }
    //});

    public void signin(View v){
        if(click.compareTo("guest")==0) {
            myFirebaseRef = new Firebase("https://thehelpinghand.firebaseio.com/guest/");
            String phone=((EditText)findViewById(R.id.editText)).getText().toString();
            myFirebaseRef.child(phone).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    if (snapshot.getValue() != null) {
                        Toast.makeText(getApplicationContext(), snapshot.toString(), Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), guestsignin.class));


                    }else
                        Toast.makeText(getApplicationContext(), "user not found", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onCancelled(FirebaseError error) {

                }
            });

        }
        else
        if (click.compareTo("agent")==0)

        {
            myFirebaseRef = new Firebase("https://thehelpinghand.firebaseio.com/agent/");
            String phone=((EditText)findViewById(R.id.editText)).getText().toString();
            myFirebaseRef.child(phone).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    if (snapshot.getValue() != null) {
                        Toast.makeText(getApplicationContext(), snapshot.toString(), Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), guestsignin.class));
                    
                    }
                    else
                        Toast.makeText(getApplicationContext(), "user not found", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onCancelled(FirebaseError error) {

                }
            });

        }
        else
        if (click.compareTo("donor")==0)
        {
            myFirebaseRef = new Firebase("https://thehelpinghand.firebaseio.com/donor/");
            final String phone=((EditText)findViewById(R.id.editText)).getText().toString();
            myFirebaseRef.child(phone).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    if (snapshot.getValue() != null) {
                        Toast.makeText(getApplicationContext(), snapshot.toString(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), guestpageActivity.class);
                        SharedPreferences sharedpreferences = getSharedPreferences("shit", getApplicationContext().MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("phone", phone);
                        editor.commit();
                        startActivity(intent);
                    }
                        else
                        Toast.makeText(getApplicationContext(), "user not found", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onCancelled(FirebaseError error) {

                }
            });
        }

    }


}
