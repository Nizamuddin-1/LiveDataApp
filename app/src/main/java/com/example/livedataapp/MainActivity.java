package com.example.livedataapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.livedataapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
int counter =0;
MyViewModel viewModel;
ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this)
                .get(MyViewModel.class);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        mainBinding.setMyviewmodel(viewModel);
        viewModel.getCounter().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer counter) {
                mainBinding.textView2.setText(""+counter);
            }
        });
    }
}