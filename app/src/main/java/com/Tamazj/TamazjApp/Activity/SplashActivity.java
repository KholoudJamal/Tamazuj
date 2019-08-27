package com.Tamazj.TamazjApp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.Tamazj.TamazjApp.MainActivity;
import com.Tamazj.TamazjApp.R;

public class SplashActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    public static final int SPLASH_TIME = 2000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        new CountDownTimer(SPLASH_TIME, 1000) {

            @Override
            public void onFinish() {

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
                finish();

            }

            @Override
            public void onTick(long millisUntilFinished) {

            }
        }.start();

    }





    @Override
    public void onBackPressed()
    {

        super.onBackPressed();
    }
}
