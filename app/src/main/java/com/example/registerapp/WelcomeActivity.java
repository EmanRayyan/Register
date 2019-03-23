package com.example.registerapp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    private TextView name;
    private TextView dob;
    private String nameString;
    private String lastString;
    private String dobString;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        name = findViewById(R.id.name_tv);
        dob = findViewById(R.id.date_tv);

        if(getIntent() != null){
            nameString = getIntent().getStringExtra("first_name");
            lastString = getIntent().getStringExtra("last_name");
            dobString = getIntent().getStringExtra("dob");
            name.setText(nameString+" "+lastString);
            dob.setText(dobString);
        }
    }
}
