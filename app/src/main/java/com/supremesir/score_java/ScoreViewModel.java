package com.supremesir.score_java;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import java.security.Key;

/**
 * @author HaoFan Fang
 * @date 2020/2/29 18:19
 */

public class ScoreViewModel extends ViewModel {
//
//    //使用ViewModel SavedState来使得系统杀死后台进程的保存恢复数据
//    private MutableLiveData<Integer> aTeamScore;
//    private MutableLiveData<Integer> bTeamScore;
    private int aBack, bBack;
    private SavedStateHandle handle;

    private final static String KEY0 = "NUMBER_A";
    private final static String KEY1 = "NUMBER_B";

    /**
     * 使用ViewModel SavedState来构造，
     * 若传入的handle里不存在对应的KEY，则创建SavedStateHandle
     * @param handle SavedStateHandle
     */
    public ScoreViewModel(SavedStateHandle handle) {
        if (!handle.contains(KEY0)) {
            handle.set(KEY0, 0);
        }
        if (!handle.contains(KEY1)) {
            handle.set(KEY1, 0);
        }
        this.handle = handle;
    }

    public MutableLiveData<Integer> getaTeamScore() {
//        if (aTeamScore == null) {
//            aTeamScore = new MutableLiveData<>();
//            aTeamScore.setValue(0);
//        }
        return handle.getLiveData(KEY0);
    }
    public MutableLiveData<Integer> getbTeamScore() {
//        if (bTeamScore == null) {
//            bTeamScore = new MutableLiveData<>();
//            bTeamScore.setValue(0);
//        }
        return handle.getLiveData(KEY1);
    }

    public void addaTeamScore(int num) {
//        aBack = aTeamScore.getValue();
//        bBack = bTeamScore.getValue();
//        aTeamScore.setValue(aTeamScore.getValue() + num);
        aBack = (int) handle.get(KEY0);
        bBack = (int) handle.get(KEY1);
        handle.set(KEY0, (int) handle.get(KEY0) + num);
    }

    public void addbTeamScore(int num) {
//        aBack = aTeamScore.getValue();
//        bBack = bTeamScore.getValue();
//        bTeamScore.setValue(bTeamScore.getValue() + num);
        aBack = (int) handle.get(KEY0);
        bBack = (int) handle.get(KEY1);
        handle.set(KEY1, (int) handle.get(KEY1) + num);
    }

    public void reset() {
//        aBack = aTeamScore.getValue();
//        bBack = bTeamScore.getValue();
//        aTeamScore.setValue(0);
//        bTeamScore.setValue(0);
        aBack = (int) handle.get(KEY0);
        bBack = (int) handle.get(KEY1);
        handle.set(KEY0, 0);
        handle.set(KEY1, 0);
    }

    public void undo() {
//        aTeamScore.setValue(aBack);
//        bTeamScore.setValue(bBack);
        handle.set(KEY0, aBack);
        handle.set(KEY1, bBack);
    }

}
