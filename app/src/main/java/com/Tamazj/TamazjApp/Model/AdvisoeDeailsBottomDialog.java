package com.Tamazj.TamazjApp.Model;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.Tamazj.TamazjApp.Activity.BillActivity;
import com.Tamazj.TamazjApp.Adapter.SessionAdapter;
import com.Tamazj.TamazjApp.Adapter.TextViewAdapter;
import com.Tamazj.TamazjApp.Api.MyApplication;
import com.Tamazj.TamazjApp.R;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

public class AdvisoeDeailsBottomDialog extends BottomSheetDialogFragment {

    View viewDialog;
    TextView tvRatePercent, tvAdvisorName, tvAdvisorDescription, firstSession, secondSession, thirdSession, specialSession;
    ImageButton dialogButtonCancel, profileImage, firstSessionButton, secondSessionButton, thirdSessionButton, specialSessionButton;
    RecyclerView rvConsults;
    List<String> list;
    TextViewAdapter textViewAdapter;
    String consultType;
    private RecyclerView SessionRecycler;
    LinearLayoutManager linearLayoutManager ;
    List<Session.DataBean> sessionlist=new ArrayList<>();

    SessionAdapter sessionAdapter;

    String ADVISOR_ID, lang;


    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        viewDialog = View.inflate(getContext(), R.layout.advisor_details_layout, null);
        dialog.setContentView(viewDialog);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(AppConstants.KEY_SIGN_UP, MODE_PRIVATE);
        if(sharedPreferences != null && sharedPreferences.getString(AppConstants.LANG_choose,Locale.getDefault().getLanguage()) != null){
            lang = sharedPreferences.getString(AppConstants.LANG_choose,Locale.getDefault().getLanguage());
        } else {
            lang = Locale.getDefault().getLanguage();
        }

        Bundle bundle = getArguments();
        if( bundle != null && bundle.getString(AppConstants.ADVISOR_ID)!= null){
            ADVISOR_ID = bundle.getString(AppConstants.ADVISOR_ID);
            //Toast.makeText(getContext(), ""+ADVISOR_ID, Toast.LENGTH_SHORT).show();
            getData(ADVISOR_ID);
        } else {
            Toast.makeText(getContext(), ""+getString(R.string.tryAgain), Toast.LENGTH_SHORT).show();
        }

        dialogButtonCancel =  viewDialog.findViewById(R.id.cancelButton);
        tvRatePercent =  viewDialog.findViewById(R.id.tvRatePercent);
        tvAdvisorName =  viewDialog.findViewById(R.id.tvAdvisorName);
        tvAdvisorDescription =  viewDialog.findViewById(R.id.tvAdvisorDescription);
        profileImage =  viewDialog.findViewById(R.id.profileImage);
        rvConsults =  viewDialog.findViewById(R.id.rvConsults);
        firstSession = viewDialog.findViewById(R.id.firstSession);
        secondSession = viewDialog.findViewById(R.id.secondSession);
        thirdSession = viewDialog.findViewById(R.id.thirdSession);
        specialSession = viewDialog.findViewById(R.id.specialSession);
        firstSessionButton = viewDialog.findViewById(R.id.firstSessionButton);
        secondSessionButton = viewDialog.findViewById(R.id.secondSessionButton);
        thirdSessionButton = viewDialog.findViewById(R.id.thirdSessionButton);
        specialSessionButton = viewDialog.findViewById(R.id.specialSessionButton);
        list = new ArrayList<String>();
//        list.add(getString(R.string.family_consultane));
//        list.add(getString(R.string.family_consultane));
//        list.add(getString(R.string.family_consultane));
        textViewAdapter = new TextViewAdapter(getContext(), list);
        textViewAdapter.setiClickListener(new TextViewAdapter.IClickListener() {
            @Override
            public void onItemClick(int position, String text) {
                consultType = text;
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvConsults.setLayoutManager(layoutManager);
        rvConsults.setAdapter(textViewAdapter);
        SessionRecycler=viewDialog.findViewById(R.id.sessionRecycler);
        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        SessionRecycler.setHasFixedSize(true);
        sessionAdapter = new SessionAdapter(getContext(),sessionlist);

        getSessionTime();



        final Intent intent = new Intent(getActivity(), BillActivity.class);

        dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });






    }



    public void getSessionTime() {

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

    private void getData(String ADVISOR_ID) {

        showDialog();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConstants.ADVISOR_CONSULTANT+ADVISOR_ID, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(getContext(), ""+AppConstants.ADVISOR_CONSULTANT+ADVISOR_ID, Toast.LENGTH_SHORT).show();
                try {
                    JSONObject js = new JSONObject(response);
                    JSONObject jsonObject = js.getJSONObject("data");
//                    for(int i=0;i<jsonArray.length();i++){
                    try {
                        //JSONObject jsonObject =  jsonArray.getJSONObject(i);
                        String name =jsonObject.get("name").toString();
                        tvAdvisorName.setText(name);
                        String photo = jsonObject.get("photo").toString();
                        Picasso.with(getContext())
                                .load(photo)
                                .error(R.drawable.image)
                                .into(profileImage);
                        String rating = jsonObject.get("rating").toString()+"%";
                        tvRatePercent.setText(rating);
                        JSONArray jsonArrayCategory = jsonObject.getJSONArray("category");
                        for(int j=0;j<jsonArrayCategory.length();j++){
                            try {
                                JSONObject jsonObject2 =  jsonArrayCategory.getJSONObject(j);
                                String category;
                                if(lang.equals("ar"))
                                    category =jsonObject2.get("name_ar").toString();
                                else category =jsonObject2.get("name_en").toString();
                                list.add(category);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    // }

                }catch (JSONException e) {
                    e.printStackTrace();
                    Log.e("WAFAA", e.toString());
                    hideDialog();
                }




                //}
                Log.e("WAFAA", response.toString());

                textViewAdapter.notifyDataSetChanged();
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
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> map = new HashMap();
                    map.put("lang", lang);
                    return map;

                }
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

}
