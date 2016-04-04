package com.dinildavis09gmail.helpinghands;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class image extends AppCompatActivity {
    private Button button_2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        button_2 = (Button) findViewById(R.id.button2);
        button_2.setOnClickListener(new View.OnClickListener()


        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.dinildavis09gmail.helpinghands.loginActivity");

                startActivity(intent);


            }
        });
        getSupportActionBar().hide();
    }
}
