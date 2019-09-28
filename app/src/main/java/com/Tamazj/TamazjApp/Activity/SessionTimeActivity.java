package com.Tamazj.TamazjApp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;

import com.Tamazj.TamazjApp.Adapter.SessionAdapterwithoutImage;
import com.Tamazj.TamazjApp.Api.MyApplication;
import com.Tamazj.TamazjApp.Model.AppConstants;
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

public class SessionTimeActivity extends AppCompatActivity {
    private RecyclerView SessionRecycler;
    LinearLayoutManager linearLayoutManager ;
    List<Session.DataBean> sessionlist=new ArrayList<>();

    SessionAdapterwithoutImage sessionAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_time);
        SessionRecycler=findViewById(R.id.sessionRecycler);
        linearLayoutManager = new LinearLayoutManager(SessionTimeActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        SessionRecycler.setHasFixedSize(true);
        sessionAdapter = new SessionAdapterwithoutImage(getApplicationContext(),sessionlist);

        getSessionTime();

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
