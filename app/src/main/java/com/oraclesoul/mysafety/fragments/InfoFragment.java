package com.oraclesoul.mysafety.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.oraclesoul.mysafety.CustomAdapter;
import com.oraclesoul.mysafety.R;


public class InfoFragment extends Fragment {

    public InfoFragment() {

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_info, container, false);

        ListView tipslist = view.findViewById(R.id.tipslist);
        String[] safetytips = getResources().getStringArray(R.array.tips);

        int[] colors = {getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5),
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5)
                 };
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(),R.layout.listitem,safetytips);
        CustomAdapter customAdapter = new CustomAdapter(getContext(),safetytips,colors);
        tipslist.setAdapter(customAdapter);

        return view;
    }
}