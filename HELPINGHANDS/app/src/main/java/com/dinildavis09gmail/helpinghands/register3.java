package com.dinildavis09gmail.helpinghands;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
//import android.widget.Toast;
import com.firebase.client.Firebase;

public class register3 extends AppCompatActivity {
    Firebase myFirebaseRef;
    String click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);



        Firebase.setAndroidContext(this);

        Intent intent =getIntent();
        click=intent.getStringExtra("click");
    }

public void signup(View v){

    Log.d("joel",click);

    EditText et=(EditText) findViewById(R.id.id_phone);
    EditText em=(EditText) findViewById(R.id.id_email);
    if(et.getText().toString().trim().length()!=10)
    {
        et.setError("should be 10 digits");
    }
    else if(!isValidEmail(em.getText().toString().trim())){
      em.setError("invalid mail id");
    }
    else {


        String number = ((EditText) findViewById(R.id.id_phone)).getText().toString();
        if(click.compareTo("guest")==0) {
            myFirebaseRef = new Firebase("https://thehelpinghand.firebaseio.com/guest/" + number);
            myFirebaseRef.child("name").setValue(((EditText) findViewById(R.id.editText2)).getText().toString());
            myFirebaseRef.child("email").setValue(((EditText) findViewById(R.id.id_email)).getText().toString());
            myFirebaseRef.child("phone").setValue(((EditText) findViewById(R.id.id_phone)).getText().toString());
            myFirebaseRef.child("password").setValue(((EditText) findViewById(R.id.id_password1)).getText().toString());

        }
        else
            if (click.compareTo("agent")==0)

            {
                myFirebaseRef = new Firebase("https://thehelpinghand.firebaseio.com/agent/" + number);
                myFirebaseRef.child("name").setValue(((EditText) findViewById(R.id.editText2)).getText().toString());
                myFirebaseRef.child("email").setValue(((EditText) findViewById(R.id.id_email)).getText().toString());
                myFirebaseRef.child("phone").setValue(((EditText) findViewById(R.id.id_phone)).getText().toString());
                myFirebaseRef.child("password").setValue(((EditText) findViewById(R.id.id_password1)).getText().toString());

            }
        else
            if (click.compareTo("donor")==0)
            {
                myFirebaseRef = new Firebase("https://thehelpinghand.firebaseio.com/donor/" + number);
                myFirebaseRef.child("name").setValue(((EditText) findViewById(R.id.editText2)).getText().toString());
                myFirebaseRef.child("email").setValue(((EditText) findViewById(R.id.id_email)).getText().toString());
                myFirebaseRef.child("phone").setValue(((EditText) findViewById(R.id.id_phone)).getText().toString());
                myFirebaseRef.child("password").setValue(((EditText) findViewById(R.id.id_password1)).getText().toString());
            }
    }

}

   public  boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

}
