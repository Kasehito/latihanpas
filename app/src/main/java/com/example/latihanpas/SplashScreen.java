package com.example.latihanpas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {

    private static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            // Do something after 5s = 5000ms
            // Get the SharedPreferences object
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

            // Retrieve the saved data
            String username = settings.getString("username", "No Username Found");

            if (username.equalsIgnoreCase("No Username Found")){
                // intent ke login
                Intent intent = new Intent(SplashScreen.this , MainActivity.class);
                startActivity(intent);
                finish();

            }else{
                // intent ke home
                Intent intent = new Intent(SplashScreen.this , HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);


    }
}