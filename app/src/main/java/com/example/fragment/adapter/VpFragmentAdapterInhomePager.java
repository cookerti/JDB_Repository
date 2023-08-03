package com.example.fragment.adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class VpFragmentAdapterInhomePager extends FragmentStatePagerAdapter {
    private List<Fragment> list;
    private List<String> list_title;
    public VpFragmentAdapterInhomePager(@NonNull FragmentManager fm, List<Fragment> list, List<String> list_title) {
        super(fm);
        this.list = list;
        this.list_title = list_title;
        Log.d("JDB","listsize:"+list.size());
        Log.d("JDB","listtitlesize:"+list_title.size());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list_title.get(position);
    }
}
