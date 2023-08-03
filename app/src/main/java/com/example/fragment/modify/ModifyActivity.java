package com.example.fragment.modify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.fragment.R;
import com.example.fragment.fragment.ExampleFragment;

public class ModifyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
    }

    public void addFragment(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fcv_modify, ExampleFragment.class,null,"myFragment")
                .commit();
    }

    public void addFragmentAndBackstack(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fcv_modify, ExampleFragment.class,null,"myFragment")
                .setReorderingAllowed(true)
                .addToBackStack("MyBackStack")
                .commit();
    }

    public void findFragmentById(int view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fcv_modify);
        if(fragment != null){
            Log.d("JDB",fragment.toString());
            Toast.makeText(this,"找到了",Toast.LENGTH_SHORT).show();

        }
    }

    public void findFragmentByTag(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag("myFragment");
        //找到的前提是添加的时候将tag加入进去，
        if(fragment != null){
            Log.d("JDB",fragment.toString());
            Toast.makeText(this,"找到了",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"没找到",Toast.LENGTH_SHORT).show();
        }
    }

    public void removeFragment(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag("myFragment");
        //找到的前提是添加的时候将tag加入进去，
        if(fragment != null){
            Log.d("JDB",fragment.toString());
            Toast.makeText(this,"找到了",Toast.LENGTH_SHORT).show();
            fragmentManager.beginTransaction().remove(fragment).commit();
        }
        else{
            Toast.makeText(this,"没找到",Toast.LENGTH_SHORT).show();
        }
    }

    public void replaceFragment(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
//        Bundle bundle = new Bundle();
//        bundle.putString("new_text","这是个新的");
//        Fragment fragment = new ExampleFragment();
//        fragment.setArguments(bundle);
        fragmentManager.beginTransaction().replace(R.id.fcv_modify, ExampleFragment.class,null).commit();

    }
    private DataChangeListener myListener;
    public void setDataChangeListener(DataChangeListener listener){
        this.myListener = listener;
    }

    public void passDataByinterface(View view) {
        if(myListener!= null)
            myListener.onDataChange("这是通过接口传递的消息");
    }

    //观察者
    public interface DataChangeListener{
        void onDataChange(String data);
    }

}