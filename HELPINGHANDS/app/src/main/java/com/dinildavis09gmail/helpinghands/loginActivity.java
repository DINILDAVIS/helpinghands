package com.dinildavis09gmail.helpinghands;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class loginActivity extends AppCompatActivity {
    private Button button_1;
    private Button button_2;
    private Button button_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Toolbar toolbar =(toolbar)  findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        button_1 = (Button) findViewById(R.id.id_guest);
        button_2 = (Button) findViewById(R.id.id_agent);
        button_3 = (Button) findViewById(R.id.id_donor);
        //OnClickButtonListner();
        //OnClickButtonListner2();
        //OnClickButtonListner3();
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.dinildavis09gmail.helpinghands.donsigninActivity");
                intent.putExtra("click","guest");
                startActivity(intent);


            }
        });
        button_2.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.dinildavis09gmail.helpinghands.donsigninActivity");
                intent.putExtra("click","agent");

                startActivity(intent);

            }
        });
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.dinildavis09gmail.helpinghands.donsigninActivity");
                intent.putExtra("click","donor");

                startActivity(intent);

            }
        });
    }}











    /*public void OnClickButtonListner() {
        button_1 = (Button) findViewById(R.id.id_guest);
        button_1.setOnClickListener((v) -> {
            Intent intent = new Intent("com.dinildavis09gmail.helpinghands.guestpageActivity");

            startActivity(intent);

        });
    }
            public void OnClickButtonListner2() {
                button_2 = (Button) findViewById(R.id.id_donor);
                button_2.setOnClickListener((v) -> {
                    Intent intent = new Intent("com.dinildavis09gmail.helpinghands.guestpageActivity");

                    startActivity(intent);
                });
            }

                public void OnClickButtonListner3() {
                button_3=(Button)findViewById(R.id.id_agent);
                button_3.setOnClickListener((v)-> {
                    Intent intent=new Intent("com.dinildavis09gmail.helpinghands.guestpageActivity");

                    startActivity(intent);
                });

            }}

*/