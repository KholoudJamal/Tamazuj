package com.Tamazj.TamazjApp;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import com.Tamazj.TamazjApp.Model.AppConstants;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.Tamazj.TamazjApp.Fragments.CategoriesFragment;
import com.Tamazj.TamazjApp.Fragments.CategorySelectionFragment;
import com.Tamazj.TamazjApp.Fragments.HomeFragment;
import com.Tamazj.TamazjApp.Fragments.MenuUserFragment;
import com.Tamazj.TamazjApp.Fragments.MyConsultationragment;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    ImageView selectcatogory;
    SharedPreferences sharedPreferences;
    String choosing_langauge;


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
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new MenuUserFragment(), "HomeFragment").commit();

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
        sharedPreferences = getSharedPreferences(AppConstants.KEY_SIGN_UP, MODE_PRIVATE);
        Configuration config = new Configuration();

        if (sharedPreferences != null) {
            if (sharedPreferences.getString(AppConstants.LANG_choose, null) != null) {
                choosing_langauge = sharedPreferences.getString(AppConstants.LANG_choose, "");
                if(choosing_langauge.matches("ar")){

                    Locale arabic = new Locale("ar", "ar");
                    config.locale = arabic;
                    getResources().updateConfiguration(config, null);

                }
                else{

                    Locale arabic = new Locale("ar", "ar");
                    config.locale = arabic;
                    getResources().updateConfiguration(config, null);

                }

            }
        }

        mTextMessage = findViewById(R.id.message);
        selectcatogory=findViewById(R.id.selectcatogory);
        selectcatogory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new CategorySelectionFragment(), "HomeFragment").commit();


            }
        });
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.setItemIconTintList(null);
        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new HomeFragment(), "HomeFragment").commit();


    }

}
