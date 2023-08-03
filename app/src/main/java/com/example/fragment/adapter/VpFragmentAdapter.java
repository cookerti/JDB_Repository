package com.example.fragment.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.fragment.fragment.VpFragment;

import java.util.List;

public class VpFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    public VpFragmentAdapter(@NonNull FragmentManager fm,List<Fragment> list_) {
        super(fm);
        list = list_;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list == null ? null : list.get(position);
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }
}
