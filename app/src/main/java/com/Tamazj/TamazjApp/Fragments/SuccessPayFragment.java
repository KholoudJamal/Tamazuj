package com.Tamazj.TamazjApp.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.Tamazj.TamazjApp.Activity.SessionActivity;
import com.Tamazj.TamazjApp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SuccessPayFragment extends Fragment {

    View view;
    Button buttonStartSession;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_success_pay, container, false);
        buttonStartSession = view.findViewById(R.id.buttonStartSession);
        buttonStartSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SessionActivity.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });
        return view;
    }

}
