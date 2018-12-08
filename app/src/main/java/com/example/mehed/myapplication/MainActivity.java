package com.example.mehed.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button LogIn, Registration;
    FirebaseAuth auth;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogIn = findViewById(R.id.btLogIn);
        Registration = findViewById(R.id.btRegistration);

        Registration.setOnClickListener(this);
        LogIn.setOnClickListener(this);

    }

    public void onClick(View v) {

        if (v.getId() == R.id.btRegistration) {
            Intent intent = new Intent(this, RegistrationActivity.class);
            startActivity(intent);
        }
            else if(v.getId()==R.id.btLogIn){
            Intent intent=new Intent(MainActivity.this,LogInActivity.class);
            startActivity(intent);

            }




    }
}

