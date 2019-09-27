package com.Tamazj.TamazjApp.AdvisorFragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.Tamazj.TamazjApp.Adapter.NotificationsAdapter;
import com.Tamazj.TamazjApp.Model.Notification;
import com.Tamazj.TamazjApp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdvisorNotificationsFragment extends Fragment {

    View view;
    ImageButton blueBack;
    RecyclerView newRecyclerView;
    RecyclerView oldRecyclerView;
    List<Notification> newNotifications;
    List<Notification> oldNotifications;
    NotificationsAdapter newAdapter;
    NotificationsAdapter oldAdapter;

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
        view = inflater.inflate(R.layout.fragment_advisor_notifications, container, false);

        blueBack = view.findViewById(R.id.blueBack);
        blueBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.advisorFragmentsContainer, new HomeAdvisorFragment(), "HomeFragment").commit();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        newRecyclerView = view.findViewById(R.id.rvNewNotifications);
        newRecyclerView.setLayoutManager(layoutManager);

        newNotifications = new ArrayList<>();

        newNotifications.add(new Notification(getString(R.string.notificationText), getString(R.string.notificationTime),true));
        newNotifications.add(new Notification(getString(R.string.notificationText), getString(R.string.notificationTime),true));
        newNotifications.add(new Notification(getString(R.string.notificationText), getString(R.string.notificationTime),true));

        newAdapter = new NotificationsAdapter(getContext(), newNotifications);
        newRecyclerView.setAdapter(newAdapter);

        oldRecyclerView = view.findViewById(R.id.rvOldNotifications);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        oldRecyclerView.setLayoutManager(layoutManager2);

        oldNotifications = new ArrayList<>();

        oldNotifications.add(new Notification(getString(R.string.notificationText), getString(R.string.notificationTime),false));
        oldNotifications.add(new Notification(getString(R.string.notificationText), getString(R.string.notificationTime),false));
        oldNotifications.add(new Notification(getString(R.string.notificationText), getString(R.string.notificationTime),false));
        oldNotifications.add(new Notification(getString(R.string.notificationText), getString(R.string.notificationTime),false));
        oldNotifications.add(new Notification(getString(R.string.notificationText), getString(R.string.notificationTime),false));

        oldAdapter = new NotificationsAdapter(getContext(), oldNotifications);
        oldRecyclerView.setAdapter(oldAdapter);

        return view;
    }

}
