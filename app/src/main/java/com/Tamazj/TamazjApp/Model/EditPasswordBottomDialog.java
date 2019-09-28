package com.Tamazj.TamazjApp.Model;

import android.annotation.SuppressLint;
import android.app.Dialog;

import com.Tamazj.TamazjApp.Adapter.ProfileInformationAdapter;
import com.Tamazj.TamazjApp.Api.MyApplication;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.Tamazj.TamazjApp.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

import static android.content.Context.MODE_PRIVATE;

public class EditPasswordBottomDialog extends BottomSheetDialogFragment {

    View viewDialog;
    Button buttonEditPassword;
    ImageButton dialogButtonCancel;
    EditText dialogOldPassword, dialogNewPassword, dialogConfirmPassword;
    ProgressDialog progressDialog;
    String token;
    SharedPreferences sharedPreferences;
    String choosing_langauge;


    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        viewDialog = View.inflate(getContext(), R.layout.edit_password_layout, null);
        dialog.setContentView(viewDialog);
        progressDialog = new ProgressDialog(getActivity());
        sharedPreferences =getContext().getSharedPreferences(AppConstants.KEY_SIGN_UP, MODE_PRIVATE);

        dialogOldPassword = viewDialog.findViewById(R.id.oldPassword);
        dialogNewPassword = viewDialog.findViewById(R.id.newPassword);
        dialogConfirmPassword = viewDialog.findViewById(R.id.confirmPassword);
        dialogButtonCancel =  viewDialog.findViewById(R.id.buttonCancel);
        buttonEditPassword = viewDialog.findViewById(R.id.buttonEditPassword);
        token = sharedPreferences.getString(AppConstants.token, "default value");

        dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();

            }
        });

        buttonEditPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(dialogOldPassword.getText().equals(null) || dialogOldPassword.getText().equals("")){
                    Toast.makeText(getContext(), ""+getString(R.string.oldPasswordRequired), Toast.LENGTH_SHORT).show();
                }  else if(dialogNewPassword.getText().equals(null) || dialogNewPassword.getText().equals("")){
                    Toast.makeText(getContext(), ""+getString(R.string.newPasswordRequired), Toast.LENGTH_SHORT).show();
                }  else if(dialogNewPassword.getText().equals(null) || dialogNewPassword.getText().equals("")){
                    Toast.makeText(getContext(), ""+getString(R.string.confirmPasswordRequired), Toast.LENGTH_SHORT).show();
                }

                /*else if(!dialogOldPassword.getText().equals(dialogNewPassword.getText())){
                    Toast.makeText(getContext(), ""+getString(R.string.oldPasswordMatchesnewPassword), Toast.LENGTH_SHORT).show();
                }  else if(!dialogConfirmPassword.getText().equals(dialogNewPassword.getText())){
                    Toast.makeText(getContext(), ""+getString(R.string.confirmPasswordNotMatchesPassword), Toast.LENGTH_SHORT).show();
                } */else {

                    if (sharedPreferences != null) {
                        token = sharedPreferences.getString(AppConstants.token, "default value");
                        choosing_langauge = sharedPreferences.getString(AppConstants.LANG_choose, "ar");
                   //updatePassword(token,choosing_langauge,dialogOldPassword.getText().toString(),dialogNewPassword.getText().toString(),dialogConfirmPassword.toString());


                         updatePassword("Bearer  eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6Ijc2Yzk1MDc1ZmY2NjVlMmE5ZGVmOTI3MjE0ZjdhMzIwMDMwMWM0MWMyZWJjMDYwNmMzYTAyZjQ2MGMyZWRiMmJiYzM0YWIyMjdiMzBjNjUzIn0.eyJhdWQiOiIxIiwianRpIjoiNzZjOTUwNzVmZjY2NWUyYTlkZWY5MjcyMTRmN2EzMjAwMzAxYzQxYzJlYmMwNjA2YzNhMDJmNDYwYzJlZGIyYmJjMzRhYjIyN2IzMGM2NTMiLCJpYXQiOjE1Njk2MzU3NzIsIm5iZiI6MTU2OTYzNTc3MiwiZXhwIjoxNjAxMjU4MTcyLCJzdWIiOiIxMiIsInNjb3BlcyI6W119.MY1x3o0S52HlSLTXMwUPUaxEszinLNGTMouNgMUzMWIpDTnNwllye_m_oDUfc0F1kV0Ot1r4VukGmPPTMa5VnkMgg48EcwsCeuqT4urUWZ0EQ01vaOkOrDwJlwfrkJR4vJ_gb__g1TZniwd71pj7wRQCqejoLediOIryOY5vtcPjSg13B-EmcmhVfqEdb88EFusxQF62G3w8HwlMJ8Ouj61gJZAAzIjCqsEzwfE9dcoMCeag4wz4a3GrdiFyJ0B7igdzlbDtBJGq36aZ-Wj5n2Jgmh506fYttU33J6cG4AZ8Opye7wLi9jcvdKC49bRsNyEoK5D-75MUE8HJu7OdSCqm_J72aC68QD0tiPT3Xc88stYBHsPCa0f5nBZzaFgru54cKe39MRA_Vq0Of7huJBDzC1nH2l4PaOcPRKwSMzi5RdA0QxOUSMg1Hgc-ZegjMbCGmWsqVUgGhvOwNrtfDTh_ApSlBn-yV2SBo8dsau5T2TxCApJdwV1RISZiCLPBE-999CBgnixraPfIKxQhtkhpEj5-q-XT-DTgfolM1yHrWE7oZ8elK5piMDdVJw0I2kFgRxXoauYmMbZPXCxJxH23tFTxDQc5NU31LZxpO2_HH-zsMh8gGevE_8dYh1_-JVSvZA0bLZQShNfzjRAZtbzvN3LiwPi2ulQUb3cHkO0",
                                "en","123","12345","12345");

                    }



                }
            }
        });


    }



    public void updatePassword(final String token,final  String lang,final String old_password,final String new_password,final  String confirmed_password) {

       showDialog();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConstants.updatePassword, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("WAFAAUPDATE", response);

                try {
                    JSONObject updatepassword_respnse = new JSONObject(response);

                    String message = updatepassword_respnse.getString("message");
                    int status = updatepassword_respnse.getInt("status");

                    if (status == 1) {
                        Toast.makeText(getActivity(), "" + message, Toast.LENGTH_SHORT).show();


                    } else {
                        Toast.makeText(getActivity(), " " + message, Toast.LENGTH_SHORT).show();

                    }
                    hideDialog();

                } catch (JSONException e1) {
                    e1.printStackTrace();
                   hideDialog();

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
                HashMap<String, String> Params = new HashMap<>();
                Params.put("new_password",  new_password);
                Params.put("old_password",  old_password);
                Params.put("confirmed_password",  confirmed_password);
                Params.put("Authorization", "Bearer" + "  " + token);
                Params.put("lang", lang);


                return Params;

            }


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer" + "  " + token);
                headers.put("lang", lang);
                headers.put("Content-Type", "application/json");

                return headers;
            }


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




    public void UpdatePassward(final String token,final  String lang,final String old_password,final String new_password,final  String confirmed_password) {
        showDialog();


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, AppConstants.updatePassword, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                try {

                    String message = response.getString("message");
                    int status = response.getInt("status");


                    if (status == 1) {
                        Toast.makeText(getActivity(), "" + message, Toast.LENGTH_SHORT).show();


                    } else {
                        Toast.makeText(getActivity(), " " + message, Toast.LENGTH_SHORT).show();

                    }
                    hideDialog();


                } catch (JSONException e) {
                    e.printStackTrace();
                    hideDialog();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                hideDialog();

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap();
                map.put("Authorization", "Bearer" + "  " + token);
                map.put("new_password",  new_password);
                map.put("old_password",  old_password);
                map.put("confirmed_password",  confirmed_password);

                map.put("lang", lang);


                return map;

            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer" + "  " + token);
                headers.put("lang", lang);
                headers.put("Content-Type", "application/json");

                return headers;
            }

        };
        MyApplication.getInstance().addToRequestQueue(jsonObjectRequest);
    }
}
