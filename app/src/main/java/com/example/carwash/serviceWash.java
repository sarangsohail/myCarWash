package com.example.carwash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class serviceWash extends Fragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.service_wash, container, false);

        //for the car size spinner/drop down menu
        Spinner spinner = (Spinner) view.findViewById(R.id.car_size_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.CarSize, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        CheckBox interiorCk =   view.findViewById(R.id.interiorWash_check);
        interiorCk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    TextView interiorPriceTV = (TextView) getView().findViewById(R.id.interiorWashPrice_tv);
                    interiorPriceTV.setVisibility(View.VISIBLE);
                }
                else{
                    TextView interiorPriceTV = (TextView) getView().findViewById(R.id.interiorWashPrice_tv);
                    interiorPriceTV.setVisibility(View.INVISIBLE);

                }
            }
        });
        CheckBox exteriorCk = view.findViewById(R.id.exteriorWash_check);
        exteriorCk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    TextView exteriorViewTv = (TextView) getView().findViewById(R.id.exteriorWashPrice_tv);
                    exteriorViewTv.setVisibility(View.VISIBLE);
                }
                else{
                    TextView exteriorViewTv = (TextView) getView().findViewById(R.id.exteriorWashPrice_tv);
                    exteriorViewTv.setVisibility(View.INVISIBLE);
                }
            }
        });
        CheckBox interior_exteriorWash  = view.findViewById(R.id.interior_exterior_wash);
        interior_exteriorWash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    TextView exteriorViewTv = (TextView) getView().findViewById(R.id.exteriorAndInteriorWashPrice_tv);
                    exteriorViewTv.setVisibility(View.VISIBLE);
                }
                else{
                    TextView exteriorViewTv = (TextView) getView().findViewById(R.id.exteriorAndInteriorWashPrice_tv);
                    exteriorViewTv.setVisibility(View.INVISIBLE);
                }
            }
        });

        return view;
    }

}
