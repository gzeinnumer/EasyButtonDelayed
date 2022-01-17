package com.gzeinnumer.ebd;

import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
}
