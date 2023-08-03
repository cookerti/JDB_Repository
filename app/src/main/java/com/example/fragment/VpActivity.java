package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.fragment.adapter.VpFragmentAdapter;
import com.example.fragment.fragment.VpFragment;
import com.example.fragment.fragment.VphomeFragment;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class VpActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<Fragment> list;
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp);
        list = new ArrayList<>();
        initData();
        initView();
    }

    private void initData() {
        VphomeFragment fragment1 = VphomeFragment.newInstance("首页","");
        list.add(fragment1);
        VpFragment fragment2 = VpFragment.newInstance("发现","");
        list.add(fragment2);
        VpFragment fragment3 = VpFragment.newInstance("我的","");
        list.add(fragment3);
    }

    private void initView() {
        viewPager = findViewById(R.id.vp_fragment);
        navigationView = findViewById(R.id.nav);
        VpFragmentAdapter adapter = new VpFragmentAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0)
                    navigationView.setSelectedItemId(R.id.item_home);
                else if(position == 1)
                    navigationView.setSelectedItemId(R.id.item_find);
                else if(position == 2)
                    navigationView.setSelectedItemId(R.id.item_my);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.item_home){
                    viewPager.setCurrentItem(0);
                }
                else if(item.getItemId() == R.id.item_find){
                    viewPager.setCurrentItem(1);
                }
                else if(item.getItemId() == R.id.item_my){
                    navigationView.removeBadge(R.id.item_my);
                    viewPager.setCurrentItem(2);
                }
                return true;
            }
        });
        BadgeDrawable badgeDrawable = navigationView.getOrCreateBadge(R.id.item_my);
        badgeDrawable.setNumber(1000);//设置数字
        badgeDrawable.setMaxCharacterCount(3);//设置最多显示几位数,3则会显示99+
    }
}