package com.hacslunar.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SkillIQAdapter extends RecyclerView.Adapter<SkillIQAdapter.LearnerSkillIQHolder> {
    Context mContext;
    ArrayList<LeaderboardSkillIQ> mLeaderboardSkillIQsArrayList;

    public SkillIQAdapter(Context context, ArrayList<LeaderboardSkillIQ> pLeaderboardSkillIQArrayList) {
        this.mContext = context;
        this.mLeaderboardSkillIQsArrayList = pLeaderboardSkillIQArrayList;
    }

    public static class LearnerSkillIQHolder extends RecyclerView.ViewHolder {
        TextView txtView_name;
        TextView txtView_country;
        TextView txtView_SkillIQ_scored;
        ImageView imgView_badge_SkillIQs;

        public LearnerSkillIQHolder(@NonNull View itemView) {
            super(itemView);
            txtView_name = itemView.findViewById(R.id.textView_name);
            txtView_country = itemView.findViewById(R.id.textView_country);
            txtView_SkillIQ_scored = itemView.findViewById(R.id.text_Learning_hours_skill_IQ);
            imgView_badge_SkillIQs = itemView.findViewById(R.id.image_Learning_hours_skill_IQ);
        }
    }

    @NonNull
    @Override
    public LearnerSkillIQHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.learner_item, parent, false);
        return new LearnerSkillIQHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull LearnerSkillIQHolder holder, int position) {
        LeaderboardSkillIQ lv_leaderboardSkillIQ = mLeaderboardSkillIQsArrayList.get(position);
        String skillIQText = lv_leaderboardSkillIQ.getIQScore() + mContext.getString(R.string.score_display_formatting);

        holder.txtView_name.setText(lv_leaderboardSkillIQ.getName());
        holder.txtView_country.setText(lv_leaderboardSkillIQ.getCountry());
        holder.txtView_SkillIQ_scored.setText(skillIQText);
        Picasso.get().load(lv_leaderboardSkillIQ.getIQBadgeURL()).into(holder.imgView_badge_SkillIQs);
    }

    @Override
    public int getItemCount() {
        return mLeaderboardSkillIQsArrayList.size();
    }
}