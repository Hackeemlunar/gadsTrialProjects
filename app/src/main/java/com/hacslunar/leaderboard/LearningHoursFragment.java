package com.hacslunar.leaderboard;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LearningHoursFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER_TAG = "section_number_1";

    public static LearningHoursFragment newInstance(int index) {
        LearningHoursFragment fragment = new LearningHoursFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER_TAG, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final Context currentContext;
        View root = inflater.inflate(R.layout.fragment_learner_hours, container, false);
        currentContext = container.getContext();
        final RecyclerView myRecycler = root.findViewById(R.id.section_label1);

        LearningHoursViewModel mPageViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new LearningHoursViewModel();
            }
        }).get(LearningHoursViewModel.class);

        mPageViewModel.getLearnerHours().observe(getViewLifecycleOwner(), learnerHours -> {
            RecyclerView.LayoutManager lv_linearLayoutManager = new LinearLayoutManager(currentContext);
            LearningHoursAdapter lv_hoursAdapter = new LearningHoursAdapter(currentContext, learnerHours);
            myRecycler.setLayoutManager(lv_linearLayoutManager);
            myRecycler.setAdapter(lv_hoursAdapter);
        });
        return root;
    }
}