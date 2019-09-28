package com.Tamazj.TamazjApp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.Tamazj.TamazjApp.Model.AppConstants;
import com.Tamazj.TamazjApp.R;
import com.google.firebase.iid.FirebaseInstanceId;

public class SwitchAccountTypeActivity extends AppCompatActivity {

    private TextView mBeneficiary;
    private TextView mAdvisor;
    private CardView mBeneficiarycard;
    private CardView mAdvisorcard;
    String fcm_token;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor_signUp;

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
        fcm_token = FirebaseInstanceId.getInstance().getToken();
        if(fcm_token!=null) {
            Log.d("fcm_token", fcm_token);
            sharedPreferences = getSharedPreferences(AppConstants.KEY_SIGN_UP,MODE_PRIVATE);
            editor_signUp = sharedPreferences.edit();
            editor_signUp.putString(AppConstants.FCM_TOKEN, AppConstants.FCM_TOKEN);

        }




        mAdvisorcard = findViewById(R.id.advisorcard);
        mAdvisorcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 sharedPreferences = getSharedPreferences(AppConstants.KEY_SIGN_UP,MODE_PRIVATE);
                editor_signUp = sharedPreferences.edit();
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
                 sharedPreferences = getSharedPreferences(AppConstants.KEY_SIGN_UP,MODE_PRIVATE);
                editor_signUp = sharedPreferences.edit();
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
