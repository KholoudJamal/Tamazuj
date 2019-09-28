package com.Tamazj.TamazjApp.UserFragment;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.Tamazj.TamazjApp.Api.MyApplication;
import com.Tamazj.TamazjApp.Model.AppConstants;
import com.Tamazj.TamazjApp.Model.AppHelper;
import com.Tamazj.TamazjApp.Model.Countries;
import com.Tamazj.TamazjApp.Model.EditPasswordBottomDialog;
import com.Tamazj.TamazjApp.Model.ProfileInformation;
import com.Tamazj.TamazjApp.Model.SpinnerDialog;
import com.Tamazj.TamazjApp.Model.VolleyMultipartRequest;
import com.Tamazj.TamazjApp.R;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.squareup.picasso.Picasso;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.listeners.IPickCancel;
import com.vansuita.pickimage.listeners.IPickResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import id.zelory.compressor.Compressor;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserEditProfileFragment extends Fragment implements IPickResult {

    View view;
    ImageButton blueBack, editProfileImage;
    TextView name, emailOriginal;
    CircleImageView profileImage;
    Button approvalButton;
    EditText fullName;
    TextView password,email,phone;
    TextView gender;
    TextView nationality;
    public static TextView birthDate;
    static TextView educationLevel;
    TextView work;
    TextView socialState;
    ProgressDialog progressDialog;
    String token;
    File COOKERIMAGEfile;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor_signUp;
    boolean updateuserImage = false;
    Dialog dialog;
    String uploaduserimageename = "";
    ArrayAdapter<String> eduication_adapter;
    ArrayAdapter<String> soical_staus_adapter;
    ArrayAdapter<String> work_adapter;

    String[] Soical_statuslist;
    String[] EducationList;
    String[] GenderList;
    String[] WorkList;
    ArrayAdapter<String> gender_adapter;
    SpinnerDialog mSpinnerDialog;
    private boolean firstExecutionSoical = true;
    private boolean firstExecutionWork = true;
    private boolean firstExecutionEducation = true;
    private boolean firstExecutionGender = true;
    private boolean firstExecutionNationality = true;

    boolean updateuserphone = false;
    boolean updateusergender = false;
    boolean updateuserdate = false;
    boolean updateusereducation = false;
    boolean updateusersocialstayus = false;
    boolean updateuseremmail = false;
    boolean updateuserfulname = false;
    boolean updateuserimage ,updateuserworkstayus,updateusernationality=false;
    List<Countries.DataBean> countrylist= new ArrayList<Countries.DataBean>();
    List<String> countrylistname = new ArrayList<>();

    ArrayAdapter countriesAdapter;
    String fcm_token;
    int country_id;
    String choosing_langauge;







    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_user_edit_profile, container, false);
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
            fcm_token = sharedPreferences.getString(AppConstants.FCM_TOKEN, "default value");


            ConnectivityManager conMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = conMgr.getActiveNetworkInfo();

            if (networkInfo != null && networkInfo.isConnected()) {

                if (sharedPreferences != null) {
                    if (sharedPreferences.getString(AppConstants.LANG_choose, null) != null) {
                        choosing_langauge = sharedPreferences.getString(AppConstants.LANG_choose, "");
                        getUserProfile(token,choosing_langauge);


                    }
                }





            } else {
                Toast.makeText(getActivity(), "" + getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
            }


        }

        profileImage = view.findViewById(R.id.profileImage);

        name = view.findViewById(R.id.tvFullNameProfile);
        emailOriginal = view.findViewById(R.id.tvEmailProfile);

        editProfileImage = view.findViewById(R.id.editProfileImage);
        editProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateuserImage = true;
                updateuserimage=true;

                PickImageDialog.build(new PickSetup()).setOnPickResult(new IPickResult() {
                    @Override
                    public void onPickResult(PickResult r) {

                        try {
                            COOKERIMAGEfile = new Compressor(getActivity()).compressToFile(new File(r.getPath()));

                            Picasso.with(getContext()).
                                    load(COOKERIMAGEfile).transform(new CropCircleTransformation()).into(profileImage);


                            if (r.getError() == null) {


                            } else {
                                //Handle possible errors
                                //TODO: do what you have to do with r.getError();
                                Toast.makeText(getActivity(), r.getError().getMessage(), Toast.LENGTH_LONG).show();
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                            Picasso.with(getActivity()).load(r.getUri()).error(R.drawable.imageprofile)
                                    // .resize(100,100)
                                    .into(profileImage);

                        }

                        //  uploadAvatar();

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //uploaduserimagee(token, fullName.getText().toString(), phone.getText().toString(), gender.getText().toString(), nationality.getText().toString(), work.getText().toString(), educationLevel.getText().toString(), socialState.getText().toString(), uploaduserimageename);

                                uploaduserimageename = COOKERIMAGEfile.getName();
                            }
                        }, 1000);


                        if (r.getError() == null) {

                            profileImage.setImageBitmap(r.getBitmap());


                        } else {
                            //Handle possible errors
                            //TODO: do what you have to do with r.getError();
                            Toast.makeText(getActivity(), r.getError().getMessage(), Toast.LENGTH_LONG).show();
                        }
                        //TODO: do what you have to...
                    }
                }).setOnPickCancel(new IPickCancel() {
                    @Override
                    public void onCancelClick() {
                        //TODO: do what you have to if user clicked cancel
                    }
                }).show(getActivity().getSupportFragmentManager());

            }

        });

        fullName = view.findViewById(R.id.tvFullNameAdvisorEditProfile);
        email = view.findViewById(R.id.tvEmailAdvisorEditProfile);
        phone = view.findViewById(R.id.tvPhoneAdvisorEditProfile);

        password = view.findViewById(R.id.tvPasswordAdvisorEditProfile);
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditPasswordBottomDialog editPasswordBottomDialog = new EditPasswordBottomDialog();
                editPasswordBottomDialog.show(getFragmentManager(), editPasswordBottomDialog.getTag());
            }
        });
        gender = view.findViewById(R.id.tvGenderAdvisorEditProfile);
        gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.gender_spinner_dialog);
                final Spinner niceSpinner = dialog.findViewById(R.id.nice_spinner);
                GenderList = new String[]{getActivity().getString(R.string.selectone)+ " "+getActivity().getString(R.string.gender),getActivity().getString(R.string.female), getActivity().getString(R.string.male)};
                gender_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, GenderList);
                niceSpinner.setAdapter(gender_adapter);

                gender_adapter.notifyDataSetChanged();
                Window window = dialog.getWindow();
                window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                dialog.setCancelable(true);

                niceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        updateusergender=true;
                    if (firstExecutionGender) {
                            firstExecutionGender = false;
                            return;
                        }

                        if (gender.isClickable()){
                            firstExecutionGender = true;

                        }


                            String usergender = String.valueOf(parent.getItemAtPosition(position));
                        gender.setText(usergender);
                      if(updateusergender){
                        dialog.dismiss();}

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {



                    }
                });


                dialog.show();


            }
        });
        nationality = view.findViewById(R.id.tvNationalityAdvisorEditProfile);
        nationality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCountries();





            }
        });
        birthDate = view.findViewById(R.id.tvBirthDateAdvisorEditProfile);
        birthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateuserdate=true;

                DialogFragment newFragment = new SelectDateFragment();
                newFragment.show(getFragmentManager(), "DatePicker");

            }
        });


        phone.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                updateuserphone=true;

                return false;
            }
        });



