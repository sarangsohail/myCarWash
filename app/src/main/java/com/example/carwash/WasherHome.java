package com.example.carwash;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.carwash.utils.BottomNavigationHelper;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class WasherHome extends AppCompatActivity {

    public static final String TAG = "WasherHomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washer_account);

        setupBottomNavigation();
    }

    public void setupBottomNavigation(){
        Log.d(TAG, "setupBottomNavigationView: Setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationHelper.enableNavigation(WasherHome.this, bottomNavigationViewEx);
    }

}
