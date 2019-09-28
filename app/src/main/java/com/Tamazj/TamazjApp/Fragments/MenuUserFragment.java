package com.Tamazj.TamazjApp.Fragments;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.Tamazj.TamazjApp.Activity.SignInActivity;
import com.Tamazj.TamazjApp.Activity.SplashActivity;
import com.Tamazj.TamazjApp.Activity.UserprofileActivity;
import com.Tamazj.TamazjApp.Api.MyApplication;
import com.Tamazj.TamazjApp.Model.AppConstants;
import com.Tamazj.TamazjApp.R;
import com.Tamazj.TamazjApp.UserFragment.ConsoultUserFragment;
import com.Tamazj.TamazjApp.UserFragment.UserNotificationsFragment;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

public class MenuUserFragment extends Fragment {

    View view;
    ImageButton signOut, profile, search;
    TextView myAccount, notification, consultingRecord, aboutApp, settings;
    ImageButton personalprofile;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor_signUp;
    Dialog dialog;
    String token;
    private TextView mTvFullNameMenu;
    private TextView mTvEmailMenu;
    ProgressDialog progressDialog;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_menu_user, container, false);

        myAccount = view.findViewById(R.id.tvMenuMyAccount);
        notification = view.findViewById(R.id.tvMenuNotification);
        consultingRecord = view.findViewById(R.id.tvMenuMyConsultingRecord);
        aboutApp = view.findViewById(R.id.tvMenuAboutApp);
        settings = view.findViewById(R.id.tvMenuSettings);
        profile = view.findViewById(R.id.personalprofile);
        search = view.findViewById(R.id.search);
        personalprofile = view.findViewById(R.id.personalprofile);
        mTvFullNameMenu = view.findViewById(R.id.tvFullNameMenu);
        mTvEmailMenu = view.findViewById(R.id.tvEmailMenu);
        signOut = view.findViewById(R.id.imSignOut);
        progressDialog = new ProgressDialog(getActivity());

        sharedPreferences = getActivity().getSharedPreferences(AppConstants.KEY_SIGN_UP, MODE_PRIVATE);
        if (sharedPreferences != null) {
            token = sharedPreferences.getString(AppConstants.token, "default value");
            getUserProfile(token);



        }

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.custome_dialog_exit);
                Button yes = dialog.findViewById(R.id.yes);
                Button no = dialog.findViewById(R.id.no);
                ImageView close = dialog.findViewById(R.id.imageexitgame);

                dialog.setCancelable(true);

                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (sharedPreferences != null) {
                            token = sharedPreferences.getString(AppConstants.token, "default value");
                            logout(AppConstants.USER_LOGOUT, token);

                        } else {

                            Intent intent = new Intent(getActivity(), SignInActivity.class);
                            startActivity(intent);
                            getActivity().finish();
                        }


                    }
                });
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();

                    }
                });


                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();

                    }
                });

                dialog.show();


            }
        });
        personalprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserprofileActivity.class);
                getActivity().startActivity(intent);
            }
        });

        myAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserprofileActivity.class);
                getActivity().startActivity(intent);
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new UserNotificationsFragment(), "HomeFragment").commit();
            }
        });

        consultingRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new ConsoultUserFragment(), "HomeFragment").commit();
            }
        });

        return view;

    }

    public void logout(final String link, final String token) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, link, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject register_response = new JSONObject(response);
                    int status = register_response.getInt("status");
                    String message = register_response.getString("message");
                    Log.e("WAFAA", response);

                    if (status == 1) {
                        sharedPreferences = getActivity().getSharedPreferences(AppConstants.KEY_SIGN_UP, MODE_PRIVATE);
                        editor_signUp = sharedPreferences.edit();
                        editor_signUp.clear();
                        editor_signUp.apply();
                        editor_signUp.commit();
                        Intent intent = new Intent(getActivity(), SplashActivity.class);
                        intent.putExtra(AppConstants.ISLOGIN, false);
                        startActivity(intent);
                        getActivity().finish();
                        Toast.makeText(getActivity(), "" + message, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "" + getActivity().getString(R.string.not_exist_message), Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap();
                map.put("Authorization", "Bearer" + " " + token);


                return map;

            }

            @Override
            public Map<String, String> getHeaders() {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer" + " " + token);
                return headers;
            }

        };

        MyApplication.getInstance().addToRequestQueue(stringRequest);


    }



    public void getUserProfile(final String token) {

        showDialog();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConstants.USER_PROFILE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("HZM", response);

                try {
                    JSONObject task_respnse = new JSONObject(response);
                    JSONObject taskarray = task_respnse.getJSONObject("data");
                    String name = taskarray.getString("name");
                    String email = taskarray.getString("email");
                    String gender = taskarray.getString("gender");
                    String nationality = taskarray.getString("nationality");
                    String work_status = taskarray.getString("work_status");
                    String educational_status = taskarray.getString("educational_status");
                    String photo = taskarray.getString("photo");
                    String status = taskarray.getString("status");
                    mTvFullNameMenu.setText(name);
                    mTvEmailMenu.setText(email);
                    hideDialog();











                } catch (JSONException e1) {
                    e1.printStackTrace();

                }


               hideDialog();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                hideDialog();


            }
        })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer" + "  " + token);

                return headers;

            }


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer" + "  " + token);

                return headers;
            };
        };

        MyApplication.getInstance().addToRequestQueue(stringRequest);

    }


    public void showDialog() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(getString(R.string.load_data));
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void hideDialog() {

        if (progressDialog.isShowing()) progressDialog.dismiss();
    }

}
