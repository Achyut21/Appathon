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

public class signUp extends AppCompatActivity {
    EditText regName , regPassword ,regEmail;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        regName=findViewById(R.id.lpass);
        regPassword=findViewById(R.id.regPassword);
        regEmail=findViewById(R.id.lemail);
        mAuth = FirebaseAuth.getInstance();


    }

    public void makeUser(View view) {
        createUser();
    }

    private void createUser() {
        String email = regEmail.getText().toString();
        String password = regPassword.getText().toString();

        if(TextUtils.isEmpty(email)){
            regEmail.setError("Email required");
            regEmail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            regPassword.setError("Password Error");
            regPassword.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(signUp.this, "User registered in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(signUp.this, MainActivity.class));
                    }else{
                        Toast.makeText(signUp.this, "Registration Error " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void gotToLogin(View view) {
        startActivity(new Intent(signUp.this,Login.class));
    }
}