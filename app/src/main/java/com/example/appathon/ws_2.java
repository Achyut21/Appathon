package com.example.appathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ws_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ws2);
    }
    public void skipToSignUP(View view) {
        Intent intent = new Intent(ws_2.this,signUp.class);
        startActivity(intent);
    }

    public void goToNextWs(View view) {
        Intent intent = new Intent(ws_2.this,ws_3.class);
        startActivity(intent);
    }

    public void gotToLogin(View view) {
        Intent intent = new Intent(ws_2.this,Login.class);
        startActivity(intent);
    }
}