fullName.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        updateuserfulname=true;

    }
});








        educationLevel = view.findViewById(R.id.tvLearningAdvisorEditProfile);
        educationLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateusereducation=true;

/*
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                final Spinner sp = new Spinner(getActivity());
                EducationList = new String[]{getActivity().getString(R.string.high_schoole), getActivity().getString(R.string.ba), getActivity().getString(R.string.ma), getActivity().getString(R.string.phd)};
                eduication_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, EducationList);
                sp.setAdapter(eduication_adapter);
                eduication_adapter.notifyDataSetChanged();

                sp.setAdapter(eduication_adapter);
                final AlertDialog dialog = builder.show();

                sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                {
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                    {
                        String selectedItem = parent.getItemAtPosition(position).toString();
                        Log.d("selectedItem:", selectedItem);
                    //dialog.dismiss();
                    builder.create().dismiss();

                    } // to close the onItemSelected
                    public void onNothingSelected(AdapterView<?> parent)
                    {

                    }
                });

                builder.setView(sp);
                builder.create().show();*/
                dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.education_spinner_dialog);
                EducationList = new String[]{getActivity().getString(R.string.selectone)+ " "+getActivity().getString(R.string.learning),getActivity().getString(R.string.high_schoole), getActivity().getString(R.string.ba), getActivity().getString(R.string.ma), getActivity().getString(R.string.phd)};
                Spinner niceSpinner = dialog.findViewById(R.id.nice_spinner);
                eduication_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, EducationList);
                niceSpinner.setAdapter(eduication_adapter);
                eduication_adapter.notifyDataSetChanged();
                Window window = dialog.getWindow();
                window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                dialog.setCancelable(true);
                niceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (firstExecutionEducation) {
                            firstExecutionEducation = false;

                            return;

                        }


                        if (educationLevel.isClickable()){
                            firstExecutionEducation = true;

                        }



                        String educationLevelst = String.valueOf(parent.getItemAtPosition(position));
                        educationLevel.setText(educationLevelst);
                        dialog.dismiss();

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {


                    }
                });


                dialog.show();




            }
        });
        work = view.findViewById(R.id.tvJobAdvisorEditProfile);
        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 updateuserworkstayus = true;
                dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.soical_stautus_spinner_dialog);
                Spinner niceSpinner = dialog.findViewById(R.id.nice_spinner);
                WorkList = new String[]{getActivity().getString(R.string.selectone)+ " "+getActivity().getString(R.string.job),getActivity().getString(R.string.work), getActivity().getString(R.string.notwork), getActivity().getString(R.string.work_private_sector)};
                work_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, WorkList);
                niceSpinner.setAdapter(work_adapter);
                work_adapter.notifyDataSetChanged();
                Window window = dialog.getWindow();
                window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                dialog.setCancelable(true);

                niceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (firstExecutionWork) {
                            firstExecutionWork = false;
                            return;
                        }


                        if (work.isClickable()){
                            firstExecutionWork = true;

                        }
                        String userwork = String.valueOf(parent.getItemAtPosition(position));
                        work.setText(userwork);
                        dialog.dismiss();

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {


                    }
                });


                dialog.show();
            }
        });
        socialState = view.findViewById(R.id.tvSocialStateAdvisorEditProfile);
        socialState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateusersocialstayus=true;
                dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.soical_stautus_spinner_dialog);

                Spinner niceSpinner = dialog.findViewById(R.id.nice_spinner);

                Soical_statuslist = new String[]{getActivity().getString(R.string.selectone)+ " "+getActivity().getString(R.string.socialState),getActivity().getString(R.string.married), getActivity().getString(R.string.single), getActivity().getString(R.string.Divorced), getActivity().getString(R.string.widow)};


                soical_staus_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Soical_statuslist);
                niceSpinner.setAdapter(soical_staus_adapter);
                soical_staus_adapter.notifyDataSetChanged();
                Window window = dialog.getWindow();
                window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                dialog.setCancelable(true);

                niceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (firstExecutionSoical) {
                            firstExecutionSoical = false;
                            return;
                        }

                        if (socialState.isClickable()){
                            firstExecutionSoical = true;

                        }

                        String usersocialState = String.valueOf(parent.getItemAtPosition(position));
                        socialState.setText(usersocialState);
                        dialog.dismiss();

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {


                    }
                });


                dialog.show();









                /*dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.gender_spinner_dialog);
                NiceSpinner niceSpinner =  dialog.findViewById(R.id.nice_spinner);
                final List<String> dataset = new LinkedList<>(Arrays.asList(getActivity().getString(R.string.married), getActivity().getString(R.string.single),
                        getActivity().getString(R.string.Divorced),getActivity().getString(R.string.widow) ));
                niceSpinner.attachDataSource(dataset);
                dialog.setCancelable(true);
                niceSpinner.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
                    @Override
                    public void onItemSelected(NiceSpinner parent, View view, int position, long id) {
                        // This example uses String, but your type can be any
                        String socialState = String.valueOf(parent.getItemAtPosition(position));
                        gender.setText(socialState);
                        dialog.dismiss();


                    }








                });


                dialog.show();*/

            }
        });

        approvalButton = view.findViewById(R.id.approvalButton);
        approvalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager conMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = conMgr.getActiveNetworkInfo();

                if (networkInfo != null && networkInfo.isConnected()) {
                    if(updateusersocialstayus ||updateuserdate||updateusereducation||updateuseremmail||
                            updateuserfulname||updateuserphone||updateusergender||updateuserimage || updateuserworkstayus) {

                        if (sharedPreferences != null) {
                            if (sharedPreferences.getString(AppConstants.LANG_choose, null) != null) {
                                choosing_langauge = sharedPreferences.getString(AppConstants.LANG_choose, "");
                                Updateuserprofile(choosing_langauge,token, fullName.getText().toString(), phone.getText().toString(), gender.getText().toString(),
                                        country_id, work.getText().toString(), educationLevel.getText().toString(), socialState.getText().toString(), uploaduserimageename,fcm_token,birthDate.getText().toString());


                            }
                        }




                       // UpdateUserProfile(token, fullName.getText().toString(), phone.getText().toString(), gender.getText().toString(), nationality.getText().toString(), work.getText().toString(), educationLevel.getText().toString(), socialState.getText().toString(), uploaduserimageename);
                    }

                    else {
                        Toast.makeText(getActivity(), "" + getString(R.string.nodatachanged), Toast.LENGTH_SHORT).show();


                    }


                } else {
                    Toast.makeText(getActivity(), "" + getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
                }


            }
        });

        return view;
    }

    public String getURLForResource(int resourceId) {
        return Uri.parse("android.resource://" + R.class.getPackage().getName() + "/" + resourceId).toString();
    }


    public void UpdateUserProfile(final String token, final String name, final String phone, final String gender, final String nationality, final String work_status, final String educational_status, final String social_status, final String photo) {


        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConstants.updateProfile, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("HZM", response);

                try {
                    JSONObject task_respnse = new JSONObject(response);
                    JSONObject meta = task_respnse.getJSONObject("meta");
                    String message = meta.getString("message");
                    int status = meta.getInt("status");
                    Log.e("WAFAAUPDATE", response);

                    if (status == 1) {
                        Toast.makeText(getActivity(), "" + message, Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getActivity(), " " + getActivity().getString(R.string.not_update), Toast.LENGTH_SHORT).show();

                    }


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
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer" + "  " + token);
                headers.put("name", name);
                headers.put("phone", phone);
                headers.put("gender", gender);
                headers.put("nationality", nationality);
                headers.put("work_status", work_status);
                headers.put("social_status", social_status);
                headers.put("educational_status", educational_status + "");
                headers.put("photo", photo + "");


                return headers;

            }


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer" + "  " + token);

                return headers;
            }

            ;
        };

        MyApplication.getInstance().addToRequestQueue(stringRequest);

    }

    public void getUserProfile(final String token,final  String lang) {

        showDialog();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConstants.USER_PROFILE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("HZM", response);

                try {
                    JSONObject task_respnse = new JSONObject(response);
                    JSONObject taskarray = task_respnse.getJSONObject("data");
                    String username = taskarray.getString("name");
                    String useremail = taskarray.getString("email");
                    String userphone = taskarray.getString("phone");
                    String usergender = taskarray.getString("gender");
                    String usernationality = taskarray.getString("nationality");
                    String work_status = taskarray.getString("work_status");
                  String date_of_birth=taskarray.getString("date_of_birth");
                    String educational_status = taskarray.getString("educational_status");
                    String photo = taskarray.getString("photo");
                    String usersocial_status = taskarray.getString("social_status");
                    String status = taskarray.getString("status");
                    name.setText(username);
                    emailOriginal.setText(useremail);
                    Picasso.with(getContext()).
                            load(photo).transform(new CropCircleTransformation()).into(profileImage);
                    fullName.setText(username);
                    email.setText(useremail);
                    phone.setText(userphone);


                    if(usergender.equals(null)||usergender.matches("null")){
                        gender.setText("");
                    }
                    else {
                        gender.setText(usergender);

                    }
                    if(usernationality.equals(null)||usernationality.matches("null")){
                        nationality.setText(" ");
                    }
                    else {
                        nationality.setText(usernationality);

                    }

                    if(usersocial_status.equals(null)||usersocial_status.matches("null")){
                        socialState.setText(" ");
                    }
                    else {
                        socialState.setText(usersocial_status);

                    }
                    if(educational_status.equals(null)||educational_status.matches("null")){
                        educationLevel.setText("");
                    }
                    else {
                        educationLevel.setText(educational_status);

                    }

                    if(work_status.equals(null)||work_status.matches("null")){
                        work.setText("");
                    }
                    else {
                        work.setText(work_status);

                    }

                    if(date_of_birth.equals(null)||date_of_birth.matches("null")){
                        birthDate.setText("");
                    }
                    else {
                        birthDate.setText(date_of_birth);

                    }


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
        }) {
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
                headers.put("lang", lang);


                return headers;
            }

            ;
        };

        MyApplication.getInstance().addToRequestQueue(stringRequest);

    }

    public void showDialog() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(getString(R.string.load_login));
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void hideDialog() {

        if (progressDialog.isShowing()) progressDialog.dismiss();
    }


    private void Updateuserprofile(final  String lang,final String token, final String name, final String phone, final String gender, final int nationality, final String work_status, final String educational_status, final String social_status, final String photo ,final String fcm_token,final  String date_of_birth ) {
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage(getActivity().getString(R.string.savedata));
        progressDialog.show();

        final String id = "1";
        //        "photo": "http://salahalimohamed.website/tmajog/public/admin/img/user/test.png",
        String url = "http://salahalimohamed.website/tmajog/api/v1/user/updateProfile";
        VolleyMultipartRequest multipartRequest = new VolleyMultipartRequest(Request.Method.POST, url, new Response.Listener<NetworkResponse>() {
            @Override
            public void onResponse(NetworkResponse response) {
                progressDialog.dismiss();
                String resultResponse = new String(response.data);
                //Toast.makeText(getActivity(), ""+resultResponse, Toast.LENGTH_SHORT).show();
                try {
                    JSONObject obj = new JSONObject(resultResponse);
                    JSONObject meta = obj.getJSONObject("meta");
                    String message = meta.getString("message");
                    int status = meta.getInt("status");
                    Log.e("WAFAAUPDATE", resultResponse);

                    if (status == 1) {
                       Toast.makeText(getActivity(), "" + message, Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getActivity(), " " + getActivity().getString(R.string.not_update), Toast.LENGTH_SHORT).show();

                    }




                } catch (JSONException e) {
                    e.printStackTrace();

                    //showUploadSnackBar();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("id", id);
                params.put("Authorization", "Bearer" + "  " + token);
                params.put("name", name);
                params.put("phone", phone);
                params.put("date_of_birth",date_of_birth);
                params.put("gender", gender);
                params.put("nationality", nationality+"");
                params.put("work_status", work_status);
                params.put("social_status", social_status);
                params.put("educational_status", educational_status + "");
                params.put("photo", photo + "");
                params.put("fcm_token", fcm_token);


                return params;
            }


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer" + "  " + token);
                headers.put("lang", lang);

                return headers;
            }

            @Override
            protected Map<String, DataPart> getByteData() {
                Map<String, DataPart> params = new HashMap<>();
                if (profileImage == null) {
                }
                params.put("photo", new DataPart(uploaduserimageename, AppHelper.getFileDataFromDrawable(getContext(), profileImage.getDrawable()), "image/jpg"));
                return params;
            }
        };

        multipartRequest.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MyApplication.getInstance().addToRequestQueue(multipartRequest);
    }


    @Override
    public void onPickResult(PickResult r) {

    }

    @SuppressLint("ValidFragment")
    public static class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar calendar = Calendar.getInstance();
            int yy = calendar.get(Calendar.YEAR);
            int mm = calendar.get(Calendar.MONTH);
            int dd = calendar.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), this, yy, mm, dd);
        }

        public void onDateSet(DatePicker view, int yy, int mm, int dd) {
            populateSetDate(yy, mm + 1, dd);
        }

        public void populateSetDate(int year, int month, int day) {
            birthDate.setText(year + "-" + month + "-" + day);
        }
    }

    public static class SpinnerDialog extends Dialog {
        private String[] mList;
        private Context mContext;
        private Spinner mSpinner;



        public interface DialogListener {
            public void ready(int n);
            public void cancelled();
        }

        private DialogListener mReadyListener;

        public SpinnerDialog(Context context, String[] list, DialogListener readyListener) {
            super(context);
            mReadyListener = readyListener;
            mContext = context;
            mList = list;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.education_spinner_dialog);
            mSpinner =  findViewById (R.id.nice_spinner);

            ArrayAdapter<String> adapter = new ArrayAdapter<String> (mContext, android.R.layout.simple_spinner_dropdown_item, mList);
            mSpinner.setAdapter(adapter);
            mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    String educationLevelst = String.valueOf(parent.getItemAtPosition(position));
                    educationLevel.setText(educationLevelst);

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {


                }
            });





        }


    }


    public class DialogSpinner extends androidx.appcompat.widget.AppCompatSpinner {
        public DialogSpinner(Context context) {
            super(context);
        }

        @Override
        public boolean performClick() {
            new AlertDialog.Builder(getContext()).setAdapter((ListAdapter) getAdapter(),
                    new DialogInterface.OnClickListener() {
                        @Override public void onClick(DialogInterface dialog, int which) {
                            setSelection(which);
                            dialog.dismiss();
                        }
                    }).create().show();
            return true;
        }
    }
    public void getCountries() {


        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConstants.countries, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("HZM", response);

                try {
                    JSONObject session_response = new JSONObject(response);
                    JSONArray jsonArray = session_response.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        int id = jsonArray.getJSONObject(i).getInt("id");
                        String name_ar = jsonArray.getJSONObject(i).getString("name_ar");
                        String name_en = jsonArray.getJSONObject(i).getString("name_en");
                        String short_code = jsonArray.getJSONObject(i).getString("short_code");
                        Countries.DataBean countries = new Countries.DataBean();
                        countries.setId(id);
                        countries.setName_ar(name_ar);
                        countries.setName_en(name_en);
                        countries.setShort_code(short_code);
                        countrylistname.add(name_ar);
                        countrylist.add(countries);



                    }

                    dialog = new Dialog(getActivity());
                    dialog.setContentView(R.layout.country_spinner_dialog);
                    final Spinner niceSpinner = dialog.findViewById(R.id.nice_spinner);
                    countriesAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, countrylistname);
                    niceSpinner.setAdapter(countriesAdapter);
                    countriesAdapter.notifyDataSetChanged();
                    Window window = dialog.getWindow();
                    window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    dialog.setCancelable(true);
                    niceSpinner.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            updateusernationality=true;

                            return false;
                        }
                    });

                    niceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (firstExecutionNationality) {
                                firstExecutionNationality = false;
                                return;
                            }


                            if (nationality.isClickable()){
                                firstExecutionNationality = true;

                            }
                            country_id= countrylist.get(position).getId();




                            String userCountry = String.valueOf(parent.getItemAtPosition(position));
                            nationality.setText(userCountry);
                            dialog.dismiss();


                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {



                        }
                    });


                    dialog.show();




                } catch (JSONException e1) {
                    e1.printStackTrace();

                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {



            }
        }) {
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
            }

            ;
        };

        MyApplication.getInstance().addToRequestQueue(stringRequest);

    }


    }
