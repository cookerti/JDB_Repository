package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fragment.fragment.FragmentA;
import com.example.fragment.fragment.FragmentB;

public class DataPassBetweenFragments extends AppCompatActivity {
    private FragmentA fragmentA;
    private FragmentB fragmentB;

    public FragmentA getFragmentA() {
        return fragmentA;
    }

    public FragmentB getFragmentB() {
        return fragmentB;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_pass_between_fragments);
        fragmentA = new FragmentA();
        fragmentB = new FragmentB();
        getSupportFragmentManager().beginTransaction().replace(R.id.fcv_a,fragmentA).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fcv_b,fragmentB).commit();
    }
}