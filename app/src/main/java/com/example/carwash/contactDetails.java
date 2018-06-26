package com.example.carwash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class contactDetails extends Fragment {

    private static final String TAG = "Contact Details Fragment";


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.contactdetails, container, false);
        return view;
    }
}
