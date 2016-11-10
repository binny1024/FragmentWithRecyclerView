package com.xiu.fragmentwithrecyclerview.activity;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiu.fragmentwithrecyclerview.R;
import com.xiu.fragmentwithrecyclerview.fragment.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity {
    private RecyclerViewFragment fragment;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addFragment();
    }

    private void addFragment() {
        fragment = new RecyclerViewFragment();
        fm = getFragmentManager();
        fm.beginTransaction().add(R.id.fragment,fragment).commit();
    }
}
