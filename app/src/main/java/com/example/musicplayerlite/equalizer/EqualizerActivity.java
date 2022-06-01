package com.example.musicplayerlite.equalizer;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.musicplayerlite.MPPreferences;
import com.example.musicplayerlite.R;
import com.example.musicplayerlite.helper.ThemeHelper;
import com.bullhead.equalizer.EqualizerFragment;

public class EqualizerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(ThemeHelper.getTheme(MPPreferences.getTheme(getApplicationContext())));
        AppCompatDelegate.setDefaultNightMode(MPPreferences.getThemeMode(getApplicationContext()));
        setContentView(R.layout.activity_equalizer);

        int sessionId = getIntent().getIntExtra("session", -1);

        if (sessionId != -1) {
            EqualizerFragment equalizerFragment = EqualizerFragment.newBuilder()
                    .setAccentColor(ThemeHelper.resolveColorAttr(this, R.attr.colorPrimary))
                    .setAudioSessionId(sessionId)
                    .build();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.eqFrame, equalizerFragment)
                    .commit();
        } else {
            Toast.makeText(this, "Failed to launch", Toast.LENGTH_SHORT).show();
        }
    }
}