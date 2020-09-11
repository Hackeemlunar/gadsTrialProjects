package com.hacslunar.leaderboard;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

//Mirrors LeaderBoardActivity implementation.
public class SubmissionActivity extends AppCompatActivity {
    private SubmissionPageFragment mProjectSubmission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), 0);
        ViewPager viewPager = findViewById(R.id.view_pager);
        sectionsPagerAdapter.addFragment(mProjectSubmission,
                getString(R.string.page_name));
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout lv_tabLayout = findViewById(R.id.tabs);
        lv_tabLayout.setupWithViewPager(viewPager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private static class SectionsPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTitle = new ArrayList<>();

        private SectionsPagerAdapter(FragmentManager fm, int behaviour) {
            super(fm, behaviour);
        }

        private void addFragment(Fragment fragment, String title){
            fragments.add(fragment);
            fragmentTitle.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return SubmissionPageFragment.newInstance(position);
            }

        @NonNull
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            return super.instantiateItem(container, position);
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