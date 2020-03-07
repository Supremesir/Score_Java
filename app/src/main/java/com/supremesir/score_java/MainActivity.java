package com.supremesir.score_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.supremesir.score_java.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private final static String KEY_SHP  = "MY_DATA";

    ScoreViewModel scoreViewModel;
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        scoreViewModel =  new ViewModelProvider(this).get(ScoreViewModel.class);
        // 使用ViewModel SavedState，采用新的构造方法来创建ViewModel对象
        scoreViewModel =  new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(),this)).get(ScoreViewModel.class);
        binding.setData(scoreViewModel);
        binding.setLifecycleOwner(this);


//        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences sharedPreferences = getSharedPreferences("MY_DATA", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_SHP, 1000);
        // 使用异步的apply而不是commit，保证并发操作数据安全
//        editor.commit();
        editor.apply();
        int temp = sharedPreferences.getInt(KEY_SHP, 0);
        Log.d(KEY_SHP, "SharedPreferences Value is : " + temp);
    }
}
