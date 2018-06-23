package com.example.carwash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class serviceWash extends Fragment {

    private static final String TAG = "Contact Details Fragment";


    private Button BTNTest3;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.payment_tab, container, false);

        BTNTest3 = (Button) view.findViewById(R.id.btnTEST3);



        return view;
    }
}
