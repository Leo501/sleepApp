package com.leo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leo.sleep.R;

/**
 * Created by Leo on 2016/5/15.
 */
public class UserFragment extends LazyFragment {

    public static UserFragment newInstance(){
        return new UserFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    public void initViews() {

    }
}
