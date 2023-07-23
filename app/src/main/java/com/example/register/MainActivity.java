package com.example.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.register.fragment.AddFragment;
import com.example.register.fragment.BoookMarkFragment;
import com.example.register.fragment.HomeFragment;
import com.example.register.fragment.ProofileFragment;
import com.example.register.fragment.SeatchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      bottomNavigationView = findViewById(R.id.nav_view);
      bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
      getSupportFragmentManager().beginTransaction().replace(R.id.flFragment,new HomeFragment()).commit();
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = item -> {

        Fragment selectedFragment = null;
        int itemId = item.getItemId();
        if (itemId == R.id.navigation_home) {
            selectedFragment = new HomeFragment();
        } else if (itemId == R.id.navigation_search) {
            selectedFragment = new SeatchFragment();
        } else if (itemId == R.id.navigation_add) {
            selectedFragment = new AddFragment();
        } else if (itemId == R.id.navigation_bookmark) {
            selectedFragment = new BoookMarkFragment();
        }else if (itemId == R.id.navigation_profile) {
            selectedFragment = new ProofileFragment();
        }
        // It will help to replace the
        // one fragment to other.
        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, selectedFragment).commit();
        }
        return true;
    };


}