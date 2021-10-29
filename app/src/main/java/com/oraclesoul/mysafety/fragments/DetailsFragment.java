package com.oraclesoul.mysafety.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oraclesoul.mysafety.DBHelper;
import com.oraclesoul.mysafety.R;

public class DetailsFragment extends Fragment {


    public DetailsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_details, container, false);
        TextView tv = view.findViewById(R.id.displayusername);
         DBHelper dbHelper = new DBHelper(getContext());
         if(dbHelper.isDetailsSet())
         {
             tv.setText("User name set");
         }else
         {
             tv.setText("Username not set");
         }

        return view;
    }
}