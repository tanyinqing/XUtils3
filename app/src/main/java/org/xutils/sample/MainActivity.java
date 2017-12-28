package org.xutils.sample;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
//import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;


@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    private FragmentManager fragmentManage;
    private FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentManage = getSupportFragmentManager();
        fragmentTransaction = fragmentManage.beginTransaction();
        HttpFragment httpFragment = new HttpFragment();
        fragmentTransaction.replace(R.id.fragment_layout, httpFragment, "httpFragment");
        fragmentTransaction.commit();

    }

    public void onClick(View view) {
        fragmentTransaction = fragmentManage.beginTransaction();
        switch (view.getId()) {
            case R.id.button1:
                HttpFragment httpFragment = new HttpFragment();
                fragmentTransaction.replace(R.id.fragment_layout, httpFragment, "httpFragment");
                break;
            case R.id.button2:
                DbFragment dbFragment = new DbFragment();
                fragmentTransaction.replace(R.id.fragment_layout, dbFragment, "dbFragment");
                break;
            case R.id.button3:
                ImageFragment imageFragment = new ImageFragment();
                fragmentTransaction.replace(R.id.fragment_layout, imageFragment, "imageFragment");
                break;
        }
        fragmentTransaction.commit();
    }


}
