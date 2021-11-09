package com.oraclesoul.mysafety.fragments;

import static android.content.Context.ACTIVITY_SERVICE;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.oraclesoul.mysafety.DBHelper;
import com.oraclesoul.mysafety.Detail;
import com.oraclesoul.mysafety.MainActivity;
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
        TextView tv1 = view.findViewById(R.id.displayusername);
        TextView tv2 = view.findViewById(R.id.displayphone);
         DBHelper dbHelper = new DBHelper(getContext());
         if(dbHelper.isDetailsSet())
         {
             Detail detail = dbHelper.getDetails();
             tv1.setText(detail.getName());
             tv2.setText(detail.getPhone());

         }else
         {
             tv1.setText("Username not set");
         }

        Button reset = view.findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION_CODES.KITKAT <= Build.VERSION.SDK_INT)
                {



                    Intent mStartActivity = new Intent(getContext(), MainActivity.class);
                   int mPendingIntentId = 123456;
                   PendingIntent mPendingIntent = PendingIntent.getActivity(getContext(), mPendingIntentId,    mStartActivity, PendingIntent.FLAG_CANCEL_CURRENT);
                   AlarmManager mgr = (AlarmManager)getContext().getSystemService(Context.ALARM_SERVICE);
                   mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 1, mPendingIntent);

//                    ((ActivityManager)getContext().getSystemService(ACTIVITY_SERVICE)).clearApplicationUserData(); // to reset user data
                    getContext().deleteDatabase("MySafety");
                    System.exit(0);
                }else
                {
                    Toast.makeText(getContext(), "Can't Reset data", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }


}