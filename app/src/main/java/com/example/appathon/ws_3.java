package com.example.appathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ws_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ws3);
    }
    public void skipToSignUP(View view) {
        Intent intent = new Intent(ws_3.this,signUp.class);
        startActivity(intent);
    }

    public void goToNextWs(View view) {
        Intent intent = new Intent(ws_3.this,ws_4.class);
        startActivity(intent);
    }

    public void gotToLogin(View view) {
        Intent intent = new Intent(ws_3.this,Login.class);
        startActivity(intent);
    }
}