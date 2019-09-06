package com.Tamazj.TamazjApp.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.Tamazj.TamazjApp.Activity.AdvisorProfileActivity;
import com.Tamazj.TamazjApp.Activity.UserprofileActivity;
import com.Tamazj.TamazjApp.AdvisorFragments.AdvisorNotificationsFragment;
import com.Tamazj.TamazjApp.AdvisorFragments.ConsoultAdvisorFragment;
import com.Tamazj.TamazjApp.R;
import com.Tamazj.TamazjApp.UserFragment.ConsoultUserFragment;
import com.Tamazj.TamazjApp.UserFragment.UserNotificationsFragment;

public class MenuUserFragment extends Fragment {

    View view;
    ImageButton signOut,blueBack,search;
    TextView myAccount, notification, consultingRecord, aboutApp, settings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_menu_user, container, false);

        myAccount = view.findViewById(R.id.tvMenuMyAccount);
        notification = view.findViewById(R.id.tvMenuNotification);
        consultingRecord = view.findViewById(R.id.tvMenuMyConsultingRecord);
        aboutApp = view.findViewById(R.id.tvMenuAboutApp);
        settings = view.findViewById(R.id.tvMenuSettings);
        blueBack=view.findViewById(R.id.blueBack);
        search=view.findViewById(R.id.search);
        blueBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserprofileActivity.class);
                getActivity().startActivity(intent);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        myAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserprofileActivity.class);
                getActivity().startActivity(intent);
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new UserNotificationsFragment(), "HomeFragment").commit();
            }
        });

        consultingRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new ConsoultUserFragment(), "HomeFragment").commit();
            }
        });

        return view;
    }

}
