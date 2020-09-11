package com.hacslunar.leaderboard;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class LearningHours {
    @SerializedName("name")
    private String name;
    @SerializedName("country")
    private String country;
    @SerializedName("hours")
    private String hours;
    @SerializedName("badgeUrl")
    private String hoursBadgeURL;

    public LearningHours(String name, String country, String hours, String hoursBadgeURL) {
        this.name = name;
        this.country = country;
        this.hours = hours;
        this.hoursBadgeURL = hoursBadgeURL;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getHours() {
        return hours;
    }

    public String getHoursBadgeURL() {
        return hoursBadgeURL;
    }

    @NonNull
    @Override
    public String toString() {
        return "LearnerHours{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", hours='" + hours + '\'' +
                ", hoursBadgeURL='" + hoursBadgeURL + '\'' +
                '}';
    }
}