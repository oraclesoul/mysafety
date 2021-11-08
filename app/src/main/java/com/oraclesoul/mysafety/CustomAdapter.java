package com.oraclesoul.mysafety;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter<String> {
    Context context;
    String[] tips;
    int[] colors;

    public CustomAdapter(Context context, String[] tips, int[] colors)
    {
        super(context,R.layout.listitem,tips);
        this.context = context;
        this.colors = colors;
        this.tips = tips;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem,parent,false);
        }

        TextView tv  = convertView.findViewById(R.id.tip);
        tv.setText(tips[position]);


        tv.setBackgroundColor(colors[position]);
        return  convertView;

    }
}
