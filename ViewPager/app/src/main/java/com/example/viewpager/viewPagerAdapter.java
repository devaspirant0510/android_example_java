package com.example.viewpager;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class viewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> pager = new ArrayList<>();

    public viewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return pager.get(position);
    }
    @Override
    public int getCount() {
        return pager.size();
    }

    public void addItem(Fragment fragment){
        pager.add(fragment);

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }
}
