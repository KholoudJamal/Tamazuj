package com.Tamazj.TamazjApp.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.Tamazj.TamazjApp.Activity.UserprofileActivity;
import com.Tamazj.TamazjApp.Adapter.Areas_Counseling_adapter;
import com.Tamazj.TamazjApp.Adapter.Distinguished_Advisors_Adapter;
import com.Tamazj.TamazjApp.Model.Areas_Counseling_Model;
import com.Tamazj.TamazjApp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends Fragment {
    View view;
    private RecyclerView mAreasCounseling;
    GridLayoutManager mAreasCounselingmanager ;
    List<Areas_Counseling_Model> areas_counseling_models=new ArrayList<>();
    Areas_Counseling_adapter areas_counseling_adapter;
    ImageView personalprofile;




    public CategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                view=inflater.inflate(R.layout.fragment_categories, container, false);
        mAreasCounseling = view.findViewById(R.id.Areas_Counseling);

        mAreasCounselingmanager = new GridLayoutManager(getContext(),3);
        mAreasCounseling.setLayoutManager(mAreasCounselingmanager);
        mAreasCounseling.setHasFixedSize(true);
        areas_counseling_models.add(new Areas_Counseling_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","استشارات أسرية "));
        areas_counseling_models.add(new Areas_Counseling_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","استشارات نفسية "));
        areas_counseling_models.add(new Areas_Counseling_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","السمو بالنفس "));
        areas_counseling_models.add(new Areas_Counseling_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","استشارات أسرية "));
        areas_counseling_models.add(new Areas_Counseling_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","استشارات نفسية "));
        areas_counseling_models.add(new Areas_Counseling_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","السمو بالنفس "));
        areas_counseling_models.add(new Areas_Counseling_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","استشارات أسرية "));
        areas_counseling_models.add(new Areas_Counseling_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","استشارات نفسية "));
        areas_counseling_models.add(new Areas_Counseling_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","السمو بالنفس "));
        areas_counseling_models.add(new Areas_Counseling_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","استشارات أسرية "));
        areas_counseling_models.add(new Areas_Counseling_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","استشارات نفسية "));
        areas_counseling_models.add(new Areas_Counseling_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","السمو بالنفس "));
        areas_counseling_adapter=new Areas_Counseling_adapter(getContext(),areas_counseling_models);
        mAreasCounseling.setAdapter(areas_counseling_adapter);

        personalprofile=view.findViewById(R.id.personalprofile);
        personalprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserprofileActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mAreasCounseling = view.findViewById(R.id.Areas_Counseling);
    }
}
