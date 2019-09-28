package com.Tamazj.TamazjApp.Fragments;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.Tamazj.TamazjApp.Activity.AdvisorProfileActivity;
import com.Tamazj.TamazjApp.AdvisorFragments.AdvisorNotificationsFragment;
import com.Tamazj.TamazjApp.AdvisorFragments.ConsoultAdvisorFragment;
import com.Tamazj.TamazjApp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    View view;
    ImageButton signOut;
    TextView myAccount, notification, consultingRecord, aboutApp, settings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_menu, container, false);

        myAccount = view.findViewById(R.id.tvMenuMyAccount);
        notification = view.findViewById(R.id.tvMenuNotification);
        consultingRecord = view.findViewById(R.id.tvMenuMyConsultingRecord);
        aboutApp = view.findViewById(R.id.tvMenuAboutApp);
        settings = view.findViewById(R.id.tvMenuSettings);

        myAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AdvisorProfileActivity.class);
                getActivity().startActivity(intent);
            }
        });

        consultingRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.advisorFragmentsContainer, new AdvisorNotificationsFragment(), "HomeFragment").commit();
            }
        });

        consultingRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.advisorFragmentsContainer, new ConsoultAdvisorFragment(), "HomeFragment").commit();
            }
        });

        return view;
    }

}
