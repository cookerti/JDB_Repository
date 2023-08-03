package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.fragment.fragment.VpFragment;
import com.google.android.material.navigation.NavigationView;

public class DrawerActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    ActionBarDrawerToggle mdrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navi_view);
        setSupportActionBar(toolbar);
        sethomePager();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.item_home){
                    VpFragment fragment = VpFragment.newInstance("首页","");
                    getSupportFragmentManager().beginTransaction().replace(R.id.fcv_drawer,fragment).commit();
                }
                else if(item.getItemId() == R.id.item_my){
                    VpFragment fragment = VpFragment.newInstance("我的","");
                    getSupportFragmentManager().beginTransaction().replace(R.id.fcv_drawer,fragment).commit();
                }
                else if(item.getItemId() == R.id.item_find){
                    VpFragment fragment = VpFragment.newInstance("发现","");
                    getSupportFragmentManager().beginTransaction().replace(R.id.fcv_drawer,fragment).commit();
                }
                return true;
            }
        });
        mdrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(mdrawerToggle);
        mdrawerToggle.syncState();

    }

    private void sethomePager() {
        VpFragment fragment = VpFragment.newInstance("首页","");
        getSupportFragmentManager().beginTransaction().replace(R.id.fcv_drawer,fragment).commit();
        navigationView.setCheckedItem(R.id.item_home);
    }

}