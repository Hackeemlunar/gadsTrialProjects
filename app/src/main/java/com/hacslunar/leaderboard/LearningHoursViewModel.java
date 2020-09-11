package com.hacslunar.leaderboard;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningHoursViewModel extends ViewModel {
    private MutableLiveData<ArrayList<LearningHours>> mLearnerHours;
    public LiveData<ArrayList<LearningHours>> getLearnerHours() {
        if (mLearnerHours == null) {
            mLearnerHours = new MutableLiveData<>();
            loadLearnerHourEntries();
        }
        return mLearnerHours;
    }

    private void loadLearnerHourEntries() {
        //Creates a list entries from the website.
        NetUtil apiUtility = NetworkUtil.getClient().create(NetUtil.class);
        Call<ArrayList<LearningHours>> fetch = apiUtility.getLearnersByHours();
        fetch.enqueue(new Callback<ArrayList<LearningHours>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<LearningHours>> call, @NonNull Response<ArrayList<LearningHours>> response) {
                ArrayList<LearningHours> mHours = response.body();

                mLearnerHours.setValue(mHours);
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<LearningHours>> call, @NonNull Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });
    }
}