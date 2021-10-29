package com.oraclesoul.mysafety;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.oraclesoul.mysafety.fragments.AlertFragment;
import com.oraclesoul.mysafety.fragments.DetailsFragment;
import com.oraclesoul.mysafety.fragments.EditDetailsFragment;
import com.oraclesoul.mysafety.fragments.InfoFragment;

public class PageAdapter extends FragmentStateAdapter {

    int tabCount = 3;
    DBHelper dbHelper;
    public PageAdapter(@NonNull FragmentActivity fragmentActivity) {

        super(fragmentActivity);
        dbHelper = new DBHelper(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {


        boolean details = dbHelper.isDetailsSet();


        switch (position)
        {
            case 0 : if(details) return new AlertFragment();
                     return  new EditDetailsFragment();
            case 1 : if(details) return new DetailsFragment();
                     return new EditDetailsFragment();
            case 2 : return  new InfoFragment();
        }
        return new InfoFragment();
    }

    @Override
    public int getItemCount() {
        return tabCount;
    }
}
