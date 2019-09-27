package com.Tamazj.TamazjApp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.Tamazj.TamazjApp.MainActivity;
import com.Tamazj.TamazjApp.Model.AppConstants;
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

        SharedPreferences sharedPreferences = getSharedPreferences(AppConstants.KEY_SIGN_UP, MODE_PRIVATE);
        if (sharedPreferences.getString(AppConstants.EMAIL, null) != null &&
                sharedPreferences.getString(AppConstants.PASSWORD, null) != null) {

            if (sharedPreferences.getString(AppConstants.ACCOUNT_TYPE, null) != null) {

                if(sharedPreferences.getBoolean(AppConstants.ISLOGIN,false)) {

                    if (sharedPreferences.getString(AppConstants.ACCOUNT_TYPE, null).equals(AppConstants.Advisor)) {
                        Intent intent = new Intent(SplashActivity.this, AdvisorActivity.class);
                        startActivity(intent);
                        finish();
                    } else if (sharedPreferences.getString(AppConstants.ACCOUNT_TYPE, null).equals(AppConstants.Beneficiary)) {
                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }

            }

        } else {
            new CountDownTimer(SPLASH_TIME, 1000) {

                @Override
                public void onFinish() {

                    Intent intent = new Intent(getBaseContext(), SwitchAccountTypeActivity.class);
                    startActivity(intent);
                    finish();

                }

                @Override
                public void onTick(long millisUntilFinished) {

                }
            }.start();

        }

    }



    @Override
    public void onBackPressed()
    {

        super.onBackPressed();
    }
}
