package com.hacslunar.leaderboard;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmitFormNetUtil {
    public static String BASE_URL = "https://docs.google.com/forms/d/e/";
    private static Retrofit retrofit;
    public static Retrofit sendResponse(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}