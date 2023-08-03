package com.example.fragment.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragment.R;
import com.example.fragment.modify.ModifyActivity;


public class ExampleFragment extends Fragment {

    private TextView tv_show;
    private TextView tv_show1;
    private RadioButton bt_like;
    private RadioButton bt_dislike;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_static1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_show = view.findViewById(R.id.tv_show);
        bt_like = view.findViewById(R.id.bt_like);
        bt_dislike = view.findViewById(R.id.bt_dislike);
        tv_show1 = view.findViewById(R.id.tv_newshow);
        bt_like.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tv_show.setText("喜欢");
                }
            }
        });
        bt_dislike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tv_show.setText("不喜欢");
                }
            }
        });
        RatingBar ratingBar = view.findViewById(R.id.ratingBar1);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @SuppressLint("SuspiciousIndentation")
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(fromUser)
                Toast.makeText(getActivity(),"评分为："+rating,Toast.LENGTH_SHORT).show();
            }
        });
        Bundle bundle = getArguments();
        if(bundle != null){
            tv_show1.setText(bundle.getString("new_text","null"));
        }
        ((ModifyActivity)getActivity()).setDataChangeListener(new ModifyActivity.DataChangeListener() {
            @Override
            public void onDataChange(String data) {
                tv_show1.setText(data);
            }
        });
    }
}