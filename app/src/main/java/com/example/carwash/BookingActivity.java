package com.example.carwash;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class BookingActivity extends AppCompatActivity {

    private Button orderButton;

    private TextView emailTV;



    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        hideKeyboard(this);
        getSupportActionBar().setTitle("Welcome");
        orderButton = (Button) findViewById(R.id.orderButton);


        emailTV = (TextView) findViewById(R.id.welcomeTV);
        String nameFromIntent = getIntent().getStringExtra("EMAIL");
        emailTV.setText("Welcome, \n " + nameFromIntent);

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loadCustomerInformationActivity = new Intent(getApplicationContext(), OrderingActivity.class);
                startActivity(loadCustomerInformationActivity);
            }
        });
    }
    //when the BookingActivity is loaded, hide the keyboard
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }



// make that round  button ordering screen













}
