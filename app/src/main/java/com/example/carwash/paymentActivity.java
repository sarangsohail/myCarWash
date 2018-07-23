package com.example.carwash;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class paymentActivity extends Fragment {

    private static final String TAG = "Contact Details Fragment";


    private ProgressBar progressBar;
    private ImageButton paymentIB;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.payment_tab, container, false);
        //progress bar
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        //paypal image button
        paymentIB = (ImageButton) view.findViewById(R.id.paymentIB);
        paymentIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String url = "https://www.paypal.com/uk/home";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                progressBar.setVisibility(View.INVISIBLE);
            }

        });

        return view;
    }
}

