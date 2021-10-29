package com.oraclesoul.mysafety.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.oraclesoul.mysafety.DBHelper;
import com.oraclesoul.mysafety.R;

public class EditDetailsFragment extends Fragment {


    public EditDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_edit_details, container, false);
        Button btn = view.findViewById(R.id.saveData);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewbybutton) {
                EditText usernameEt = view.findViewById(R.id.displayusername);
                EditText phoneEt = view.findViewById(R.id.phone);

                String username = usernameEt.getText().toString();
                int phone = Integer.parseInt(phoneEt.getText().toString());

                DBHelper dbHelper = new DBHelper(getContext());
                dbHelper.insertData(username,phone);
            }
        });
        return view;
    }

}