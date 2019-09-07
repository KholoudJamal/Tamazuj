package com.Tamazj.TamazjApp.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.Tamazj.TamazjApp.Activity.SessionActivity;
import com.Tamazj.TamazjApp.Model.AppConstants;
import com.Tamazj.TamazjApp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SuccessPayFragment extends Fragment {

    View view;
    Button buttonStartSession;
    String sessionType = AppConstants.FIRST_SESSION;
    String cost;
    TextView tvBillSupDetails;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_success_pay, container, false);

        tvBillSupDetails = view.findViewById(R.id.tvBillSupDetails);

        Bundle bundle = getArguments();
        if(bundle != null && bundle.getString(AppConstants.SESSION_TYPE) != null){
            sessionType = bundle.getString(AppConstants.SESSION_TYPE);
        }

            switch (sessionType){
                case AppConstants.FIRST_SESSION:
                    cost = getString(R.string.RS50);
                    break;
                case AppConstants.SECOND_SESSION:
                    cost = getString(R.string.RS100);
                    break;
                case AppConstants.THIRD_SESSION:
                    cost = getString(R.string.RS200);
                    break;
                case AppConstants.SPECIAL_SESSION:
                    cost = getString(R.string.RS500);
                    break;
            }

        tvBillSupDetails.setText(cost);

        buttonStartSession = view.findViewById(R.id.buttonStartSession);
        buttonStartSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SessionActivity.class);
                intent.putExtra(AppConstants.SESSION_TYPE, sessionType)    ;
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });
        return view;
    }

}
