package com.leo.sleep;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.leo.fragment.RecordFragment;
import com.leo.fragment.SleepFragment;
import com.leo.fragment.TabFragmentPaperAdapter;
import com.leo.fragment.UserFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,ViewPager.OnPageChangeListener{
    private LinearLayout tab_menu_sleep_ly;
    private TextView tab_menu_sleep;
    private TextView tab_menu_sleep_num;
    private LinearLayout tab_menu_record_ly;
    private TextView tab_menu_record;
    private TextView tab_menu_record_num;
    private LinearLayout tab_menu_user_ly;
    private TextView tab_menu_user;
    private TextView tab_menu_user_num;
    private TabFragmentPaperAdapter mAdapter;
    private ViewPager viewPager;
    private List<Fragment> tabList;

    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setSelected();
        //选中第一个
        tab_menu_sleep.setSelected(true);
        //取得一个adapter
        mAdapter = new TabFragmentPaperAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);
        viewPager.setCurrentItem(PAGE_ONE);
        viewPager.addOnPageChangeListener(this);

    }

    /**
     * 绑定点击事件
     */
    void bindViews() {
        tab_menu_sleep_ly = (LinearLayout) findViewById(R.id.tab_menu_sleep_ly);
        tab_menu_sleep = (TextView) findViewById(R.id.tab_menu_sleep);
        tab_menu_sleep_num = (TextView) findViewById(R.id.tab_menu_sleep_num);

        tab_menu_record_ly = (LinearLayout) findViewById(R.id.tab_menu_record_ly);
        tab_menu_record = (TextView) findViewById(R.id.tab_menu_record);
        tab_menu_record_num = (TextView) findViewById(R.id.tab_menu_record_num);

        tab_menu_user_ly = (LinearLayout) findViewById(R.id.tab_menu_user_ly);
        tab_menu_user = (TextView) findViewById(R.id.tab_menu_user);
        tab_menu_user_num = (TextView) findViewById(R.id.tab_menu_user_num);

        tab_menu_sleep_ly.setOnClickListener(this);
        tab_menu_record_ly.setOnClickListener(this);
        tab_menu_user_ly.setOnClickListener(this);

        viewPager = (ViewPager) findViewById(R.id.tab_menu_contend_vp);
    }

    /**
     * 对点击事件处理
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        Log.i("click", "clicked");
        Log.i("click", "" + v.getId());
        setSelected();
        switch (v.getId()) {
            case R.id.tab_menu_sleep_ly:
                viewPager.setCurrentItem(PAGE_ONE);
                Log.i("click", "sleep");
                tab_menu_sleep.setSelected(true);
                tab_menu_sleep_num.setVisibility(View.VISIBLE);
                break;
            case R.id.tab_menu_record_ly:
                Log.i("click", "record");
                viewPager.setCurrentItem(PAGE_TWO);
                tab_menu_record.setSelected(true);
                tab_menu_record_num.setVisibility(View.VISIBLE);
                break;
            case R.id.tab_menu_user_ly:
                Log.i("click", "user");
                viewPager.setCurrentItem(PAGE_THREE);
                tab_menu_user.setSelected(true);
                tab_menu_user_num.setVisibility(View.VISIBLE);
                break;
        }

    }

    /**
     * 设置为隐藏
     */
    void setSelected() {
        tab_menu_sleep.setSelected(false);
        tab_menu_sleep_num.setVisibility(View.GONE);
        tab_menu_record.setSelected(false);
        tab_menu_record_num.setVisibility(View.GONE);
        tab_menu_user.setSelected(false);
        tab_menu_user_num.setVisibility(View.GONE);


    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.i("onPageScrolled","position:"+position+"/"+"positionOffset:"+positionOffset+"/"
       +"positionOffsetPixels"+positionOffsetPixels );
    }

    @Override
    public void onPageSelected(int position) {
        Log.i("onPageSelected",""+position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        Log.i("state",""+state);
        if(state==2){
            setSelected();
            switch (viewPager.getCurrentItem()){
                case PAGE_ONE:
                    tab_menu_sleep.setSelected(true);
                    tab_menu_sleep_num.setVisibility(View.VISIBLE);
                    break;
                case PAGE_TWO:
                    tab_menu_record.setSelected(true);
                    tab_menu_record_num.setVisibility(View.VISIBLE);
                    break;
                case PAGE_THREE:
                    tab_menu_user.setSelected(true);
                    tab_menu_user_num.setVisibility(View.VISIBLE);
                    break;
            }
        }
    }
}
