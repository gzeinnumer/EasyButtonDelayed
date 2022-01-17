package com.gzeinnumer.ebd;

import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class DelayButton implements View.OnClickListener {

    private View.OnClickListener onClickListener;
    private Button button;
    private String text;
    private int delay = 2000;
//    private boolean counter = false;
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

//    public DelayButton(Button button, View.OnClickListener onClickListener, boolean counter) {
//        this.button = button;
//        this.onClickListener = onClickListener;
//        this.counter = counter;
//    }

//    public DelayButton(Button button, View.OnClickListener onClickListener, int delay, boolean counter) {
//        this.button = button;
//        this.onClickListener = onClickListener;
//        this.delay = delay;
//        this.counter = counter;
//    }

    @Override
    public void onClick(View view) {
        onClickListener.onClick(view);
        button.setEnabled(false);
        text = button.getText().toString();

        countDownTimer = new CountDownTimer(delay, 1000) {
            public void onTick(long millisUntilFinished) {
//                if (counter){
//                    int progress = (int) millisUntilFinished / 1000;
//                    if (progress>0){
//                        button.setText(text + "(" + progress + ")");
//                    } else {
//                        button.setText(text);
//                    }
//                }
            }

            public void onFinish() {
                button.setEnabled(true);
            }
        };
        countDownTimer.start();
    }
}
