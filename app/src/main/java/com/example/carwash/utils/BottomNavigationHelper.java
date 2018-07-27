package com.example.carwash.utils;

import android.util.Log;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

//object class to make it easier to setup the bottom navbar for all the separate profile views
public class BottomNavigationHelper{

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }
}
