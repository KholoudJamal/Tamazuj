package com.Tamazj.TamazjApp.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
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

public class ResetPassActivity extends AppCompatActivity {

    private EditText mEditPhone;
    private Button mResetpass;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);

        mEditPhone = findViewById(R.id.editPhone);
        mResetpass = findViewById(R.id.resetpass);
        progressDialog = new ProgressDialog(ResetPassActivity.this);

        mResetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEditPhone.getText().equals(null) || mEditPhone.getText().equals("")){
                    Toast.makeText(ResetPassActivity.this, ""+getString(R.string.phoneRequired), Toast.LENGTH_SHORT).show();
                }
                else{

                    ConnectivityManager conMgr = (ConnectivityManager) ResetPassActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo networkInfo = conMgr.getActiveNetworkInfo();

                    if (networkInfo != null && networkInfo.isConnected()) {
                        resetPass(mEditPhone.getText().toString());

                    }
                    else {
                        Toast.makeText(ResetPassActivity.this, ""+getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
                    }



                }
            }
        });
    }



    public void resetPass(final String phone) {
        showDialog();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConstants.resetPass, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject register_response = new JSONObject(response);
                    String message = register_response.getString("message");
                    int status = register_response.getInt("status");
                    Log.e("WAFAA",response);


                    if (status == 1) {
                        Toast.makeText(ResetPassActivity.this, "" + message, Toast.LENGTH_SHORT).show();
                        Intent login = new Intent(ResetPassActivity.this, SignInActivity.class);
                        startActivity(login);
                        finish();

                    } else {
                        Toast.makeText(ResetPassActivity.this, " " + message, Toast.LENGTH_SHORT).show();

                    }

                    hideDialog();
                } catch (JSONException e) {
                    e.printStackTrace();
                    hideDialog();
                    Toast.makeText(ResetPassActivity.this, " ", Toast.LENGTH_SHORT).show();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                hideDialog();
                Toast.makeText(ResetPassActivity.this, "error", Toast.LENGTH_SHORT).show();


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
        progressDialog = new ProgressDialog(ResetPassActivity.this);
        progressDialog.setMessage(getString(R.string.load_login));
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void hideDialog() {

        if (progressDialog.isShowing()) progressDialog.dismiss();
    }
}
