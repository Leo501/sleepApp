package com.leo.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.leo.sleep.MainActivity;

/**
 * Created by Leo on 2016/5/15.
 */
public class TabFragmentPaperAdapter extends FragmentPagerAdapter {
    private final int PAPER_COUNT=3;
    private SleepFragment sleepFragment=null;
    private RecordFragment recordFragment=null;
    private UserFragment userFragment=null;
    public TabFragmentPaperAdapter(FragmentManager fm) {
        super(fm);
        sleepFragment=new SleepFragment();
        recordFragment=new RecordFragment();
        userFragment=new UserFragment();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position){
            case MainActivity.PAGE_ONE:
                fragment=sleepFragment;
                break;
            case MainActivity.PAGE_TWO:
                fragment=recordFragment;
                break;
            case MainActivity.PAGE_THREE:
                fragment=userFragment;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAPER_COUNT;
    }
}
