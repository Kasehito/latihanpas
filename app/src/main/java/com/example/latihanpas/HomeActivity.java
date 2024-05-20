package com.example.latihanpas;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.latihanpas.Fragment.Menu1Fragment;
import com.example.latihanpas.Fragment.Menu2Fragment;
import com.example.latihanpas.Fragment.Menu3Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnItemSelectedListener(navListener);

        // Load the default fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, new Menu1Fragment())
                .commit();
    }

    private BottomNavigationView.OnItemSelectedListener navListener =
            new BottomNavigationView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    if (item.getItemId() == R.id.list1) {
                        selectedFragment = new Menu1Fragment();
                    } else if (item.getItemId() == R.id.list2) {
                        selectedFragment = new Menu2Fragment();
                    } else if (item.getItemId() == R.id.list3) {
                        selectedFragment = new Menu3Fragment();
                    }

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frameLayout, selectedFragment)
                            .commit();

                    return true;
                }
            };
}