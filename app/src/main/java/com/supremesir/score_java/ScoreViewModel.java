package com.supremesir.score_java;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author HaoFan Fang
 * @date 2020/2/29 18:19
 */

public class ScoreViewModel extends ViewModel {

    private MutableLiveData<Integer> aTeamScore;
    private MutableLiveData<Integer> bTeamScore;
    private int aBack, bBack;

    public MutableLiveData<Integer> getaTeamScore() {
        if (aTeamScore == null) {
            aTeamScore = new MutableLiveData<>();
            aTeamScore.setValue(0);
        }
        return aTeamScore;
    }
    public MutableLiveData<Integer> getbTeamScore() {
        if (bTeamScore == null) {
            bTeamScore = new MutableLiveData<>();
            bTeamScore.setValue(0);
        }
        return bTeamScore;
    }

    public void addaTeamScore(int num) {
        aBack = aTeamScore.getValue();
        bBack = bTeamScore.getValue();
        aTeamScore.setValue(aTeamScore.getValue() + num);
    }

    public void addbTeamScore(int num) {
        aBack = aTeamScore.getValue();
        bBack = bTeamScore.getValue();
        bTeamScore.setValue(bTeamScore.getValue() + num);
    }

    public void reset() {
        aBack = aTeamScore.getValue();
        bBack = bTeamScore.getValue();
        aTeamScore.setValue(0);
        bTeamScore.setValue(0);
    }

    public void undo() {
        aTeamScore.setValue(aBack);
        bTeamScore.setValue(bBack);
    }

}
