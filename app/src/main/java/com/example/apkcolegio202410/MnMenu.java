package com.example.apkcolegio202410;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MnMenu extends AppCompatActivity {
    private TabLayout tabpadre;
    private ViewPager2 vPantalla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mn_menu);
        tabpadre = (TabLayout) findViewById(R.id.FrmMenu_TabMenu);
        vPantalla = (ViewPager2) findViewById(R.id.FrmMenu_VPantalla);

    }
}