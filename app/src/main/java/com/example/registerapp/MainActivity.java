package com.example.registerapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText firstName;
    private EditText lastName;
    private EditText dob;
    private Button register;
    private final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        dob = findViewById(R.id.date);
        register = findViewById(R.id.register);


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String StringFirstName = firstName.getText().toString();
                String StringLastName = lastName.getText().toString();
                String StringDate = dob.getText().toString();



                if(firstName != null && StringLastName != null) {


                    Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                    intent.putExtra("first_name", StringFirstName);
                    intent.putExtra("last_name", StringLastName);
                    intent.putExtra("dob", StringDate);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,"Fill The Empty Fields",Toast.LENGTH_LONG).show();

                }

            }
        });



    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dob.setText(sdf.format(myCalendar.getTime()));
    }
}
