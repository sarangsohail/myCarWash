package com.example.carwash.utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import com.example.carwash.NotificationsActivity;
import com.example.carwash.ProfileActivity;
import com.example.carwash.R;
import com.example.carwash.SearchActivity;
import com.example.carwash.WasherHome;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

//object class to make it easier to setup the bottom nav bar for all the separate profile views
public class BottomNavigationHelper {

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx) {
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx viewEx) {
        viewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.ic_house:
                        Intent intent1 = new Intent(context, WasherHome.class);
                        context.startActivity(intent1);
                        break;
                    case R.id.ic_alert:
                        Intent intent2 = new Intent(context, NotificationsActivity.class);
                        context.startActivity(intent2);
                        break;
                    case R.id.ic_search:
                        Intent intent3 = new Intent(context, SearchActivity.class);
                        context.startActivity(intent3);
                        break;
                    case R.id.ic_android:
                        Intent intent4 = new Intent(context, ProfileActivity.class);
                        context.startActivity(intent4);
                        break;

                }
                return false;
            }
        });
    }
}
