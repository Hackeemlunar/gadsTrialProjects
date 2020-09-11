package com.hacslunar.leaderboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class LeaderBoardActivity extends AppCompatActivity {
    private LearningHoursFragment mLearningHoursFragment;
    private SkillIQFragment mSkillIQFragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), 0);
        ViewPager viewPager = findViewById(R.id.view_pager);
        //Set the number of pages you want and their titles with addFragment in the SectionsPagerAdapter class.
        //It also determines what order to display pages, that is FIFO.
        sectionsPagerAdapter.addFragment(mLearningHoursFragment, getString(R.string.learning_leaders));
        sectionsPagerAdapter.addFragment(mSkillIQFragment, getString(R.string.skill_iq_leaders));

        //Actually assemble the pages(tabs) into a usable group.
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        //This button takes you to the SubmissionActivity Page in another Activity.
        Button button = findViewById(R.id.submit_button_icon);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(LeaderBoardActivity.this, SubmissionActivity.class);
            startActivity(intent);
        });
    }

    //This handles the Tab layout pages
    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTitle = new ArrayList<>();

        private SectionsPagerAdapter(FragmentManager fm, int behaviour) {
            super(fm, behaviour);
        }

        private void addFragment(Fragment fragment, String title){
            fragments.add(fragment);
            fragmentTitle.add(title);
        }

        //Handles fetching the pages from the outer class instructions.
        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return LearningHoursFragment.newInstance(position);
                case 1:
                return SkillIQFragment.newInstance(position);
                default:
                    return new Fragment();
            }
        }

        //Actually makes the instances, must be in the same order as the getItem method.
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            Fragment createdFragment = (Fragment) super.instantiateItem(container, position);
            switch (position) {
                case 0:
                    mLearningHoursFragment = (LearningHoursFragment) createdFragment;
                    break;
                case 1:
                    mSkillIQFragment = (SkillIQFragment) createdFragment;
            }
            return createdFragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}