package com.Tamazj.TamazjApp.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.Tamazj.TamazjApp.Adapter.Areas_Counseling_adapter;
import com.Tamazj.TamazjApp.Adapter.Distinguished_Advisors_Adapter;
import com.Tamazj.TamazjApp.Model.Areas_Counseling_Model;
import com.Tamazj.TamazjApp.Model.Distinguished_Advisors_Model;
import com.Tamazj.TamazjApp.R;

import java.util.ArrayList;
import java.util.List;

public class MyConsultationragment extends Fragment {
    View view;
    private RecyclerView mAreasCounseling;
    GridLayoutManager gridLayoutManager ;
    List<Distinguished_Advisors_Model> distinguished_advisors_models=new ArrayList<>();
    Distinguished_Advisors_Adapter distinguished_advisors_adapter;
    private Toolbar mToolbar;
    private LinearLayout mLinaree;
    private RecyclerView mDistinguishedAdvisors;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_my_consultationragment, container, false);
        mToolbar = view.findViewById(R.id.toolbar);
        mLinaree = view.findViewById(R.id.linaree);
        mDistinguishedAdvisors = view.findViewById(R.id.Distinguished_Advisors);
        gridLayoutManager = new GridLayoutManager(getContext(),3);
        mDistinguishedAdvisors.setLayoutManager(gridLayoutManager);
        mDistinguishedAdvisors.setHasFixedSize(true);
        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات أسرية "));
        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات أسرية "));
        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات أسرية "));
        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات أسرية "));
        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات نفسية  "));
        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات أسرية "));
        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات أسرية "));
        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات نفسية  "));
        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات أسرية "));
        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات أسرية "));
        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات نفسية  "));

        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات نفسية  "));
        distinguished_advisors_adapter=new Distinguished_Advisors_Adapter(getContext(),distinguished_advisors_models);
        mDistinguishedAdvisors.setAdapter(distinguished_advisors_adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mToolbar = view.findViewById(R.id.toolbar);
        mLinaree = view.findViewById(R.id.linaree);
        mDistinguishedAdvisors = view.findViewById(R.id.Distinguished_Advisors);
    }
}