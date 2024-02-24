package com.example.apkcolegio202410.menu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PageTabPadre extends FragmentStateAdapter {
    private int numftab;
    public PageTabPadre(@NonNull FragmentManager fragmentManager,
                        @NonNull Lifecycle lifecycle,
                        int numtab) {
        super(fragmentManager, lifecycle);
        this.numftab = numtab;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new FragmeTabInicio();
            case 1: return new FragmeTabAsistencia();
            case 2: return new FragmeTabUsuario();
            default: return null;
        }
    }

    @Override
    public int getItemCount() {
        return numftab;
    }
}
