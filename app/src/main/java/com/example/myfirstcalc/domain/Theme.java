package com.example.myfirstcalc.domain;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

import com.example.myfirstcalc.R;

public enum Theme {

    THEME_ONE(R.style.Theme_MyFirstCalc, "one", R.id.calc_button_theme),
    THEME_TWO(R.style.Theme_MyFirstCalc1, "two", R.id.calc_button_theme1),
    THEME_THREE(R.style.Theme_MyFirstCalc2, "three", R.id.calc_button_theme2),
    THEME_FOUR(R.style.Theme_MyFirstCalc3, "four", R.id.calc_button_theme3);

    @StyleRes
    private final int theme;
    private final String key;
    private final int button;

    Theme(int theme, String key, int button) {
        this.theme = theme;
        this.key = key;
        this.button = button;
    }

    public int getTheme() {
        return theme;
    }

    public int getButton() {
        return button;
    }

    public String getKey() {
        return key;
    }
}
