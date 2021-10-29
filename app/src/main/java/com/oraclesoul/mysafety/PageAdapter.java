package com.oraclesoul.mysafety;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.oraclesoul.mysafety.fragments.DetailsFragment;
import com.oraclesoul.mysafety.fragments.EditDetailsFragment;
import com.oraclesoul.mysafety.fragments.InfoFragment;

public class PageAdapter extends FragmentStateAdapter {

    int tabCount = 3;

    public PageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0 : return new EditDetailsFragment();
            case 1 : return new DetailsFragment();
            case 2 : return  new InfoFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return tabCount;
    }
}
