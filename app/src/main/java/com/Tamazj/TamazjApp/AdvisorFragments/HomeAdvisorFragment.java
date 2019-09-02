package com.Tamazj.TamazjApp.AdvisorFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Tamazj.TamazjApp.Adapter.ConsultApplicationsAdapter;
import com.Tamazj.TamazjApp.Model.ConsultApplication;
import com.Tamazj.TamazjApp.R;

import java.util.ArrayList;
import java.util.List;


public class HomeAdvisorFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    List<ConsultApplication> consultApplications;
    ConsultApplicationsAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home_advisor, container, false);

        recyclerView = view.findViewById(R.id.rvConsultApplications);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        consultApplications = new ArrayList<>();

        consultApplications.add(new ConsultApplication());
        consultApplications.add(new ConsultApplication());

        adapter = new ConsultApplicationsAdapter(getContext(), consultApplications);
        recyclerView.setAdapter(adapter);

        ViewGroup warningFrameLayout = view.findViewById(R.id.warningFrameLayout);
        LayoutInflater inflaterWarning = LayoutInflater.from(getContext());
        View warningLayout = inflaterWarning.inflate(R.layout.warning_layout, warningFrameLayout, false);
        TextView tvCompleteProfile = warningLayout.findViewById(R.id.tvCompleteProfile);
        tvCompleteProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        TextView tvW = warningLayout.findViewById(R.id.tvW);
        tvW.setVisibility(View.VISIBLE);



        return view;
    }


}
