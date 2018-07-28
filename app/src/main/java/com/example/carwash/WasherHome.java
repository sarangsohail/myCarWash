package com.example.carwash;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.carwash.utils.BottomNavigationHelper;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class WasherHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washer_account);

        //todo  - sort out the bottom navigation problem
        //setupBottomNavigation();
    }

    public void setupBottomNavigation(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationHelper.enableNavigation(WasherHome.this, bottomNavigationViewEx);
    }

}
