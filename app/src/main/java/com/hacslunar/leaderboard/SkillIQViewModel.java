package com.hacslunar.leaderboard;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Response;

public class SkillIQViewModel extends ViewModel {
    private MutableLiveData<ArrayList<LeaderboardSkillIQ>> mLearnerSkillIQ;

    public LiveData<ArrayList<LeaderboardSkillIQ>> getLearnerSkillIQ() {
        if (mLearnerSkillIQ == null) {
            mLearnerSkillIQ = new MutableLiveData<>();
            loadLearnerSkillIQEntries();
        }
        return mLearnerSkillIQ;
    }

    private void loadLearnerSkillIQEntries() {

        NetUtil apiUtility = NetworkUtil.getClient().create(NetUtil.class);
        retrofit2.Call<ArrayList<LeaderboardSkillIQ>> fetch = apiUtility.getLearnersBySkillIQ();
        fetch.enqueue(new Callback<ArrayList<LeaderboardSkillIQ>>() {
            @Override
            public void onResponse(retrofit2.Call<ArrayList<LeaderboardSkillIQ>> call, Response<ArrayList<LeaderboardSkillIQ>> response) {
                ArrayList<LeaderboardSkillIQ> skillIQS = response.body();

                mLearnerSkillIQ.setValue(skillIQS);
            }

            @Override
            public void onFailure(retrofit2.Call<ArrayList<LeaderboardSkillIQ>> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });
    }
}