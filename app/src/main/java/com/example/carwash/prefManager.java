package com.example.carwash;

import android.content.Context;
import android.content.SharedPreferences;

public class prefManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    //the shared pref mode
    int PRIVATE_MODE = 0;

    public static final String PREF_NAME = "myWash-welcome";

    public static final String IS_FIRST_TIME_LAUNCH = "isFirstTimeLaunch";

    public prefManager(Context context){

        this.context = context;
        //variable name
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime){

        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }


}
