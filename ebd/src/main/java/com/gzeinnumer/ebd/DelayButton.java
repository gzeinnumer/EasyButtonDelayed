package com.gzeinnumer.ebd;

import android.content.Context;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DelayButton implements View.OnClickListener {

    private View.OnClickListener onClickListener;
    private Button button;
    private int delay = 2000;
    private CountDownTimer countDownTimer;

    public DelayButton(Button button, View.OnClickListener onClickListener) {
        this.button = button;
        this.onClickListener = onClickListener;
    }

    public DelayButton(Button button, View.OnClickListener onClickListener, int delay) {
        this.button = button;
        this.onClickListener = onClickListener;
        this.delay = delay;
    }

    @Override
    public void onClick(View view) {
        if (!isTimeAutomatic(view.getContext())) {
            Toast.makeText(view.getContext(), "Tanggal dan waktu tidak valid, silahkan aktifkan \"Tanggal dan Waktu Otomatis\" serta \"Time Zone Otomatis\" ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!isTimeZoneAutomatic(view.getContext())) {
            Toast.makeText(view.getContext(), "Tanggal dan waktu tidak valid, silahkan aktifkan \"Tanggal dan Waktu Otomatis\" serta \"Time Zone Otomatis\" ", Toast.LENGTH_SHORT).show();
            return;
        }

        onClickListener.onClick(view);
        button.setEnabled(false);

        countDownTimer = new CountDownTimer(delay, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                button.setEnabled(true);
            }
        };
        countDownTimer.start();
    }

    private boolean isTimeAutomatic(Context c) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return Settings.Global.getInt(c.getContentResolver(), Settings.Global.AUTO_TIME, 0) == 1;
        } else {
            return android.provider.Settings.System.getInt(c.getContentResolver(), Settings.System.AUTO_TIME, 0) == 1;
        }
    }

    private boolean isTimeZoneAutomatic(Context c) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return Settings.Global.getInt(c.getContentResolver(), Settings.Global.AUTO_TIME_ZONE, 0) == 1;
        } else {
            return android.provider.Settings.System.getInt(c.getContentResolver(), Settings.System.AUTO_TIME_ZONE, 0) == 1;
        }
    }
}
