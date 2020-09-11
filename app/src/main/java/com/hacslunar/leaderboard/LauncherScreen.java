package com.hacslunar.leaderboard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class LauncherScreen extends AppCompatActivity {
    private static final int SLASH_SCREEN = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LauncherScreen.this, LeaderBoardActivity.class);
                LauncherScreen.this.startActivity(intent);
                LauncherScreen.this.finish();
            }
        },SLASH_SCREEN);
    }
}