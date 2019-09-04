package com.Tamazj.TamazjApp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.Tamazj.TamazjApp.MainActivity;
import com.Tamazj.TamazjApp.Model.EditPasswordBottomDialog;
import com.Tamazj.TamazjApp.R;

public class EditUserProfileActivity extends AppCompatActivity {

    private ImageButton mBlueBack;
    private ImageView mImageView;
    private ImageButton mProfileImage;
    private ImageButton mEditProfileImage;
    private TextView mTvFullNameProfile;
    private TextView mTvEmailProfile;
    private EditText mTvFullNameAdvisorEditProfile;
    private EditText mTvEmailAdvisorEditProfile;
    private EditText mTvPhoneAdvisorEditProfile;
    private TextView mTvPasswordAdvisorEditProfile;
    private TextView mTvGenderAdvisorEditProfile;
    private TextView mTvNationalityAdvisorEditProfile;
    private TextView mTvBirthDateAdvisorEditProfile;
    private TextView mTvLearningAdvisorEditProfile;
    private TextView mTvJobAdvisorEditProfile;
    private TextView mTvSocialStateAdvisorEditProfile;
    private Button mApprovalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_profile);
        mBlueBack = findViewById(R.id.blueBack);
        mImageView = findViewById(R.id.imageView);
        mProfileImage = findViewById(R.id.profileImage);
        mEditProfileImage = findViewById(R.id.editProfileImage);
        mTvFullNameProfile = findViewById(R.id.tvFullNameProfile);
        mTvEmailProfile = findViewById(R.id.tvEmailProfile);
        mTvFullNameAdvisorEditProfile = findViewById(R.id.tvFullNameAdvisorEditProfile);
        mTvEmailAdvisorEditProfile = findViewById(R.id.tvEmailAdvisorEditProfile);
        mTvPhoneAdvisorEditProfile = findViewById(R.id.tvPhoneAdvisorEditProfile);
        mTvPasswordAdvisorEditProfile = findViewById(R.id.tvPasswordAdvisorEditProfile);
        mTvGenderAdvisorEditProfile = findViewById(R.id.tvGenderAdvisorEditProfile);
        mTvNationalityAdvisorEditProfile = findViewById(R.id.tvNationalityAdvisorEditProfile);
        mTvBirthDateAdvisorEditProfile = findViewById(R.id.tvBirthDateAdvisorEditProfile);
        mTvLearningAdvisorEditProfile = findViewById(R.id.tvLearningAdvisorEditProfile);
        mTvJobAdvisorEditProfile = findViewById(R.id.tvJobAdvisorEditProfile);
        mTvSocialStateAdvisorEditProfile = findViewById(R.id.tvSocialStateAdvisorEditProfile);
        mApprovalButton = findViewById(R.id.approvalButton);
        mBlueBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EditUserProfileActivity.this, UserprofileActivity.class);
                startActivity(intent);
            }
        });
        mTvPasswordAdvisorEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


    }
}
