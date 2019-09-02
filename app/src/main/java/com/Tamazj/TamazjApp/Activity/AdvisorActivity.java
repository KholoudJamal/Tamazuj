package com.Tamazj.TamazjApp.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.Tamazj.TamazjApp.AdvisorFragments.AdvisorNotificationsFragment;
import com.Tamazj.TamazjApp.AdvisorFragments.AdvisorProfileFragment;
import com.Tamazj.TamazjApp.AdvisorFragments.ConsoultAdvisorFragment;
import com.Tamazj.TamazjApp.AdvisorFragments.HomeAdvisorFragment;
import com.Tamazj.TamazjApp.Fragments.CategoriesFragment;
import com.Tamazj.TamazjApp.Fragments.HomeFragment;
import com.Tamazj.TamazjApp.Fragments.MenuFragment;
import com.Tamazj.TamazjApp.Fragments.MyConsultationragment;
import com.Tamazj.TamazjApp.R;

public class AdvisorActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_advisor_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.advisorFragmentsContainer, new HomeAdvisorFragment(), "HomeFragment").commit();

                    return true;
                case R.id.navigation_advisor_notifications:
                    getSupportFragmentManager().beginTransaction().replace(R.id.advisorFragmentsContainer, new AdvisorNotificationsFragment(), "HomeFragment").commit();

                    return true;
                case R.id.navigation__advisor_consult:
                    getSupportFragmentManager().beginTransaction().replace(R.id.advisorFragmentsContainer, new ConsoultAdvisorFragment(), "HomeFragment").commit();

                    return true;

                case R.id.navigation_advisor_menu:
                    getSupportFragmentManager().beginTransaction().replace(R.id.advisorFragmentsContainer, new MenuFragment(), "HomeFragment").commit();

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisor);
        getSupportFragmentManager().beginTransaction().replace(R.id.advisorFragmentsContainer, new HomeAdvisorFragment(), "HomeFragment").commit();
        BottomNavigationView navView = findViewById(R.id.nav_view);
        //mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.setItemIconTintList(null);

    }
}
