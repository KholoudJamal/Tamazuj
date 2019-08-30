package com.Tamazj.TamazjApp;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

import com.Tamazj.TamazjApp.Fragments.CategoriesFragment;
import com.Tamazj.TamazjApp.Fragments.HomeFragment;
import com.Tamazj.TamazjApp.Fragments.MenuFragment;
import com.Tamazj.TamazjApp.Fragments.MyConsultationragment;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                
                case R.id.navigation_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new HomeFragment(), "HomeFragment").commit();

                    return true;
                case R.id.navigation_astshat:
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new MyConsultationragment(), "HomeFragment").commit();

                    return true;
                case R.id.navigation_menu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new CategoriesFragment(), "HomeFragment").commit();

                    return true;

                case R.id.navigation_homeprofile:
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new MenuFragment(), "HomeFragment").commit();

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.setItemIconTintList(null);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new HomeFragment(), "HomeFragment").commit();


    }

}
