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

    public final static String KEY_SHP  = "MY_DATA";

    ScoreViewModel scoreViewModel;
    ActivityMainBinding binding;
    MyData myData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        scoreViewModel =  new ViewModelProvider(this).get(ScoreViewModel.class);
        // 使用ViewModel SavedState，采用新的构造方法来创建ViewModel对象
        scoreViewModel =  new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(),this)).get(ScoreViewModel.class);
        binding.setData(scoreViewModel);
        binding.setLifecycleOwner(this);

        // 不要传入this，会导致内存泄漏
        // ApplicationContext，可以理解为指向app的顶级引用
        // 若app存在，他则存在，且只有一个 -> Singleton
        myData = new MyData(getApplicationContext());
        myData.number = 400;
        myData.save();
        int number = myData.load();
        Log.d(KEY_SHP, "number load is : " + number);

////        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
//        SharedPreferences sharedPreferences = getSharedPreferences("MY_DATA", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt(KEY_SHP, 2000);
//        // 使用异步的apply而不是commit，保证并发操作数据安全
////        editor.commit();
//        editor.apply();
//        int temp = sharedPreferences.getInt(KEY_SHP, 0);
//        Log.d(KEY_SHP, "SharedPreferences Value is : " + temp);
    }
}
