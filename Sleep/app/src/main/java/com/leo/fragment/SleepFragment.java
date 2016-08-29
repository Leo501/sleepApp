package com.leo.fragment;


import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.leo.sleep.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leo on 2016/5/14.
 */
public class SleepFragment extends LazyFragment{


    public static SleepFragment newInstance(){
        return new SleepFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sleep;
    }

    @Override
    public void initViews() {

    }
}
