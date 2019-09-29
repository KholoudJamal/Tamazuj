package com.Tamazj.TamazjApp.Fragments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.Tamazj.TamazjApp.Adapter.ReviewAdapter;
import com.Tamazj.TamazjApp.Adapter.SessionAdapterwithoutImage;
import com.Tamazj.TamazjApp.Adapter.TextViewAdapter;
import com.Tamazj.TamazjApp.Api.MyApplication;
import com.Tamazj.TamazjApp.Model.AdvisoeDeailsBottomDialog;
import com.Tamazj.TamazjApp.Model.AppConstants;
import com.Tamazj.TamazjApp.Model.Review;
import com.Tamazj.TamazjApp.Model.Session;
import com.Tamazj.TamazjApp.R;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowAdvisorInformationFragment extends Fragment {

    View view, aboutReviewsView;
    ImageButton blueBack, profileImage;
    TextView tvAdvisorName, tvRatePercent, tvAskConsult, tvAdvisorAbout, tvAdvisorReviews, tvAboutAdvisorText;
    RecyclerView rvShowAdvisorInf ,rvBeneficiariesFeedback;
    LayoutInflater inf;
    List<String> listShowAdvisorInf;
    TextViewAdapter textViewAdapter;
    List<Review> list;
    ReviewAdapter adapter;
    private RecyclerView SessionRecycler;
    LinearLayoutManager linearLayoutManager ;
    List<Session.DataBean> sessionlist=new ArrayList<>();

    SessionAdapterwithoutImage sessionAdapter;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor_signUp;
    String choosing_langauge;
    String token;

    @SuppressLint("WrongConstant")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_show_advisor_information, container, false);
        sharedPreferences = getActivity().getSharedPreferences(AppConstants.KEY_SIGN_UP, MODE_PRIVATE);

        blueBack = view.findViewById(R.id.blueBack);
        blueBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();      }
        });

        inf = LayoutInflater.from(getContext());

        profileImage = view.findViewById(R.id.profileImage);
        tvAdvisorName = view.findViewById(R.id.tvAdvisorName);
        tvRatePercent = view.findViewById(R.id.tvRatePercent);
        rvShowAdvisorInf = view.findViewById(R.id.rvShowAdvisorInf);
        tvAskConsult = view.findViewById(R.id.tvAskConsult);
        tvAdvisorAbout = view.findViewById(R.id.tvAdvisorAbout);
        tvAdvisorReviews = view.findViewById(R.id.tvAdvisorReviews);

        listShowAdvisorInf = new ArrayList<>();
        listShowAdvisorInf.add(getString(R.string.family_consultane));
        listShowAdvisorInf.add(getString(R.string.family_consultane));
        listShowAdvisorInf.add(getString(R.string.family_consultane));
        textViewAdapter = new TextViewAdapter(getContext(), listShowAdvisorInf);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvShowAdvisorInf.setLayoutManager(layoutManager);
        rvShowAdvisorInf.setAdapter(textViewAdapter);
        SessionRecycler=view.findViewById(R.id.sessionRecycler);
        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        SessionRecycler.setHasFixedSize(true);
        sessionAdapter = new SessionAdapterwithoutImage(getContext(),sessionlist);
        ConnectivityManager conMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            if (sharedPreferences != null) {
                if (sharedPreferences.getString(AppConstants.LANG_choose, null) != null) {
                    choosing_langauge = sharedPreferences.getString(AppConstants.LANG_choose, "");
                    token = sharedPreferences.getString(AppConstants.token, "default value");

                    getSessionTime(choosing_langauge,token);

                }
            }
        }

        else {
            Toast.makeText(getActivity(), ""+getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
        }

        aboutReviewsView = inf.inflate(R.layout.advisor_about_layout,null);
        tvAboutAdvisorText = aboutReviewsView.findViewById(R.id.tvAboutAdvisorText);

        tvAskConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdvisoeDeailsBottomDialog advisoeDeailsBottomDialog = new AdvisoeDeailsBottomDialog();
                advisoeDeailsBottomDialog.show(getFragmentManager(), advisoeDeailsBottomDialog.getTag());

            }
        });

        tvAdvisorAbout.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                tvAdvisorAbout.setBackground(getContext().getDrawable(R.drawable.light_blue_bacground));
                tvAdvisorAbout.setTextColor(R.color.colorBlue);
                tvAdvisorReviews.setBackground(null);
                tvAdvisorReviews.setTextColor(R.color.colorBlack);

                aboutReviewsView = inf.inflate(R.layout.advisor_about_layout,null);
                tvAboutAdvisorText = aboutReviewsView.findViewById(R.id.tvAboutAdvisorText);

            }
        });

        tvAdvisorReviews.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                tvAdvisorReviews.setBackground(getContext().getDrawable(R.drawable.light_blue_bacground));
                tvAdvisorReviews.setTextColor(R.color.colorBlue);
                tvAdvisorAbout.setBackground(null);
                tvAdvisorAbout.setTextColor(R.color.colorBlack);

                aboutReviewsView = inf.inflate(R.layout.advisor_reviews_layout,null);
                rvBeneficiariesFeedback = aboutReviewsView.findViewById(R.id.rvBeneficiariesFeedback);

                list = new ArrayList<>();
                list.add(new Review(getURLForResource(R.drawable.advisorreview),getString(R.string.FeedbackTime),getString(R.string.esaIbraheem),AppConstants.HAPPY,getString(R.string.notificationText)));
                list.add(new Review(getURLForResource(R.drawable.advisorreview),getString(R.string.FeedbackTime),getString(R.string.esaIbraheem),AppConstants.SATISFIED,getString(R.string.notificationText)));
                list.add(new Review(getURLForResource(R.drawable.advisorreview),getString(R.string.FeedbackTime),getString(R.string.esaIbraheem),AppConstants.NOT_SATISFIED,getString(R.string.notificationText)));
                adapter = new ReviewAdapter(getContext(), list);
                @SuppressLint("WrongConstant") RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                rvBeneficiariesFeedback.setLayoutManager(layoutManager);
                rvBeneficiariesFeedback.setAdapter(adapter);

            }
        });



        return view;
    }


    public String getURLForResource (int resourceId) {
        return Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +resourceId).toString();
    }


    public void getSessionTime(final String lang,final String token) {

        // showDialog();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConstants.session_times, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Wafaa", response);

                try {
                    JSONObject session_response = new JSONObject(response);
                    JSONArray jsonArray = session_response.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        int id = jsonArray.getJSONObject(i).getInt("id");
                        String time =  jsonArray.getJSONObject(i).getString("time");
                        String price =  jsonArray.getJSONObject(i).getString("price");
                        Session.DataBean session = new Session.DataBean();
                        session.setId(id);
                        session.setPrice(price);
                        session.setTime(time);
                        sessionlist.add(session);

                    }

                    SessionRecycler.setLayoutManager(linearLayoutManager);
                    SessionRecycler.setAdapter(sessionAdapter);
                    sessionAdapter.notifyDataSetChanged();



                } catch (JSONException e1) {
                    e1.printStackTrace();
                    // hideDialog();

                }


                // hideDialog();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {



            }
        })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("lang", lang);
                headers.put("Authorization", "Bearer" + "  " + token);

                return headers;

            }


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();

                return headers;
            };
        };

        MyApplication.getInstance().addToRequestQueue(stringRequest);

    }


}
