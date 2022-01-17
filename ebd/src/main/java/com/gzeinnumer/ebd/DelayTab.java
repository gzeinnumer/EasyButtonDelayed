package com.gzeinnumer.ebd;

import android.os.CountDownTimer;
import android.os.Handler;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class DelayTab implements TabLayout.OnTabSelectedListener{
    private TabLayout tabLayout;
    private CountDownTimer countDownTimer;
    private TabLayout.OnTabSelectedListener onTabSelectedListener;
    private int delay = 2000;

    public DelayTab(TabLayout tabLayout, TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.tabLayout = tabLayout;
        this.onTabSelectedListener = onTabSelectedListener;
    }

    public DelayTab(TabLayout tabLayout, TabLayout.OnTabSelectedListener onTabSelectedListener, int delay) {
        this.tabLayout = tabLayout;
        this.onTabSelectedListener = onTabSelectedListener;
        this.delay = delay;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            try {
                Objects.requireNonNull(tabLayout.getTabAt(i)).view.setEnabled(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        onTabSelectedListener.onTabSelected(tab);

        countDownTimer = new CountDownTimer(delay, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                for (int i = 0; i < tabLayout.getTabCount(); i++) {
                    try {
                        Objects.requireNonNull(tabLayout.getTabAt(i)).view.setEnabled(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        countDownTimer.start();
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        onTabSelectedListener.onTabUnselected(tab);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        onTabSelectedListener.onTabReselected(tab);
    }
}
