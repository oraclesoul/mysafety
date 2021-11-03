package com.oraclesoul.mysafety.fragments;

import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.tabs.TabLayout;
import com.oraclesoul.mysafety.DBHelper;
import com.oraclesoul.mysafety.PageAdapter;
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
                String phone = phoneEt.getText().toString();

                DBHelper dbHelper = new DBHelper(getContext());
                dbHelper.insertData(username,phone);

                ViewPager2 viewPager2 = getActivity().findViewById(R.id.viewPager);
                int idx = viewPager2.getCurrentItem();
                Log.i("mylogs", "index is " + idx);

                PageAdapter pageAdapter = new PageAdapter(getActivity());
                viewPager2.setAdapter(pageAdapter);
                if(idx==0)
                {
                    viewPager2.setCurrentItem(0);
                }else
                {
                    viewPager2.setCurrentItem(1);
                }

            }
        });
        return view;
    }

}