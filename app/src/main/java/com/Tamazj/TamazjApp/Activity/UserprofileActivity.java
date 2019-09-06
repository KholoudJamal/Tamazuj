package com.Tamazj.TamazjApp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.Tamazj.TamazjApp.AdvisorFragments.AdvisorProfileFragment;
import com.Tamazj.TamazjApp.MainActivity;
import com.Tamazj.TamazjApp.R;
import com.Tamazj.TamazjApp.UserFragment.UserProfileFragment;

public class UserprofileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new UserProfileFragment(), "HomeFragment").commit();

    }



}
