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


    private Button BTNTest1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.contactdetails, container, false);

        BTNTest1 = (Button) view.findViewById(R.id.btnTEST1);

        final String toast = "testing works";
        BTNTest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Toast.makeText(getContext(), toast, Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
