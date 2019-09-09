package com.Tamazj.TamazjApp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.Tamazj.TamazjApp.Adapter.Areas_Counseling_adapter;
import com.Tamazj.TamazjApp.Adapter.CategoriesAdapter;
import com.Tamazj.TamazjApp.AdvisorFragments.HomeAdvisorFragment;
import com.Tamazj.TamazjApp.Model.AppConstants;
import com.Tamazj.TamazjApp.Model.Areas_Counseling_Model;
import com.Tamazj.TamazjApp.Model.Categories;
import com.Tamazj.TamazjApp.Model.EditPasswordBottomDialog;
import com.Tamazj.TamazjApp.Model.FilterBottomDialog;
import com.Tamazj.TamazjApp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesdetailsFragment extends Fragment {
    View view;
    private RecyclerView  categoriesrecycler;
    LinearLayoutManager linearLayout ;
    List<Categories> categories=new ArrayList<>();
    CategoriesAdapter categoriesAdapter;
    ImageView blueBack;
    ImageView filter;
    ImageView astesharticontoolbar;
    TextView toolbartiltle;




    public CategoriesdetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_categoriesdetails, container, false);
        // Inflate the layout for this fragment
        categoriesrecycler = view.findViewById(R.id.categoriesrecycler);
        linearLayout = new LinearLayoutManager(getContext());
        categoriesrecycler.setLayoutManager(linearLayout);
        categoriesrecycler.setHasFixedSize(true);
        filter=view.findViewById(R.id.filter);
        blueBack=view.findViewById(R.id.blueBack);
        toolbartiltle=view.findViewById(R.id.toolbartiltle);
        astesharticontoolbar=view.findViewById(R.id.astesharticontoolbar);

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FilterBottomDialog filterBottomDialog = new FilterBottomDialog();
                filterBottomDialog.show(getFragmentManager(), filterBottomDialog.getTag());
            }
        });

        blueBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new HomeFragment(), "HomeFragment").commit();


            }
        });
        astesharticontoolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new MyConsultationragment(), "HomeFragment").commit();


            }
        });

        categories.add(new Categories(getResources().getString(R.string._84_percent_of)," https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file ",getResources().getString(R.string.abu_dall_mohammed_omar),getResources().getString(R.string.educational_consultant_holding_an_international_certificate_in_education),getResources().getString(R.string.consultType)));
        categories.add(new Categories(getResources().getString(R.string._84_percent_of)," https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file ",getResources().getString(R.string.abu_dall_mohammed_omar),getResources().getString(R.string.educational_consultant_holding_an_international_certificate_in_education),getResources().getString(R.string.consultType)));
        categories.add(new Categories(getResources().getString(R.string._84_percent_of)," https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file ",getResources().getString(R.string.abu_dall_mohammed_omar),getResources().getString(R.string.educational_consultant_holding_an_international_certificate_in_education),getResources().getString(R.string.consultType)));
        categories.add(new Categories(getResources().getString(R.string._84_percent_of)," https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file ",getResources().getString(R.string.abu_dall_mohammed_omar),getResources().getString(R.string.educational_consultant_holding_an_international_certificate_in_education),getResources().getString(R.string.consultType)));
        categories.add(new Categories(getResources().getString(R.string._84_percent_of)," https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file ",getResources().getString(R.string.abu_dall_mohammed_omar),getResources().getString(R.string.educational_consultant_holding_an_international_certificate_in_education),getResources().getString(R.string.consultType)));
        categories.add(new Categories(getResources().getString(R.string._84_percent_of)," https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file ",getResources().getString(R.string.abu_dall_mohammed_omar),getResources().getString(R.string.educational_consultant_holding_an_international_certificate_in_education),getResources().getString(R.string.consultType)));
        categories.add(new Categories(getResources().getString(R.string._84_percent_of)," https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file ",getResources().getString(R.string.abu_dall_mohammed_omar),getResources().getString(R.string.educational_consultant_holding_an_international_certificate_in_education),getResources().getString(R.string.consultType)));
        categoriesAdapter=new CategoriesAdapter(getContext(),categories);
        categoriesrecycler.setAdapter(categoriesAdapter);
        Bundle args = getArguments();
        if (args != null) {
            String toolbartiltlestrring =getArguments().getString(AppConstants.toolbartiltle);
            toolbartiltle.setText(toolbartiltlestrring);
        }


        return view;
    }

}
