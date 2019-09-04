package com.Tamazj.TamazjApp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.Tamazj.TamazjApp.MainActivity;
import com.Tamazj.TamazjApp.R;

public class UserprofileActivity extends AppCompatActivity {

    private ImageButton mEditprofile;
    private ImageButton mBack;
    private FrameLayout mProfileFrame;
    private CardView mProfileCardView;
    private TextView mTvFullNameProfile;
    private TextView mTvEmailProfile;
    private ImageButton mProfileImage;
    private TextView mSextype;
    private TextView mCountry;
    private TextView mDatatbirth;
    private TextView mUniversity;
    private TextView mWork;
    private TextView mMaritalstatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        initView();
    }

    private void initView() {
        mEditprofile = findViewById(R.id.editprofile);
        mBack = findViewById(R.id.back);
        mProfileFrame = findViewById(R.id.profileFrame);
        mProfileCardView = findViewById(R.id.profileCardView);
        mTvFullNameProfile = findViewById(R.id.tvFullNameProfile);
        mTvEmailProfile = findViewById(R.id.tvEmailProfile);
        mProfileImage = findViewById(R.id.profileImage);
        mSextype = findViewById(R.id.sextype);
        mCountry = findViewById(R.id.country);
        mDatatbirth = findViewById(R.id.datatbirth);
        mUniversity = findViewById(R.id.university);
        mWork = findViewById(R.id.work);
        mMaritalstatus = findViewById(R.id.maritalstatus);
        mEditprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UserprofileActivity.this, EditUserProfileActivity.class);
                startActivity(intent);
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UserprofileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
