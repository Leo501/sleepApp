package com.leo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leo.sleep.R;

import java.util.zip.Inflater;

/**
 * Created by Leo on 2016/5/14.
 */
public class RecordFragment extends LazyFragment {

    public static RecordFragment newInstance(){
        return new RecordFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_record;
    }

    @Override
    public void initViews() {

    }
}
