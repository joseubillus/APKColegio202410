package com.example.apkcolegio202410;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.apkcolegio202410.menu.PageTabPadre;
import com.google.android.material.tabs.TabLayout;

public class MnMenu extends AppCompatActivity {
    private TabLayout tabpadre;
    private ViewPager2 vPantalla;
    private PageTabPadre ADPPadre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mn_menu);
        tabpadre = (TabLayout) findViewById(R.id.FrmMenu_TabMenu);
        vPantalla = (ViewPager2) findViewById(R.id.FrmMenu_VPantalla);

        ADPPadre = new PageTabPadre(getSupportFragmentManager(),
                getLifecycle(),
                tabpadre.getTabCount());
        vPantalla.setAdapter(ADPPadre);

        tabpadre.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vPantalla.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }
}