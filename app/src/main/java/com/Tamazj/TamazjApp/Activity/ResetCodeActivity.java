package com.Tamazj.TamazjApp.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Tamazj.TamazjApp.Api.MyApplication;
import com.Tamazj.TamazjApp.Model.AppConstants;
import com.Tamazj.TamazjApp.R;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ResetCodeActivity extends AppCompatActivity {

    private EditText mEditPhone;
    private Button mResetcode;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_code);
        mEditPhone = findViewById(R.id.editPhone);
        mResetcode = findViewById(R.id.resetcode);
        progressDialog = new ProgressDialog(ResetCodeActivity.this);
        mResetcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEditPhone.getText().equals(null) || mEditPhone.getText().equals("")){
                    Toast.makeText(ResetCodeActivity.this, ""+getString(R.string.phoneRequired), Toast.LENGTH_SHORT).show();
                }
                else{

                    ConnectivityManager conMgr = (ConnectivityManager) ResetCodeActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo networkInfo = conMgr.getActiveNetworkInfo();

                    if (networkInfo != null && networkInfo.isConnected()) {
                        resetCode(mEditPhone.getText().toString());

                    }
                    else {
                        Toast.makeText(ResetCodeActivity.this, ""+getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
                    }



                }
            }
        });
    }



    public void resetCode(final String phone) {
        showDialog();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConstants.resetCode, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject register_response = new JSONObject(response);
                    String message = register_response.getString("message");
                    int status = register_response.getInt("status");
                    Log.e("WAFAA",response);


                    if (status == 1) {
                        Toast.makeText(ResetCodeActivity.this, "" + message, Toast.LENGTH_SHORT).show();
                        Intent login = new Intent(ResetCodeActivity.this, SignInActivity.class);
                        startActivity(login);
                        finish();

                    } else {
                        Toast.makeText(ResetCodeActivity.this, " " + message, Toast.LENGTH_SHORT).show();

                    }

                    hideDialog();
                } catch (JSONException e) {
                    e.printStackTrace();
                    hideDialog();
                    Toast.makeText(ResetCodeActivity.this, " ", Toast.LENGTH_SHORT).show();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                hideDialog();
                Toast.makeText(ResetCodeActivity.this, "error", Toast.LENGTH_SHORT).show();


            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap();
                map.put("phone", phone);


                return map;

            }
        };

        MyApplication.getInstance().addToRequestQueue(stringRequest);


    }


    public void showDialog() {
        progressDialog = new ProgressDialog(ResetCodeActivity.this);
        progressDialog.setMessage(getString(R.string.load_login));
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void hideDialog() {

        if (progressDialog.isShowing()) progressDialog.dismiss();
    }

    }

