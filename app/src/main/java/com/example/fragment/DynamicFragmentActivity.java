package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.fragment.fragment.ExampleFragment;

public class DynamicFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);
        if(savedInstanceState == null){//避免重复添加fragment
            FragmentManager fragmentManager = getSupportFragmentManager();
            //利用事务
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            //第三个参数为bundle类型可以 传递参数
            fragmentTransaction.add(R.id.fcv, ExampleFragment.class,null);
            //优化，添加时可重新排序
            fragmentTransaction.setReorderingAllowed(true);
            fragmentTransaction.commit();
        }
    }
}