package dev.tomco.a24a_10357_l04;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.Timer;
import java.util.TimerTask;

public class TimerActivity2 extends AppCompatActivity {

    private ExtendedFloatingActionButton time_FAB_start;
    private ExtendedFloatingActionButton time_FAB_stop;
    private MaterialTextView timer_LBL_time;
    private static final long DELAY = 1000;
    private long startTime;
    private boolean timerOn = false;
    private Timer timer;


    private void updateTimerUI() {
        Log.d("Current Time", "" + System.currentTimeMillis());
        long currentMillis = System.currentTimeMillis() - startTime;
        int seconds = (int) (currentMillis / 1000);
        int minutes = seconds / 60;
        seconds %= 60;
        int hours = minutes / 60;
        minutes %= 60;
        hours %= 24;

        timer_LBL_time.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer1);

        findViews();
        initViews();
    }

    private void initViews() {
        time_FAB_start.setOnClickListener(v -> startTimer());
        time_FAB_stop.setOnClickListener(v -> stopTimer());

    }

    private void stopTimer() {
        timerOn = false;
        timer.cancel();
    }

    private void startTimer() {
        if (!timerOn) {
            timerOn = true;
            startTime = System.currentTimeMillis();
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(() -> updateTimerUI());
                }
            }, 0, DELAY);
        }
    }

    private void findViews() {

        time_FAB_start = findViewById(R.id.time_FAB_start);
        time_FAB_stop = findViewById(R.id.time_FAB_stop);
        timer_LBL_time = findViewById(R.id.timer_LBL_time);

    }
}