package com.Tamazj.TamazjApp.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInActivity extends AppCompatActivity {

    EditText email, password;
    Button sign, signUp;
    ProgressDialog progressDialog;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor_signUp;
    TextView forgetpassward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email = findViewById(R.id.etSignInEmail);
        password = findViewById(R.id.etSignInPassword);

        sign = findViewById(R.id.buttonSignInSign);
        signUp = findViewById(R.id.buttonSignInSignUp);
        forgetpassward = findViewById(R.id.forgetpassward);
        forgetpassward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, ResetPassActivity.class);
                startActivity(intent);
                finish();
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().equals(null) || email.getText().equals("")) {
                    Toast.makeText(SignInActivity.this, "" + getString(R.string.emailRequired), Toast.LENGTH_SHORT).show();

                } else if (!isEmailValid(email.getText().toString())) {
                    Toast.makeText(SignInActivity.this, getString(R.string.enter__correct_email), Toast.LENGTH_SHORT).show();

                } else if (password.getText().equals(null) || password.getText().equals("")) {
                    Toast.makeText(SignInActivity.this, "" + getString(R.string.passwordRequired), Toast.LENGTH_SHORT).show();
                } else {
                    ConnectivityManager conMgr = (ConnectivityManager) SignInActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo networkInfo = conMgr.getActiveNetworkInfo();

                    if (networkInfo != null && networkInfo.isConnected()) {
                        loginuser(email.getText().toString(), password.getText().toString());


                    }
                    else {
                        Toast.makeText(SignInActivity.this, ""+getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    public void loginuser(final String email, final String password) {
        showDialog();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConstants.USER_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject register_response = new JSONObject(response);
                    int status = register_response.getInt("status");
                    //  String message = register_response.getString("message");
                    String token = register_response.getString("token");
                    Log.e("WAFAA", response);


                    if (status == 1) {
                        // Toast.makeText(SignInActivity.this, ""+message, Toast.LENGTH_SHORT).show();
                        sharedPreferences = getSharedPreferences(AppConstants.KEY_SIGN_UP, MODE_PRIVATE);
                        editor_signUp = sharedPreferences.edit();
                        editor_signUp.putString(AppConstants.EMAIL, email.toString());
                        editor_signUp.putString(AppConstants.PASSWORD, password.toString());
                        editor_signUp.putString(AppConstants.token, token);
                        editor_signUp.putBoolean(AppConstants.ISLOGIN, true);

                        editor_signUp.apply();
                        editor_signUp.commit();
                        Intent main = new Intent(SignInActivity.this, MainActivity.class);
                        startActivity(main);
                        finish();


                    } else {
                        hideDialog();
                        //Toast.makeText(SignInActivity.this, " "+message, Toast.LENGTH_SHORT).show();

                    }


                    hideDialog();


                } catch (JSONException e) {
                    e.printStackTrace();
                    hideDialog();
                    Toast.makeText(SignInActivity.this, "رقم الجوال او كلمة المرور غير صحيحة ", Toast.LENGTH_SHORT).show();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                hideDialog();
                Toast.makeText(SignInActivity.this, "رقم الجوال او كلمة المرور غير صحيحة ", Toast.LENGTH_SHORT).show();


            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap();
                map.put("email", email);
                map.put("password", password);

                return map;

            }
        };

        MyApplication.getInstance().addToRequestQueue(stringRequest);


    }

    public void loginconsultation(final String email, final String password) {
        showDialog();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConstants.USER_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject register_response = new JSONObject(response);
                    JSONObject auto = register_response.getJSONObject("auth");

                    boolean status = register_response.getBoolean("status");
                    String type = register_response.getString("type");
                    int user_id = auto.getInt("id");
                    if (status) {


                        Intent main = new Intent(SignInActivity.this, MainActivity.class);
                        sharedPreferences = getSharedPreferences(AppConstants.KEY_SIGN_UP, MODE_PRIVATE);
                        editor_signUp = sharedPreferences.edit();
                        startActivity(main);
                        finish();


                    } else {
                        hideDialog();
                        Toast.makeText(SignInActivity.this, "رقم الجوال او كلمة المرور غير صحيحة ", Toast.LENGTH_SHORT).show();

                    }


                    hideDialog();


                } catch (JSONException e) {
                    e.printStackTrace();
                    hideDialog();
                    Toast.makeText(SignInActivity.this, "رقم الجوال او كلمة المرور غير صحيحة ", Toast.LENGTH_SHORT).show();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                hideDialog();
                Toast.makeText(SignInActivity.this, "رقم الجوال او كلمة المرور غير صحيحة ", Toast.LENGTH_SHORT).show();


            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap();
                map.put("email", email);
                map.put("password", password);

                return map;

            }
        };

        MyApplication.getInstance().addToRequestQueue(stringRequest);


    }

    public void showDialog() {
        progressDialog = new ProgressDialog(SignInActivity.this);
        progressDialog.setMessage(getString(R.string.load_login));
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void hideDialog() {

        if (progressDialog.isShowing()) progressDialog.dismiss();
    }


}

