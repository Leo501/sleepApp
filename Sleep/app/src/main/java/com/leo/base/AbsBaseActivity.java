package com.leo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**设置为Abstract基类
 * Created by Administrator on 2016/8/25.
 */
public abstract class AbsBaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        ButterKnife.bind(this);
        initViews(savedInstanceState);
        initToolBar();
    }

    protected abstract int setLayoutId();
    protected abstract void initViews(Bundle savedInstanceState);
    protected abstract void initToolBar();
}
