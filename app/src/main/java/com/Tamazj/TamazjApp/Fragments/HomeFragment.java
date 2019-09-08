package com.Tamazj.TamazjApp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.Tamazj.TamazjApp.Activity.UserprofileActivity;
import com.Tamazj.TamazjApp.Adapter.Areas_Counseling_adapter;
import com.Tamazj.TamazjApp.Adapter.CustomViewPagerAdapter;
import com.Tamazj.TamazjApp.Adapter.Distinguished_Advisors_Adapter;
import com.Tamazj.TamazjApp.AdvisorFragments.AdvisorProfileFragment;
import com.Tamazj.TamazjApp.Model.Areas_Counseling_Model;
import com.Tamazj.TamazjApp.Model.Distinguished_Advisors_Model;
import com.Tamazj.TamazjApp.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    View view;
    private CardView mCardview;
    private TextView mPercent;
    private ImageView mProfileimage;
    private TextView mProfileName;
    private TextView mProfileDsc;
    private ImageView mAskasteschar;
    private ImageView mImageView;
    private TextView mTextView;
    private ImageView mBack;
    ImageView personalprofile;
    private RecyclerView mAreasCounseling;
    private TextView mTextView2;
    private ImageView mAdvisorsBack;
    private RecyclerView mDistinguishedAdvisors;
    LinearLayoutManager mDistinguishedAdvisorsmanager ;
    LinearLayoutManager mAreasCounselingmanager ;
    List<Areas_Counseling_Model> areas_counseling_models=new ArrayList<>();
    Areas_Counseling_adapter areas_counseling_adapter;

    List<Distinguished_Advisors_Model> distinguished_advisors_models=new ArrayList<>();
    Distinguished_Advisors_Adapter distinguished_advisors_adapter;
    private static final long SLIDER_TIMER = 2000; // change slider interval
    private int currentPage = 0; // this will tell us the current page available on the view pager
    // please see ViewPager Listener on the onPageSelected method to see how we are updating
    // currentPage variable
    private boolean isCountDownTimerActive = false; // let the timer start if and only if it has completed previous task
    private Handler handler;
    private ViewPager viewPager;
    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (!isCountDownTimerActive) {
                automateSlider();
            }
            handler.postDelayed(runnable, 1000);
            // our runnable should keep running for every 1000 milliseconds (1 seconds)
        }
    };






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initView();
        handler = new Handler();
        handler.postDelayed(runnable, 1000);
        runnable.run();
        viewPager = view.findViewById(R.id.view_pager_slider);
        CustomViewPagerAdapter viewPagerAdapter = new CustomViewPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        // now it's time to think about our sliders
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    currentPage = 0;
                } else if (position == 1) {
                    currentPage = 1;
                } else {
                    currentPage = 2;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        mDistinguishedAdvisorsmanager = new LinearLayoutManager(getContext());
        mDistinguishedAdvisorsmanager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mDistinguishedAdvisors.setLayoutManager(mDistinguishedAdvisorsmanager);
        mDistinguishedAdvisors.setHasFixedSize(true);
        mAreasCounselingmanager = new LinearLayoutManager(getContext());
        mAreasCounselingmanager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mAreasCounseling.setLayoutManager(mAreasCounselingmanager);
        mAreasCounseling.setHasFixedSize(true);
        areas_counseling_models.add(new Areas_Counseling_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","استشارات أسرية "));
        areas_counseling_models.add(new Areas_Counseling_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","استشارات نفسية "));
        areas_counseling_models.add(new Areas_Counseling_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","السمو بالنفس "));
        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات أسرية "));
        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات أسرية "));
        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات نفسية  "));
        areas_counseling_models.add(new Areas_Counseling_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","استشارات نفسية "));
        areas_counseling_models.add(new Areas_Counseling_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","السمو بالنفس "));
        areas_counseling_models.add(new Areas_Counseling_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","استشارات أسرية "));
        areas_counseling_models.add(new Areas_Counseling_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","استشارات نفسية "));


        areas_counseling_adapter=new Areas_Counseling_adapter(getContext(),areas_counseling_models);
        distinguished_advisors_adapter=new Distinguished_Advisors_Adapter(getContext(),distinguished_advisors_models);
        mDistinguishedAdvisors.setAdapter(distinguished_advisors_adapter);
        mAreasCounseling.setAdapter(areas_counseling_adapter);
        personalprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), UserprofileActivity.class);
                getActivity().startActivity(intent);
            }
        });

      /*  mCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new CategoriesdetailsFragment(), "HomeFragment").commit();

            }
        });*/







        return view;
    }

    private void initView() {
        mCardview = view.findViewById(R.id.cardview);
        mPercent = view.findViewById(R.id.percent);
        mProfileimage = view.findViewById(R.id.profileimage);
        mProfileName = view.findViewById(R.id.profile_name);
        mProfileDsc = view.findViewById(R.id.profile_dsc);
        mAskasteschar = view.findViewById(R.id.askasteschar);
        mImageView = view.findViewById(R.id.imageView);
        mTextView = view.findViewById(R.id.textView);
        mBack = view.findViewById(R.id.back);
        mAreasCounseling = view.findViewById(R.id.Areas_Counseling);
        mTextView2 = view.findViewById(R.id.textView2);
        mAdvisorsBack = view.findViewById(R.id.Advisors_back);
        mDistinguishedAdvisors = view.findViewById(R.id.Distinguished_Advisors);
        personalprofile=view.findViewById(R.id.personalprofile);

    }

    private void automateSlider() {
        isCountDownTimerActive = true;
        new CountDownTimer(SLIDER_TIMER, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                int nextSlider = currentPage + 1;

                if (nextSlider == 3) {
                    nextSlider = 0; // if it's last Image, let it go to the first image
                }
                viewPager.setCurrentItem(nextSlider);
                isCountDownTimerActive = false;
            }
        }.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
    }
}