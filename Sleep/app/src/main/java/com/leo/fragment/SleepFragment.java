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
public class SleepFragment extends Fragment implements RadioGroup.OnCheckedChangeListener{
    private RadioGroup radioGroup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sleep,container,false);
        radioGroup=(RadioGroup)view.findViewById(R.id.sleep_mood_rg);

        radioGroup.setOnCheckedChangeListener(this);
        return view;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.sleep_mood_rb_1:

                Toast.makeText(getActivity().getApplicationContext(),"你选择了好心情",Toast.LENGTH_SHORT).show();
                break;
            case R.id.sleep_mood_rb_2:
                Toast.makeText(getActivity().getApplicationContext(),"你选择了坏心情",Toast.LENGTH_SHORT).show();
                break;
            case R.id.sleep_mood_rb_3:
                Toast.makeText(getActivity().getApplicationContext(),"你选择了没心情",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
