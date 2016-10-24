package com.bwie.guowudemo01.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.List;

/**
 * Created by w8888 on 2016/10/24.
 */
public class PlateFragmentPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragment;
    public PlateFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragment) {
        super(fm);

        this.fragment=fragment;

    }

    @Override
    public Fragment getItem(int position) {
        return fragment.get(position);
    }

    @Override
    public int getCount() {
        return fragment.size();
    }
}
