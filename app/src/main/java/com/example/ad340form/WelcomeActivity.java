package com.example.ad340form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    TextView welcomeMessage;
    String firstname;
    String lastname;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomeMessage=findViewById(R.id.welcome_message);

        firstname=getIntent().getExtras().getString(Constants.firstname_KEY);
        lastname=getIntent().getExtras().getString(Constants.lastname_KEY);
        email=getIntent().getExtras().getString(Constants.email_KEY);
        welcomeMessage.setText("Thanks for Signing Up " + firstname +" "+ lastname);
    }
    public void onBackClick(View view) {
        finish();
    }


}