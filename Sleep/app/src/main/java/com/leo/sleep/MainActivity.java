package com.leo.sleep;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.leo.base.AbsBaseActivity;
import com.leo.fragment.RecordFragment;
import com.leo.fragment.SleepFragment;
import com.leo.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends AbsBaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.main_bottom_navigation)
    AHBottomNavigation aHBottomNavigation;

    private int currentTabIndex;

    private List<Fragment> fragments=new ArrayList<>();
    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * 设置view
     * @param savedInstanceState
     */
    @Override
    protected void initViews(Bundle savedInstanceState) {
        fragments.add(SleepFragment.newInstance());
        fragments.add(RecordFragment.newInstance());
        fragments.add(UserFragment.newInstance());

        showFragment(fragments.get(0));
        initBottomNav();
    }

    private void initBottomNav() {
        AHBottomNavigationItem item1=new AHBottomNavigationItem("睡觉",R.mipmap.tab_sleep_normal,R.color.blue_500);
        AHBottomNavigationItem item2=new AHBottomNavigationItem("记录",R.mipmap.tab_record_normal,R.color.indigo_500);
        AHBottomNavigationItem item3=new AHBottomNavigationItem("我的",R.mipmap.tab_user_normal,R.color.deep_purple_500);

        aHBottomNavigation.addItem(item1);
        aHBottomNavigation.addItem(item2);
        aHBottomNavigation.addItem(item3);

        aHBottomNavigation.setDefaultBackgroundColor(Color.parseColor("#ffffff"));
        aHBottomNavigation.setBehaviorTranslationEnabled(false);

        aHBottomNavigation.setAccentColor(ContextCompat.getColor(getApplicationContext(),R.color.blue_500));
        aHBottomNavigation.setInactiveColor(ContextCompat.getColor(getApplicationContext(),R.color.blue_greg_500));

        aHBottomNavigation.setForceTint(true);

        aHBottomNavigation.setForceTitlesDisplay(true);
        aHBottomNavigation.setCurrentItem(0);
        aHBottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                if (currentTabIndex!=position){
                    FragmentTransaction trx=getSupportFragmentManager().beginTransaction();
                    trx.hide(fragments.get(currentTabIndex));
                    if (!fragments.get(position).isAdded()){
                        trx.add(R.id.main_content,fragments.get(position));
                    }
                    trx.show(fragments.get(position)).commit();
                }
                currentTabIndex=position;
                return true;
            }
        });

    }

    @Override
    protected void initToolBar() {
        toolbar.setTitle("Sleep");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.main_action_settings) {
            Toast.makeText(MainActivity.this, "关于我。。。。", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
    private void showFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content,fragment).commit();
    }

}
