package com.example.myfirstcalc.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myfirstcalc.R;
import com.example.myfirstcalc.domain.Operations;
import com.example.myfirstcalc.domain.Theme;
import com.example.myfirstcalc.storage.ThemeStorage;

import java.util.HashMap;
import java.util.Map;

public class SettingsActivity extends AppCompatActivity {

    public static final String ARG_THEME = "ARG_THEME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        View.OnClickListener themesClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Theme theme : Theme.values()) {
                    if (view.getId() == theme.getButton()) {
                        Intent data = new Intent();
                        data.putExtra(ARG_THEME, theme);
                        setResult(Activity.RESULT_OK, data);
                        finish();
                    }
                }
            }
        };
        findViewById(R.id.calc_button_theme).setOnClickListener(themesClickListener);
        findViewById(R.id.calc_button_theme1).setOnClickListener(themesClickListener);
        findViewById(R.id.calc_button_theme2).setOnClickListener(themesClickListener);
        findViewById(R.id.calc_button_theme3).setOnClickListener(themesClickListener);
    }
}
