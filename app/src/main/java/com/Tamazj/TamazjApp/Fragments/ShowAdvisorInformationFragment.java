package com.Tamazj.TamazjApp.Fragments;


import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.Tamazj.TamazjApp.Adapter.ReviewAdapter;
import com.Tamazj.TamazjApp.Adapter.TextViewAdapter;
import com.Tamazj.TamazjApp.Model.AppConstants;
import com.Tamazj.TamazjApp.Model.Review;
import com.Tamazj.TamazjApp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowAdvisorInformationFragment extends Fragment {

    View view, aboutReviewsView;
    ImageButton blueBack, profileImage;
    TextView tvAdvisorName, tvRatePercent, tvAskConsult, tvAdvisorAbout, tvAdvisorReviews, tvAboutAdvisorText;
    FrameLayout showAdvisorInformationFrameLayout;
    RecyclerView rvShowAdvisorInf ,rvBeneficiariesFeedback;
    LayoutInflater inf;
    List<String> listShowAdvisorInf;
    TextViewAdapter textViewAdapter;
    List<Review> list;
    ReviewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_show_advisor_information, container, false);

        blueBack = view.findViewById(R.id.blueBack);
        blueBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();      }
        });

        inf = LayoutInflater.from(getContext());

        profileImage = view.findViewById(R.id.profileImage);
        tvAdvisorName = view.findViewById(R.id.tvAdvisorName);
        tvRatePercent = view.findViewById(R.id.tvRatePercent);
        rvShowAdvisorInf = view.findViewById(R.id.rvShowAdvisorInf);
        tvAskConsult = view.findViewById(R.id.tvAskConsult);
        tvAdvisorAbout = view.findViewById(R.id.tvAdvisorAbout);
        tvAdvisorReviews = view.findViewById(R.id.tvAdvisorReviews);
        showAdvisorInformationFrameLayout = view.findViewById(R.id.showAdvisorInformationFrameLayout);

        listShowAdvisorInf = new ArrayList<String>();
        listShowAdvisorInf.add(getString(R.string.family_consultane));
        listShowAdvisorInf.add(getString(R.string.family_consultane));
        listShowAdvisorInf.add(getString(R.string.family_consultane));
        textViewAdapter = new TextViewAdapter(getContext(), listShowAdvisorInf);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rvShowAdvisorInf.setLayoutManager(layoutManager);
        rvShowAdvisorInf.setAdapter(textViewAdapter);

        tvAskConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     }
        });

        tvAdvisorAbout.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                tvAdvisorAbout.setBackground(getContext().getDrawable(R.drawable.light_blue_bacground));
                tvAdvisorAbout.setTextColor(R.color.colorBlue);
                tvAdvisorReviews.setBackground(null);
                tvAdvisorReviews.setTextColor(R.color.colorBlack);

                aboutReviewsView = inf.inflate(R.layout.advisor_about_layout,null);
                showAdvisorInformationFrameLayout.addView(aboutReviewsView);
                tvAboutAdvisorText = aboutReviewsView.findViewById(R.id.tvAboutAdvisorText);

            }
        });

        tvAdvisorReviews.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                tvAdvisorReviews.setBackground(getContext().getDrawable(R.drawable.light_blue_bacground));
                tvAdvisorReviews.setTextColor(R.color.colorBlue);
                tvAdvisorAbout.setBackground(null);
                tvAdvisorAbout.setTextColor(R.color.colorBlack);

                aboutReviewsView = inf.inflate(R.layout.advisor_reviews_layout,null);
                showAdvisorInformationFrameLayout.addView(aboutReviewsView);
                rvBeneficiariesFeedback = aboutReviewsView.findViewById(R.id.rvBeneficiariesFeedback);

                list = new ArrayList<>();
                list.add(new Review(AppConstants.HAPPY));
                list.add(new Review(AppConstants.SATISFIED));
                list.add(new Review(AppConstants.NOT_SATISFIED));
                adapter = new ReviewAdapter(getContext(), list);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                rvBeneficiariesFeedback.setLayoutManager(layoutManager);
                rvBeneficiariesFeedback.setAdapter(adapter);

            }
        });



        return view;
    }

}
