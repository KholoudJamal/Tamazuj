package com.Tamazj.TamazjApp.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.Tamazj.TamazjApp.Activity.SignInActivity;
import com.Tamazj.TamazjApp.Activity.UserprofileActivity;
import com.Tamazj.TamazjApp.Adapter.Areas_Counseling_adapter;
import com.Tamazj.TamazjApp.Adapter.Distinguished_Advisors_Adapter;
import com.Tamazj.TamazjApp.Api.MyApplication;
import com.Tamazj.TamazjApp.JsonFormate.Consultants;
import com.Tamazj.TamazjApp.MainActivity;
import com.Tamazj.TamazjApp.Model.AppConstants;
import com.Tamazj.TamazjApp.Model.Areas_Counseling_Model;
import com.Tamazj.TamazjApp.Model.Distinguished_Advisors_Model;
import com.Tamazj.TamazjApp.Model.FilterBottomDialog;
import com.Tamazj.TamazjApp.R;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyConsultationragment extends Fragment {
    View view;
    private RecyclerView mAreasCounseling;
    GridLayoutManager gridLayoutManager ;
    List<Distinguished_Advisors_Model> distinguished_advisors_models=new ArrayList<>();
    Distinguished_Advisors_Adapter distinguished_advisors_adapter;
    private Toolbar mToolbar;
    private LinearLayout mLinaree;
    private RecyclerView mDistinguishedAdvisors;
    ImageView blueBack;

    ImageView personalprofile;
    ImageView filter;
    ImageView astesharticontoolbar;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_my_consultationragment, container, false);
        mToolbar = view.findViewById(R.id.toolbar);
        mLinaree = view.findViewById(R.id.linaree);
        mDistinguishedAdvisors = view.findViewById(R.id.Distinguished_Advisors);
        gridLayoutManager = new GridLayoutManager(getContext(),3);
        mDistinguishedAdvisors.setLayoutManager(gridLayoutManager);
        mDistinguishedAdvisors.setHasFixedSize(true);
        personalprofile=view.findViewById(R.id.personalprofile);
        personalprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserprofileActivity.class);
                getActivity().startActivity(intent);
            }
        });


        filter=view.findViewById(R.id.filter);
        astesharticontoolbar=view.findViewById(R.id.astesharticontoolbar);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FilterBottomDialog filterBottomDialog = new FilterBottomDialog();
                filterBottomDialog.show(getFragmentManager(), filterBottomDialog.getTag());
            }
        });


        astesharticontoolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new MyConsultationragment(), "HomeFragment").commit();


            }
        });

        fillList();

//        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات أسرية "));
//        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات أسرية "));
//        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات أسرية "));
//        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات أسرية "));
//        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات نفسية  "));
//        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات أسرية "));
//        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات أسرية "));
//        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات نفسية  "));
//        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات أسرية "));
//        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات أسرية "));
//        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات نفسية  "));
//        distinguished_advisors_models.add(new Distinguished_Advisors_Model("https://www.mediafire.com/view/yyfa6yue2aaqkhs/asteshartosari.png/file","محمد حسن ","استشارات نفسية  "));
//

        distinguished_advisors_adapter = new Distinguished_Advisors_Adapter(getContext(),distinguished_advisors_models);
        mDistinguishedAdvisors.setAdapter(distinguished_advisors_adapter);

        return view;
    }


    //----------------------------------------------------------------------------------------------

    private void fillList() {

            showDialog();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConstants.ADVISORS_CONSULTANTS, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject r = new JSONObject(response);
                    JSONArray jsonArray = r.getJSONArray("data");
                    for(int i=0;i<jsonArray.length();i++){
                        try {
                            JSONObject jsonObject =  jsonArray.getJSONObject(i);
                            String name =jsonObject.get("name").toString();
                            String photo = jsonObject.get("photo").toString();
                            String status = jsonObject.get("status").toString();
                            //Toast.makeText(getContext(), ""+name, Toast.LENGTH_SHORT).show();
                            if(status.matches(AppConstants.ACTIVE))
                            distinguished_advisors_models.add(new Distinguished_Advisors_Model(photo, name, "استشارات  أسرية "));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    distinguished_advisors_adapter.notifyDataSetChanged();

//                    for (int j = 0; j < consultants.size(); j++) {
//                        String name = consultants.get(0).getData().get(j).getName();
//                        String photo = consultants.get(0).getData().get(j).getPhoto();
//                        distinguished_advisors_models.add(new Distinguished_Advisors_Model(photo, name, "استشارات  أسرية "));
//
//
//                    }
                }catch (JSONException e) {
                    e.printStackTrace();
                    Log.e("WAFAA", e.toString());
                    hideDialog();
                }




 //}
                    Log.e("WAFAA", response.toString());


                    hideDialog();


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    hideDialog();
                    Toast.makeText(getContext(), getString(R.string.tryAgain), Toast.LENGTH_SHORT).show();
                    Log.e("WAFAA", error.toString());
                }
            }) {
//                @Override
//                protected Map<String, String> getParams() throws AuthFailureError {
////                    Map<String, String> map = new HashMap();
////                    map.put(,);
////                    return map;
//
//                }
            };

            MyApplication.getInstance().addToRequestQueue(stringRequest);



    }

    //----------------------------------------------------------------------------------------------

    ProgressDialog progressDialog;

    public void showDialog() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage(getString(R.string.load_login));
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void hideDialog() {

        if (progressDialog.isShowing()) progressDialog.dismiss();
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mToolbar = view.findViewById(R.id.toolbar);
        mLinaree = view.findViewById(R.id.linaree);
        mDistinguishedAdvisors = view.findViewById(R.id.Distinguished_Advisors);
    }
}