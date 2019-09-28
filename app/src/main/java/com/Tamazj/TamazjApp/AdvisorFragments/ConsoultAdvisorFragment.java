package com.Tamazj.TamazjApp.AdvisorFragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.Tamazj.TamazjApp.Adapter.ConsultAdapter;
import com.Tamazj.TamazjApp.Model.Consult;
import com.Tamazj.TamazjApp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConsoultAdvisorFragment extends Fragment {

    View view;
    ImageButton blueBack;
    RecyclerView recyclerView;
    List<Consult> consultApplications;
    ConsultAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_consoult_advisor, container, false);
        blueBack = view.findViewById(R.id.blueBack);
        blueBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.advisorFragmentsContainer, new HomeAdvisorFragment(), "HomeFragment").commit();
            }
        });

        recyclerView = view.findViewById(R.id.rvAdvisorConsult);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        consultApplications = new ArrayList<>();

        consultApplications.add(new Consult(true));
        consultApplications.add(new Consult(false));
        consultApplications.add(new Consult(false));
        consultApplications.add(new Consult(true));
        consultApplications.add(new Consult(true));
        consultApplications.add(new Consult(true));

        adapter = new ConsultAdapter(getContext(), consultApplications);
        recyclerView.setAdapter(adapter);

        return view;
    }

}
