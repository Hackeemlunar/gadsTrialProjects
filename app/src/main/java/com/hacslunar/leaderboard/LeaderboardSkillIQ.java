package com.hacslunar.leaderboard;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class LeaderboardSkillIQ {
    @SerializedName("name")
    private String name;
    @SerializedName("country")
    private String country;
    @SerializedName("score")
    private String iQScore;
    @SerializedName("badgeUrl")
    private String iQBadgeURL;

    public LeaderboardSkillIQ(String name, String country, String iQScore, String iQBadgeURL) {
        this.name = name;
        this.country = country;
        this.iQScore = iQScore;
        this.iQBadgeURL = iQBadgeURL;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getIQScore() {
        return iQScore;
    }

    public String getIQBadgeURL() {
        return iQBadgeURL;
    }

    @NonNull
    @Override
    public String toString() {
        return "LearnerSkillIQ{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", iQScore='" + iQScore + '\'' +
                ", iQBadgeURL='" + iQBadgeURL + '\'' +
                '}';
    }
}