package com.example.carwash;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.content.ContentValues.TAG;

public class FetchAddressTask extends AsyncTask {

    private Context mContext;

    FetchAddressTask(Context applicationContext){
        mContext = applicationContext;
    }
    @Override
    protected Object doInBackground(Object[] params) {

        Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());
        Location location = params[0];
        List<Address> addressList = null;
        String resultMessage = "";

        try {
            addressList = geocoder.getFromLocation(
                    location.getLatitude(),
                    location.getLongitude(),
                    1);
            if (addressList == null || addressList.size() == 0) {
                if (resultMessage.isEmpty()) {
                    resultMessage = mContext
                            .getString(R.string.no_address_found);
                    Log.e(TAG, resultMessage);
                }else{
                    //reverse geocding was successful
                    Address address = addressList.get(0);
                    ArrayList<String> addressParts = new ArrayList<>();

                    for (int i = 0; i <= address.getMaxAddressLineIndex(); i++) {
                        addressParts.add(address.getAddressLine(i));
                    }

                    resultMessage = TextUtils.join("\n", addressParts);
                }
            }
        } catch (IOException e) {
            // Catch invalid latitude or longitude values
            resultMessage = mContext
                    .getString(R.string.invalid_lat_long_used);
            Log.e(TAG, resultMessage + ". " +
                    "Latitude = " + location.getLatitude() +
                    ", Longitude = " +
                    location.getLongitude(), e);
        }

        return resultMessage;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }
}
