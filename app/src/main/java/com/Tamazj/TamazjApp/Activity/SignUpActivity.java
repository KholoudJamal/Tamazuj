package com.Tamazj.TamazjApp.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {

    EditText fullName, email, password, confirmPassword, phone;
    Button sign, clickHere;
    ProgressDialog progressDialog;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor_signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fullName = findViewById(R.id.etSignUpFullName);
        email = findViewById(R.id.etSignUpEmail);
        password = findViewById(R.id.etSignUpPassword);
        confirmPassword = findViewById(R.id.etSignUpConfirmPassword);
        phone = findViewById(R.id.etSignUpPhone);

        sign = findViewById(R.id.buttonSignUpSign);
        clickHere = findViewById(R.id.buttonSignUpClickHere);
        progressDialog = new ProgressDialog(SignUpActivity.this);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        if(fullName.getText().equals(null) || fullName.getText().equals("")){
            Toast.makeText(SignUpActivity.this, ""+getString(R.string.fullNameRequired), Toast.LENGTH_SHORT).show();
        } else if(email.getText().equals(null) || email.getText().equals("")){
            Toast.makeText(SignUpActivity.this, ""+getString(R.string.emailRequired), Toast.LENGTH_SHORT).show();
        }
        else if (!isEmailValid(email.getText().toString())) {
            Toast.makeText(SignUpActivity.this, getString(R.string.enter__correct_email), Toast.LENGTH_SHORT).show();
        }
        else if(password.getText().equals(null) || password.getText().equals("")){
            Toast.makeText(SignUpActivity.this, ""+getString(R.string.passwordRequired), Toast.LENGTH_SHORT).show();
        }  else if(confirmPassword.getText().equals(null) || confirmPassword.getText().equals("")){
            Toast.makeText(SignUpActivity.this, ""+getString(R.string.confirmPasswordRequired), Toast.LENGTH_SHORT).show();
        }  else if(!confirmPassword.getText().toString().equals(password.getText().toString())){
            Toast.makeText(SignUpActivity.this, ""+getString(R.string.confirmPasswordNotMatchesPassword), Toast.LENGTH_SHORT).show();
        } else if(phone.getText().equals(null) || phone.getText().equals("")){
            Toast.makeText(SignUpActivity.this, ""+getString(R.string.phoneRequired), Toast.LENGTH_SHORT).show();
        } else {
            ConnectivityManager conMgr = (ConnectivityManager) SignUpActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = conMgr.getActiveNetworkInfo();

            if (networkInfo != null && networkInfo.isConnected()) {
                register(AppConstants.USER_REGISTER,fullName.getText().toString(),email.getText().toString()
                        ,phone.getText().toString(),password.getText().toString());

            }
            else {
                Toast.makeText(SignUpActivity.this, ""+getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
            }




        }
            }
        });

        clickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void register(final  String register_url,
                         final String  name,final  String email ,final String phone,final String password) {
        showDialog();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, register_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject register_response=new JSONObject(response);
                            String  code=register_response.getString("code");
                            String message=register_response.getString("message");
                            int  status=register_response.getInt("status");
                            Log.e("WAFAA",response);

                            if(status==1){
                                Toast.makeText(SignUpActivity.this, ""+message, Toast.LENGTH_SHORT).show();
                                sharedPreferences = getSharedPreferences(AppConstants.KEY_SIGN_UP,MODE_PRIVATE);
                                editor_signUp = sharedPreferences.edit();
                                editor_signUp.putString(AppConstants.EMAIL, email.toString());
                                editor_signUp.putString(AppConstants.PASSWORD, password.toString());
                                //boolean isDone = editor.commit();
                                //editor.apply();
                                editor_signUp.putString(AppConstants.ACCOUNT_TYPE, AppConstants.Beneficiary);
                                editor_signUp.apply();
                                editor_signUp.commit();
                                Intent login=new Intent(SignUpActivity.this, ActivateCodeActivity.class);
                                startActivity(login);
                                finish();

                            }
                            else
                            {
                                Toast.makeText(SignUpActivity.this, "البريد الالكتروني مسجل مسبقا "+message, Toast.LENGTH_SHORT).show();

                            }

                            hideDialog();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            hideDialog();
                            Toast.makeText(SignUpActivity.this, "البريد الالكتروني مسجل مسبقا ", Toast.LENGTH_SHORT).show();

                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                hideDialog();
                Toast.makeText(SignUpActivity.this, "قيمة الجوال مستتخدمة من قبل ", Toast.LENGTH_SHORT).show();


            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap();
                map.put("name",name);
                map.put("email",email);
                map.put("phone",phone);
                map.put("password",password);








                return map;

            }
        }
                ;

        MyApplication.getInstance().addToRequestQueue(stringRequest);


    }








    public void showDialog() {
        progressDialog = new ProgressDialog(SignUpActivity.this);
        progressDialog.setMessage(getString(R.string.load_login));
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void hideDialog() {

        if (progressDialog.isShowing()) progressDialog.dismiss();
    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
