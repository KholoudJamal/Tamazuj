package com.Tamazj.TamazjApp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.Tamazj.TamazjApp.MainActivity;
import com.Tamazj.TamazjApp.Model.AppConstants;
import com.Tamazj.TamazjApp.R;

public class SwitchAccountTypeActivity extends AppCompatActivity {

    private TextView mBeneficiary;
    private TextView mAdvisor;
    private CardView mBeneficiarycard;
    private CardView mAdvisorcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_switch_account_type);
        mBeneficiary = findViewById(R.id.beneficiary);
        mBeneficiarycard = findViewById(R.id.beneficiarycard);
        mAdvisor = findViewById(R.id.advisor);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.stausbarswitch, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.stausbarswitch));
        }


        mAdvisorcard = findViewById(R.id.advisorcard);
        mAdvisorcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences(AppConstants.KEY_SIGN_UP,MODE_PRIVATE);
                SharedPreferences.Editor editor_signUp = sharedPreferences.edit();
                editor_signUp.putString(AppConstants.ACCOUNT_TYPE, AppConstants.Advisor);
                //boolean isDone = editor.commit();
                //editor.apply();
                editor_signUp.apply();
                Intent intent=new Intent(SwitchAccountTypeActivity.this, SignInActivity.class);
                startActivity(intent);
                finish();

            }
        });

        mBeneficiarycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(AppConstants.KEY_SIGN_UP,MODE_PRIVATE);
                SharedPreferences.Editor editor_signUp = sharedPreferences.edit();
                editor_signUp.putString(AppConstants.ACCOUNT_TYPE, AppConstants.Beneficiary);
                //boolean isDone = editor.commit();
                //editor.apply();
                editor_signUp.apply();
                 Intent intent=new Intent(SwitchAccountTypeActivity.this, SignInActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
