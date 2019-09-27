package com.Tamazj.TamazjApp.UserFragment;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
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

import com.Tamazj.TamazjApp.Adapter.ProfileInformationAdapter;
import com.Tamazj.TamazjApp.Api.MyApplication;
import com.Tamazj.TamazjApp.Model.AppConstants;
import com.Tamazj.TamazjApp.Model.ProfileInformation;
import com.Tamazj.TamazjApp.R;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

import static android.content.Context.MODE_PRIVATE;


public class UserProfileFragment extends Fragment {

    View view;
    ImageButton blueBack, editProfile;
    CircleImageView profileImage;
    TextView name, email, description;
    RecyclerView profileInformationRecyclerView;
    RecyclerView profileAttachmentsRecyclerView;
    List<ProfileInformation> profileInformation;
    ProfileInformationAdapter profileInformationAdapter;
    ProgressDialog progressDialog;
    String token;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor_signUp;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_user_profile, container, false);

        blueBack = view.findViewById(R.id.blueBack);
        blueBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        sharedPreferences = getActivity().getSharedPreferences(AppConstants.KEY_SIGN_UP, MODE_PRIVATE);
        if (sharedPreferences != null) {
            token = sharedPreferences.getString(AppConstants.token, "default value");
            ConnectivityManager conMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = conMgr.getActiveNetworkInfo();

            if (networkInfo != null && networkInfo.isConnected()) {
                getUserProfile(token);

            }
            else {
                Toast.makeText(getActivity(), ""+getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
            }





        }

        editProfile = view.findViewById(R.id.editProfileIcon);
        progressDialog = new ProgressDialog(getActivity());

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, new UserEditProfileFragment(), "HomeFragment").commit();
            }
        });
        profileImage = view.findViewById(R.id.profileImage);

        name = view.findViewById(R.id.tvFullNameProfile);
        email = view.findViewById(R.id.tvEmailProfile);
        description = view.findViewById(R.id.profileDescription);

        @SuppressLint("WrongConstant") RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        profileInformationRecyclerView = view.findViewById(R.id.profileInformation);
        profileInformationRecyclerView.setLayoutManager(layoutManager);

        profileInformation = new ArrayList<>();




        return view;
    }

    public String getURLForResource (int resourceId) {
        return Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +resourceId).toString();
    }


    public void getUserProfile(final String token) {

     // showDialog();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConstants.USER_PROFILE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Wafaa", response);

                try {
                    JSONObject task_respnse = new JSONObject(response);
                    JSONObject taskarray = task_respnse.getJSONObject("data");
                    String username = taskarray.getString("name");
                    String useremail = taskarray.getString("email");
                    String gender = taskarray.getString("gender");
                    String nationality = taskarray.getString("nationality");
                    String work_status = taskarray.getString("work_status");
                    String educational_status = taskarray.getString("educational_status");
                    String photo = taskarray.getString("photo");
                   // String date_of_birth=task_respnse.getString("date_of_birth");
                    String date_of_birth="";

                    if(date_of_birth.matches("")|| date_of_birth.matches(null)){
                        date_of_birth="2/4/1989";

                    }
                   String social_status = taskarray.getString("social_status");
                    String status = taskarray.getString("status");
                    name.setText(username);
                    email.setText(useremail);

                    Picasso.with(getContext()).
                            load(photo)
                            .transform(new CropCircleTransformation()).into(profileImage);

                    profileInformation.add(new ProfileInformation(R.drawable.sex, gender));
                    profileInformation.add(new ProfileInformation(R.drawable.country, nationality));
                    profileInformation.add(new ProfileInformation(R.drawable.calander, date_of_birth));
                    profileInformation.add(new ProfileInformation(R.drawable.university, educational_status));
                    profileInformation.add(new ProfileInformation(R.drawable.freework, work_status));
                    profileInformation.add(new ProfileInformation(R.drawable.married, social_status));

                    profileInformationAdapter = new ProfileInformationAdapter(getContext(), profileInformation);
                    profileInformationRecyclerView.setAdapter(profileInformationAdapter);
                   // hideDialog();

                } catch (JSONException e1) {
                    e1.printStackTrace();
                // hideDialog();

                }


            // hideDialog();


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
