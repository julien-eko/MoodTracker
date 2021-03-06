package com.darcos.julie.moodtracker.Model;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.darcos.julie.moodtracker.Controller.PageFragment;

public class PageAdapter extends FragmentPagerAdapter {

    // 1 - Array of colors that will be passed to PageFragment
    private int[] colors;

    // 2 - Default Constructor
    protected PageAdapter(FragmentManager mgr, int[] colors) {
        super(mgr);
        this.colors = colors;


    }

    @Override
    public int getCount() {
        return (5); // 3 - Number of page to show
    }

    @Override
    public Fragment getItem(int position) {
        // 4 - Page to return
        return (PageFragment.newInstance(position, this.colors[position]));
    }


}