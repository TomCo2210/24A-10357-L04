package dev.tomco.a24a_10357_l04;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class PeriodicWorker extends Worker {
    public PeriodicWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        // What i want to do
        Log.d("In doWork()", "doWork: " + System.currentTimeMillis());
        return Result.success();
    }
}
