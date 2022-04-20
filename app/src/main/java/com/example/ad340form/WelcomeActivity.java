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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomeMessage=findViewById(R.id.welcome_message);

        firstname=getIntent().getExtras().getString("firstName");
        welcomeMessage.setText("Thanks for Signing Up " + firstname);
    }


}