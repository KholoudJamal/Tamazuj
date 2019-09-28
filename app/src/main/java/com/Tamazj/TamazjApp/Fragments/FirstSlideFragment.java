package com.Tamazj.TamazjApp.Fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Tamazj.TamazjApp.Model.AdvisoeDeailsBottomDialog;
import com.Tamazj.TamazjApp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstSlideFragment extends Fragment {
    ImageView profileimage;
    TextView percent;
    TextView profile_name;
    TextView profile_dsc;
    ImageView askasteschar;
    View view;
    CardView cardview;



    public FirstSlideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

                view=inflater.inflate(R.layout.fragment_first_slide, container, false);

        percent = view.findViewById(R.id.percent);
        profileimage = view.findViewById(R.id.profileimage);
        profile_name = view.findViewById(R.id.profile_name);
        profile_dsc = view.findViewById(R.id.profile_dsc);
        askasteschar=view.findViewById(R.id.askasteschar);
        cardview=view.findViewById(R.id.cardview);
        askasteschar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdvisoeDeailsBottomDialog advisoeDeailsBottomDialog = new AdvisoeDeailsBottomDialog();
                advisoeDeailsBottomDialog.show(getFragmentManager(), advisoeDeailsBottomDialog.getTag());

            }
        });

        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new CategoriesdetailsFragment(), "HomeFragment").commit();


            }
        });

        profileimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;

    }

}
