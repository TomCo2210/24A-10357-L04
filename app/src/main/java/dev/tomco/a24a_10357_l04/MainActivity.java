package dev.tomco.a24a_10357_l04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;

public class MainActivity extends AppCompatActivity {

    private ShapeableImageView main_IMG_background;
    private MaterialButton main_BTN_VibrateAndToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        Glide
                .with(this)
//                .load(R.drawable.everest)
                .load("https://upload.wikimedia.org/wikipedia/commons/e/e7/Everest_North_Face_toward_Base_Camp_Tibet_Luca_Galuzzi_2006.jpg")
                .placeholder(R.drawable.ic_launcher_background)
                .centerCrop()
                .into(main_IMG_background);

        main_BTN_VibrateAndToast.setOnClickListener(v -> toastAndVibrate("Hello Toast Message"));
    }

    private void toastAndVibrate(String text) {
        vibrate();
        toast(text);
    }

    private void toast(String text) {
    }

    private void vibrate() {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            v.vibrate(500);
        }
    }

    private void findViews() {
        main_IMG_background = findViewById(R.id.main_IMG_background);
        main_BTN_VibrateAndToast = findViewById(R.id.main_BTN_VibrateAndToast);

    }
}