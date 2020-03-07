package com.supremesir.score_java;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import static com.supremesir.score_java.MainActivity.KEY_SHP;

/**
 * @author HaoFan Fang
 * @date 2020/3/7 14:38
 */

public class MyData {
    public int number;

    // 定义一个Context域
    private Context context;

    //传递
    public MyData(Context context) {
        this.context = context;
    }

    public void save() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MY_DATA", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_SHP, number);
        editor.apply();
    }

    public int load() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MY_DATA", Context.MODE_PRIVATE);
        int temp = sharedPreferences.getInt(KEY_SHP, 0);
        number = temp;
        Log.d(KEY_SHP, "My Data SharedPreferences Value is : " + temp);
        return temp;
    }

}
