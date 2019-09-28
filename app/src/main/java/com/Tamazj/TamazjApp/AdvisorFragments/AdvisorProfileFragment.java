package com.Tamazj.TamazjApp.AdvisorFragments;

import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import de.hdodenhof.circleimageview.CircleImageView;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;


public class AdvisorProfileFragment extends Fragment {

    View view;
    ImageButton blueBack, editProfile;
    TextView name, email, description;
    CircleImageView profileImage;
    RecyclerView profileInformationRecyclerView;
    RecyclerView profileAttachmentsRecyclerView;
    List<ProfileInformation> profileInformation;
    List<ProfileInformation> profileAttachments;
    ProfileInformationAdapter profileInformationAdapter;
    ProfileAttachmentsAdapter profileAttachmentsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_advisor_profile, container, false);

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
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.advisorProfileContainer, new AdvisorEditProfileFragment(), "HomeFragment").commit();
            }
        });
        profileImage = view.findViewById(R.id.profileImage);
        Picasso.with(getContext()).load(getURLForResource(R.drawable.imageprofile)).transform(new CropCircleTransformation()).into(profileImage);

        name = view.findViewById(R.id.tvFullNameProfile);
        email = view.findViewById(R.id.tvEmailProfile);
        description = view.findViewById(R.id.profileDescription);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        profileInformationRecyclerView = view.findViewById(R.id.profileInformation);
        profileInformationRecyclerView.setLayoutManager(layoutManager);

        profileInformation = new ArrayList<>();
        profileInformation.add(new ProfileInformation(R.drawable.sex, getString(R.string.male)));
        profileInformation.add(new ProfileInformation(R.drawable.country, getString(R.string.sudia)));
        profileInformation.add(new ProfileInformation(R.drawable.calander, getString(R.string.date_dat)));
        profileInformation.add(new ProfileInformation(R.drawable.university, getString(R.string.BA)));
        profileInformation.add(new ProfileInformation(R.drawable.freework, getString(R.string.privacy_work)));
        profileInformation.add(new ProfileInformation(R.drawable.married, getString(R.string.married)));
        profileInformation.add(new ProfileInformation(R.drawable.location, getString(R.string.sudiaArabia)));
        profileInformation.add(new ProfileInformation(R.drawable.language, getString(R.string.language)));

        profileInformationAdapter = new ProfileInformationAdapter(getContext(), profileInformation);
        profileInformationRecyclerView.setAdapter(profileInformationAdapter);

        profileAttachmentsRecyclerView = view.findViewById(R.id.profileAttachments);
        profileAttachmentsRecyclerView.setLayoutManager(layoutManager2);

        profileAttachments = new ArrayList<>();
        profileAttachments.add(new ProfileInformation(getString(R.string.identity)));
        profileAttachments.add(new ProfileInformation(getString(R.string.qualification)));
        profileAttachments.add(new ProfileInformation(getString(R.string.cv)));

        profileAttachmentsAdapter = new ProfileAttachmentsAdapter(getContext(), profileAttachments);
        profileAttachmentsRecyclerView.setAdapter(profileAttachmentsAdapter);


        return view;
    }

    public String getURLForResource (int resourceId) {
        return Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +resourceId).toString();
    }

}
