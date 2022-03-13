package com.example.appathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class Login extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText  regPassword ,regEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        regPassword=findViewById(R.id.lpass);
        regEmail=findViewById(R.id.lemail);
        mAuth = FirebaseAuth.getInstance();
    }

    public void goToMainScreen(View view) {
        Intent intent = new Intent(Login.this,MainActivity.class);
        startActivity(intent);
    }

    public void goToOTP(View view) {
        Intent intent = new Intent(Login.this,OTP.class);
        startActivity(intent);
    }
    public void goToSignUp(View view){
        Intent intent = new Intent(Login.this,signUp.class);
        startActivity(intent);
    }

    public void logUser(View view) {
        loginUser();
        
    }

    private void loginUser() {
        String email = regEmail.getText().toString();
        String password = regPassword.getText().toString();

        if(TextUtils.isEmpty(email)){
            regEmail.setError("Email required");
            regEmail.requestFocus();
        }else if (TextUtils.isEmpty(password)) {
            regPassword.setError("Password Error");
            regPassword.requestFocus();
        }
        else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Login.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this, MainActivity.class));
                    }else{
                        Toast.makeText(Login.this, "Log in Error: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        }

    public void goToForgotPassword(View view) {
        startActivity(new Intent(Login.this,ForgotPassword.class));
    }
}