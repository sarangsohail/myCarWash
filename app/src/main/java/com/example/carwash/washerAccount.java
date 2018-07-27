package com.example.carwash;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.carwash.utils.BottomNavigationHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class washerAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washer_account);
    }


    public void setupBottomNavigation(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationHelper.setUpBottomNavigationView(bottomNavigationViewEx);
    }
}
