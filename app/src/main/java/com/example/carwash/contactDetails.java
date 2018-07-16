package com.example.carwash;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.ContextCompat;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.annotation.KeepForSdkWithFieldsAndMethods;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.w3c.dom.Text;

import static android.content.ContentValues.TAG;

public class contactDetails extends Fragment implements FetchAddressTask.OnTaskCompleted{

    private static final String TAG = "Contact-Details-Fragmnt";
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private static final float DEFAULT_ZOOM = 15f;

    private boolean mTrackingLocation;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private Boolean mLocationPermissionsGranted = false;
    LocationCallback mLocationCallback;



    double currentLAT = 0;
    double currentLOC = 0;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contactdetails, container, false);
        final Switch sw = (Switch) view.findViewById(R.id.locationSwitch);
        //todo : set number plate registration as all caps
        EditText registrationPlate = view.findViewById(R.id.numberPlate_et);
        registrationPlate.setAllCaps(true);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    getLocationPermission();
                    getDeviceLocation();
                }else if (!isChecked) {
                    EditText firstLineAddr = (EditText) getView().findViewById(R.id.first_line_address_et1);
                    EditText secondLineAddr = (EditText) getView().findViewById(R.id.secondline_address_town_et2);
                    EditText thirdLineAddr= (EditText) getView().findViewById(R.id.thirdLine_address_postcode_et3);

                    firstLineAddr.setText("");
                    secondLineAddr.setVisibility(View.VISIBLE);
                    thirdLineAddr.setVisibility(View.VISIBLE);
                }
            }
        });
        return view;
    }

    private void getDeviceLocation() {

        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getContext());

        try {
            if (mLocationPermissionsGranted) {

                 Task location = mFusedLocationProviderClient.getLastLocation();

                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                    if (task.isSuccessful()) {
                          Location currentLocation = (Location) task.getResult();

                        new FetchAddressTask(getActivity(), contactDetails.this).execute(currentLocation);
                                } else {
                                    Log.d(TAG, "onComplete: current location is not found/null");
                                                           Toast.makeText(getContext(), "unable to get current location", Toast.LENGTH_SHORT).show();
                    }
                    }
                                               }
                );
            }
        } catch (SecurityException e) {

            Log.e(TAG, "get device location : Security Exception " + e.getMessage());
        }

    }

    private void getLocationPermission() {
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};

        if (ContextCompat.checkSelfPermission(this.getContext(),
                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this.getContext(),
                    COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mLocationPermissionsGranted = true;
            } else {
                ActivityCompat.requestPermissions(getActivity(),
                        permissions,
                        LOCATION_PERMISSION_REQUEST_CODE);
            }
        } else {
            ActivityCompat.requestPermissions(getActivity(),
                    permissions,
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onTaskCompleted(String result) {
        EditText firstLineAddr = (EditText) getView().findViewById(R.id.first_line_address_et1);
        EditText secondLineAddr = (EditText) getView().findViewById(R.id.secondline_address_town_et2);
        EditText thirdLineAddr= (EditText) getView().findViewById(R.id.thirdLine_address_postcode_et3);

        firstLineAddr.setText(result);
        secondLineAddr.setVisibility(View.INVISIBLE);
        thirdLineAddr.setVisibility(View.INVISIBLE);
    }
}
