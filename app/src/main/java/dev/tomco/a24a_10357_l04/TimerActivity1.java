package dev.tomco.a24a_10357_l04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textview.MaterialTextView;

public class TimerActivity1 extends AppCompatActivity {

    private ExtendedFloatingActionButton time_FAB_start;
    private ExtendedFloatingActionButton time_FAB_stop;
    private MaterialTextView timer_LBL_time;

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
    }

    private void startTimer() {
    }

    private void findViews() {

        time_FAB_start = findViewById(R.id.time_FAB_start);
        time_FAB_stop = findViewById(R.id.time_FAB_stop);
        timer_LBL_time = findViewById(R.id.timer_LBL_time);

    }
}