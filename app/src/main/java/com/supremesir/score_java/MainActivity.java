package com.supremesir.score_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.supremesir.score_java.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ScoreViewModel scoreViewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        scoreViewModel =  new ViewModelProvider(this).get(ScoreViewModel.class);
        binding.setData(scoreViewModel);
        binding.setLifecycleOwner(this);
    }
}
