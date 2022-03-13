package com.example.appathon;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.appathon.databinding.ActivityWs4Binding;

public class ws_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ws4);
    }
    public void skipToSignUP(View view) {
        Intent intent = new Intent(ws_4.this,signUp.class);
        startActivity(intent);
    }

    public void goToNextWs(View view) {
        Intent intent = new Intent(ws_4.this,Login.class);
        startActivity(intent);
    }

    public void gotToLogin(View view) {
        Intent intent = new Intent(ws_4.this,Login.class);
        startActivity(intent);
    }
}