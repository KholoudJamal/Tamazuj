package com.Tamazj.TamazjApp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.Tamazj.TamazjApp.Adapter.Distinguished_Advisors_Adapter;
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
    ImageButton personalprofile;
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





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initView();
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
}