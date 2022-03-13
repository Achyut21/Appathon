package com.example.appathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ws_1 extends AppCompatActivity {
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ws1);

        mAuth = FirebaseAuth.getInstance();
    }


    public void skipToSignUP(View view) {
        Intent intent = new Intent(ws_1.this,signUp.class);
        startActivity(intent);
    }

    public void goToNextWs(View view) {
        Intent intent = new Intent(ws_1.this,ws_2.class);
        startActivity(intent);
    }

    public void gotToLogin(View view) {
        Intent intent = new Intent(ws_1.this,Login.class);
        startActivity(intent);
    }
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            startActivity(new Intent(ws_1.this,MainActivity.class));
        }
    }
}