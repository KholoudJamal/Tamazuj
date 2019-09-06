package com.Tamazj.TamazjApp.UserFragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.Tamazj.TamazjApp.Adapter.ProfileAttachmentsAdapter;
import com.Tamazj.TamazjApp.Adapter.ProfileInformationAdapter;
import com.Tamazj.TamazjApp.Model.ProfileInformation;
import com.Tamazj.TamazjApp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;


public class UserProfileFragment extends Fragment {

    View view;
    ImageButton blueBack, editProfile, profileImage;
    TextView name, email, description;
    RecyclerView profileInformationRecyclerView;
    RecyclerView profileAttachmentsRecyclerView;
    List<ProfileInformation> profileInformation;
    ProfileInformationAdapter profileInformationAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_user_profile, container, false);

        blueBack = view.findViewById(R.id.blueBack);
        blueBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        editProfile = view.findViewById(R.id.editProfileIcon);
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new UserEditProfileFragment(), "HomeFragment").commit();
            }
        });
        profileImage = view.findViewById(R.id.profileImage);
        Picasso.with(getContext()).load(getURLForResource(R.drawable.imageprofile)).transform(new CropCircleTransformation()).into(profileImage);

        name = view.findViewById(R.id.tvFullNameProfile);
        email = view.findViewById(R.id.tvEmailProfile);
        description = view.findViewById(R.id.profileDescription);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        profileInformationRecyclerView = view.findViewById(R.id.profileInformation);
        profileInformationRecyclerView.setLayoutManager(layoutManager);

        profileInformation = new ArrayList<>();
        profileInformation.add(new ProfileInformation(R.drawable.sex, getString(R.string.male)));
        profileInformation.add(new ProfileInformation(R.drawable.country, getString(R.string.sudia)));
        profileInformation.add(new ProfileInformation(R.drawable.calander, getString(R.string.date_dat)));
        profileInformation.add(new ProfileInformation(R.drawable.university, getString(R.string.BA)));
        profileInformation.add(new ProfileInformation(R.drawable.freework, getString(R.string.privacy_work)));
        profileInformation.add(new ProfileInformation(R.drawable.married, getString(R.string.married)));


        profileInformationAdapter = new ProfileInformationAdapter(getContext(), profileInformation);
        profileInformationRecyclerView.setAdapter(profileInformationAdapter);


        return view;
    }

    public String getURLForResource (int resourceId) {
        return Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +resourceId).toString();
    }

}