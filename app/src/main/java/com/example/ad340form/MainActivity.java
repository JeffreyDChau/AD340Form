package com.example.ad340form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.Period;

public class MainActivity extends AppCompatActivity {

    private Button WelcomeScreenButton;
    EditText firstNameField;
    String firstName;
    EditText lastNameField;
    String lastName;
    EditText emailField;
    String email;
    EditText birthdateField;
    String birthdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        WelcomeScreenButton = (Button) findViewById(R.id.submitButton);
        firstNameField = findViewById(R.id.firstName);
        lastNameField = findViewById(R.id.lastName);
        emailField = findViewById(R.id.email);
        birthdateField = findViewById(R.id.birthdate);
        WelcomeScreenButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               firstName=firstNameField.getText().toString();
               lastName=lastNameField.getText().toString();
               email=emailField.getText().toString();
               birthdate = birthdateField.getText().toString();
               String[] date = birthdate.split("/");
               if (firstName.equals("") || lastName.equals("") || email.equals("") || birthdate.equals("")) {
                   Toast.makeText(getApplicationContext(), getString(R.string.null_error),
                           Toast.LENGTH_LONG).show();
                   return;
               }
               if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                   Toast.makeText(getApplicationContext(), getString(R.string.email_address_error),
                           Toast.LENGTH_LONG).show();
                   return;
               }
               if(date.length !=3 || birthdate.length() !=10){
                   Toast.makeText(getApplicationContext(), getString(R.string.date_error),
                           Toast.LENGTH_LONG).show();
                   return;
               }

               int month = Integer.parseInt(date[0]);
               int day = Integer.parseInt(date[1]);
               int year = Integer.parseInt(date[2]);
               LocalDate currentDate = LocalDate.now();
               LocalDate dateOfBirth = LocalDate.of(year,month,day);
               int years = Period.between(dateOfBirth, currentDate).getYears();
               if (years < 18) {
                   Toast.makeText(getApplicationContext(), getString(R.string.eighteen_error),
                           Toast.LENGTH_LONG).show();
                   return;
               }

               Intent intent  = new Intent(MainActivity.this , WelcomeActivity.class);
               intent.putExtra( "firstName_KEY", firstName);
               intent.putExtra( "lastName_KEY", lastName);
               intent.putExtra( "email_KEY", email);
               startActivity(intent);
           }
       });
    }




}