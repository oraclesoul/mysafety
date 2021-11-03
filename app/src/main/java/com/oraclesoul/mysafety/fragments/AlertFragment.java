package com.oraclesoul.mysafety.fragments;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.oraclesoul.mysafety.MainActivity;
import com.oraclesoul.mysafety.R;

import java.util.List;

public class AlertFragment extends Fragment implements LocationListener {


    public AlertFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alert, container, false);

        Button alertbtn =view.findViewById(R.id.alertbtn);
        alertbtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public void onClick(View viewwithbtn) {


                if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
//                    Toast.makeText(getContext() ,"Alert Sended", Toast.LENGTH_SHORT).show();

                    SmsManager smsManager = SmsManager.getDefault();
//                    smsManager.sendTextMessage("7056228038",null,"hello",null,null);

                    LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,1, AlertFragment.this);
                    
                }else
                {
                    Toast.makeText(getContext() ,"Permission Required", Toast.LENGTH_SHORT).show();
                }



            }
        });
        return view;
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        Toast.makeText(getActivity(), "on location", Toast.LENGTH_SHORT).show();

        double lat = location.getLatitude();
        double lon = location.getLongitude();
        String mymessage = "hey my location is " + lat + " " + lon ;
//        String uri = "http://maps.google.com/maps?saddr=" +lat+","+lon;
        String uri = "https://www.google.com/maps/?q=" + lat + "," +lon ;
        Toast.makeText(getActivity(), uri, Toast.LENGTH_SHORT).show();
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("7056228038",null,uri,null,null);


    }

    @Override
    public void onLocationChanged(@NonNull List<Location> locations) {

    }

    @Override
    public void onFlushComplete(int requestCode) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }
}