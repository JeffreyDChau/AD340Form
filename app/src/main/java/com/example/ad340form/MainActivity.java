package com.example.ad340form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button WelcomeScreenButton;
    EditText firstNameField;
    String firstName;
    EditText lastNameField;
    String lastName;
    EditText emailField;
    String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        WelcomeScreenButton = (Button) findViewById(R.id.submitButton);
        firstNameField = findViewById(R.id.firstName);
        lastNameField = findViewById(R.id.lastName);
        emailField = findViewById(R.id.email);

        WelcomeScreenButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               firstName=firstNameField.getText().toString();
               lastName=lastNameField.getText().toString();
               email=emailField.getText().toString();

               if (firstName.equals("") || lastName.equals("") || email.equals("")) {
                   // empty strings are not valid form input show a Toast to the user
                   Toast.makeText(getApplicationContext(), getString(R.string.null_error),
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