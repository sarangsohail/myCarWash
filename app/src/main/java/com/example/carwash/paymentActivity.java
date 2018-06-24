package com.example.carwash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class paymentActivity extends Fragment {

    private static final String TAG = "Contact Details Fragment";


    private Button BTNTest2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.payment_tab, container, false);

        BTNTest2 = (Button) view.findViewById(R.id.btnTEST2);



        return view;
    }
}
