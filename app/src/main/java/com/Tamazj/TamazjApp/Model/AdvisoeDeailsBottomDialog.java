package com.Tamazj.TamazjApp.Model;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @SuppressLint({"RestrictedApi", "WrongConstant"})
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        viewDialog = View.inflate(getContext(), R.layout.advisor_details_layout, null);
        dialog.setContentView(viewDialog);

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
        list.add(getString(R.string.family_consultane));
        list.add(getString(R.string.family_consultane));
        list.add(getString(R.string.family_consultane));
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


}
