package com.leo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**基类
 * Created by Administrator on 2016/8/27.
 */
public abstract class LazyFragment extends Fragment {
    //用于加载控件
    private View rootView;
    //用于findviewbyid
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView=inflater.inflate(getLayoutId(),container,false);
        unbinder= ButterKnife.bind(this,rootView);
        initViews();
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    protected abstract int getLayoutId();

    public abstract void initViews();

}
