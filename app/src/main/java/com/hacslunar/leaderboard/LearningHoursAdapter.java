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

public class LearningHoursAdapter extends RecyclerView.Adapter<LearningHoursAdapter.LearnerHourHolder> {
    Context mContext;
    ArrayList<LearningHours> mLearningHoursArrayList;

    public LearningHoursAdapter(Context context, ArrayList<LearningHours> learnerHourArrayList) {
        this.mContext = context;
        this.mLearningHoursArrayList = learnerHourArrayList;
    }

    public static class LearnerHourHolder extends RecyclerView.ViewHolder {
        TextView txtView_name;
        TextView txtView_country;
        TextView txtView_hours_learned;
        ImageView imgView_badge_hours;

        public LearnerHourHolder(@NonNull View itemView) {
            super(itemView);
            txtView_name = itemView.findViewById(R.id.textView_name);
            txtView_country = itemView.findViewById(R.id.textView_country);
            txtView_hours_learned = itemView.findViewById(R.id.text_Learning_hours_skill_IQ);
            imgView_badge_hours = itemView.findViewById(R.id.image_Learning_hours_skill_IQ);
        }
    }

    @NonNull
    @Override
    public LearnerHourHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.learner_item, parent, false);
        return new LearnerHourHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull LearnerHourHolder holder, int position) {
        LearningHours learnerHour = mLearningHoursArrayList.get(position);
        String hoursText = learnerHour.getHours() + mContext.getString(R.string.hours_display_formatting) ;

        holder.txtView_name.setText(learnerHour.getName());
        holder.txtView_country.setText(learnerHour.getCountry());
        holder.txtView_hours_learned.setText(hoursText);
        Picasso.get().load(learnerHour.getHoursBadgeURL()).into(holder.imgView_badge_hours);
    }

    @Override
    public int getItemCount() {
        return mLearningHoursArrayList.size();
    }
}