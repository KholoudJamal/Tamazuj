package com.Tamazj.TamazjApp.Fragments;


import android.content.Intent;
import android.os.Bundle;
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
import com.Tamazj.TamazjApp.Adapter.Areas_Counseling_selection_adapter;
import com.Tamazj.TamazjApp.Model.Areas_Counseling_Model;
import com.Tamazj.TamazjApp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategorySelectionFragment extends Fragment {
    View view;
    private RecyclerView mAreasCounseling;
    LinearLayoutManager linearLayoutManager ;
    List<Areas_Counseling_Model> areas_counseling_models=new ArrayList<>();
    Areas_Counseling_selection_adapter areas_counseling_selection_adapter;
    ImageView blueBack;



    public CategorySelectionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view=inflater.inflate(R.layout.fragment_category_selection, container, false);
        mAreasCounseling = view.findViewById(R.id.categoriesrecycler);

        linearLayoutManager = new LinearLayoutManager(getContext());
        mAreasCounseling.setLayoutManager(linearLayoutManager);
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
        areas_counseling_selection_adapter=new Areas_Counseling_selection_adapter(getContext(),areas_counseling_models);
        mAreasCounseling.setAdapter(areas_counseling_selection_adapter);


        return view;
    }

}
