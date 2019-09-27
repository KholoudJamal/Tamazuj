package com.Tamazj.TamazjApp.Activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

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
