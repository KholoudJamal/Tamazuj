package com.Tamazj.TamazjApp.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.Tamazj.TamazjApp.Api.MyApplication;
import com.Tamazj.TamazjApp.MainActivity;
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

public class ActivateCodeActivity extends AppCompatActivity {


    ProgressDialog progressDialog;
    private EditText mEditPhone;
    private EditText mEditActivate;
    private Button mActivateAccount;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor_signUp;
    private TextView mResetcode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activate_code);

        mEditPhone = findViewById(R.id.editPhone);
        mEditActivate = findViewById(R.id.editActivate);
        mActivateAccount = findViewById(R.id.activateAccount);
        mResetcode = findViewById(R.id.resetcode);

        mResetcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivateCodeActivity.this, ResetCodeActivity.class);
                startActivity(intent);
                finish();

            }
        });
        mActivateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mEditPhone.getText().toString().equals(null) || mEditPhone.getText().toString().equals("")) {
                    Toast.makeText(ActivateCodeActivity.this, "" + getString(R.string.phoneRequired), Toast.LENGTH_SHORT).show();
                } else if (mEditActivate.getText().toString().equals(null) || mEditActivate.getText().toString().equals("")) {
                    Toast.makeText(ActivateCodeActivity.this, "" + getString(R.string.codeRequired), Toast.LENGTH_SHORT).show();
                } else {

                    ConnectivityManager conMgr = (ConnectivityManager) ActivateCodeActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo networkInfo = conMgr.getActiveNetworkInfo();

                    if (networkInfo != null && networkInfo.isConnected()) {
                        activateCode(mEditPhone.getText().toString(), mEditActivate.getText().toString());

                    } else {
                        Toast.makeText(ActivateCodeActivity.this, "" + getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });
    }


    public void activateCode(final String phone, final String activate) {
        showDialog();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConstants.activateCode, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject register_response = new JSONObject(response);
                    String message = register_response.getString("message");
                    int status = register_response.getInt("status");
                    if (status == 1) {
                        String token = register_response.getString("token");
                        sharedPreferences = getSharedPreferences(AppConstants.KEY_SIGN_UP, MODE_PRIVATE);
                        editor_signUp = sharedPreferences.edit();
                        editor_signUp.putBoolean(AppConstants.ISLOGIN, true);
                        editor_signUp.putString(AppConstants.token, token);
                        editor_signUp.apply();
                        editor_signUp.commit();
                        Toast.makeText(ActivateCodeActivity.this, "" + message, Toast.LENGTH_SHORT).show();
                        if (sharedPreferences.getString(AppConstants.ACCOUNT_TYPE, AppConstants.Beneficiary).equals(AppConstants.Advisor)) {
                            Intent intent = new Intent(ActivateCodeActivity.this, AdvisorActivity.class);
                            startActivity(intent);
                            finish();
                        } else if (sharedPreferences.getString(AppConstants.ACCOUNT_TYPE, AppConstants.Beneficiary).equals(AppConstants.Beneficiary)) {
                            Intent intent = new Intent(ActivateCodeActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }


                    } else {
                        Toast.makeText(ActivateCodeActivity.this, " " + message, Toast.LENGTH_SHORT).show();

                    }

                    hideDialog();
                } catch (JSONException e) {
                    e.printStackTrace();
                    hideDialog();
                    Toast.makeText(ActivateCodeActivity.this, " ", Toast.LENGTH_SHORT).show();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                hideDialog();
                Toast.makeText(ActivateCodeActivity.this, "error", Toast.LENGTH_SHORT).show();


            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap();
                map.put("phone", phone);
                map.put("activate", activate);


                return map;

            }
        };

        MyApplication.getInstance().addToRequestQueue(stringRequest);


    }


    public void showDialog() {
        progressDialog = new ProgressDialog(ActivateCodeActivity.this);
        progressDialog.setMessage(getString(R.string.load_login));
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void hideDialog() {

        if (progressDialog.isShowing()) progressDialog.dismiss();
    }

}
