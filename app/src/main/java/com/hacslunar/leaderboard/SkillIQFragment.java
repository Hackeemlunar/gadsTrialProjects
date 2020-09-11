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

import static com.google.gson.reflect.TypeToken.get;

public class SkillIQFragment extends Fragment {
    private static final String SECTION_NUMBER_TAG = "section_number_2";

    public static SkillIQFragment newInstance(int index) {
        SkillIQFragment fragment = new SkillIQFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(SECTION_NUMBER_TAG, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        //Get the RecyclerView and its Context out of the Fragment.
        final Context currentContext;
        View root = inflater.inflate(R.layout.fragment_learner_skill_i_q, container, false);
        currentContext = container.getContext();
        final RecyclerView myRecycler = root.findViewById(R.id.section_label2);

        //Get the data from View Model and relay to the Adapter for processing and set it using the context above.
        SkillIQViewModel mPageViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new SkillIQViewModel();
            }
        }).get(SkillIQViewModel.class);
        mPageViewModel.getLearnerSkillIQ().observe(getViewLifecycleOwner(), learnerSkillIQS -> {
            RecyclerView.LayoutManager lv_layoutManager = new LinearLayoutManager(currentContext);
            SkillIQAdapter lv_skillIQAdapter = new SkillIQAdapter(currentContext, learnerSkillIQS);
            myRecycler.setLayoutManager(lv_layoutManager);
            myRecycler.setAdapter(lv_skillIQAdapter);
        });
        return root;
    }
}