package com.example.mehed.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {

    EditText Email, Password;
    FirebaseAuth auth;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        Email = findViewById(R.id.etEail);
        Password = findViewById(R.id.etPassword);
        auth=FirebaseAuth.getInstance();
    }

    public void LogIn(View view) {
        auth.signInWithEmailAndPassword(Email.getText().toString(),Password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent=new Intent(LogInActivity.this,RegistrationActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LogInActivity.this," "+task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
