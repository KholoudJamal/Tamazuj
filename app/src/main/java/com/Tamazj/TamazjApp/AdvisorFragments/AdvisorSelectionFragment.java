package com.Tamazj.TamazjApp.AdvisorFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.Tamazj.TamazjApp.Adapter.CategoriesAdapter;
import com.Tamazj.TamazjApp.Adapter.CategoriesAdapterwithouttype;
import com.Tamazj.TamazjApp.Fragments.HomeFragment;
import com.Tamazj.TamazjApp.Fragments.MyConsultationragment;
import com.Tamazj.TamazjApp.Model.Categories;
import com.Tamazj.TamazjApp.Model.FilterBottomDialog;
import com.Tamazj.TamazjApp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdvisorSelectionFragment extends Fragment {
    View view;
    private RecyclerView categoriesrecycler;
    LinearLayoutManager linearLayout ;
    List<Categories> categories=new ArrayList<>();
    CategoriesAdapterwithouttype categoriesAdapterwithouttype;
    ImageButton buttonsearch;
    ImageButton buttonCancel;



    public AdvisorSelectionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view= inflater.inflate(R.layout.fragment_advisor_selection, container, false);
        categoriesrecycler = view.findViewById(R.id.categoriesrecycler);
        linearLayout = new LinearLayoutManager(getContext());
        categoriesrecycler.setLayoutManager(linearLayout);
        categoriesrecycler.setHasFixedSize(true);
        buttonCancel=view.findViewById(R.id.buttonCancel);
        buttonsearch=view.findViewById(R.id.buttonsearch);


        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new HomeFragment(), "HomeFragment").commit();


            }
        });


        categories.add(new Categories(getResources().getString(R.string._84_percent_of)," https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file ",getResources().getString(R.string.abu_dall_mohammed_omar),getResources().getString(R.string.educational_consultant_holding_an_international_certificate_in_education),getResources().getString(R.string.consultType)));
        categories.add(new Categories(getResources().getString(R.string._84_percent_of)," https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file ",getResources().getString(R.string.abu_dall_mohammed_omar),getResources().getString(R.string.educational_consultant_holding_an_international_certificate_in_education),getResources().getString(R.string.consultType)));
        categories.add(new Categories(getResources().getString(R.string._84_percent_of)," https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file ",getResources().getString(R.string.abu_dall_mohammed_omar),getResources().getString(R.string.educational_consultant_holding_an_international_certificate_in_education),getResources().getString(R.string.consultType)));
        categories.add(new Categories(getResources().getString(R.string._84_percent_of)," https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file ",getResources().getString(R.string.abu_dall_mohammed_omar),getResources().getString(R.string.educational_consultant_holding_an_international_certificate_in_education),getResources().getString(R.string.consultType)));
        categories.add(new Categories(getResources().getString(R.string._84_percent_of)," https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file ",getResources().getString(R.string.abu_dall_mohammed_omar),getResources().getString(R.string.educational_consultant_holding_an_international_certificate_in_education),getResources().getString(R.string.consultType)));
        categories.add(new Categories(getResources().getString(R.string._84_percent_of)," https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file ",getResources().getString(R.string.abu_dall_mohammed_omar),getResources().getString(R.string.educational_consultant_holding_an_international_certificate_in_education),getResources().getString(R.string.consultType)));
        categories.add(new Categories(getResources().getString(R.string._84_percent_of)," https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file ",getResources().getString(R.string.abu_dall_mohammed_omar),getResources().getString(R.string.educational_consultant_holding_an_international_certificate_in_education),getResources().getString(R.string.consultType)));
        categoriesAdapterwithouttype=new CategoriesAdapterwithouttype(getContext(),categories);
        categoriesrecycler.setAdapter(categoriesAdapterwithouttype);


        return view;
    }

}
