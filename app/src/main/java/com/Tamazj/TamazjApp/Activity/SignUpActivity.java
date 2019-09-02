package com.Tamazj.TamazjApp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Tamazj.TamazjApp.Model.AppConstants;
import com.Tamazj.TamazjApp.R;

public class SignUpActivity extends AppCompatActivity {

    EditText fullName, email, password, confirmPassword, phone;
    Button sign, clickHere;

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

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        if(fullName.getText().equals(null) || fullName.getText().equals("")){
            Toast.makeText(SignUpActivity.this, ""+getString(R.string.fullNameRequired), Toast.LENGTH_SHORT).show();
        } else if(email.getText().equals(null) || email.getText().equals("")){
            Toast.makeText(SignUpActivity.this, ""+getString(R.string.emailRequired), Toast.LENGTH_SHORT).show();
        }  else if(password.getText().equals(null) || password.getText().equals("")){
            Toast.makeText(SignUpActivity.this, ""+getString(R.string.passwordRequired), Toast.LENGTH_SHORT).show();
        }  else if(confirmPassword.getText().equals(null) || confirmPassword.getText().equals("")){
            Toast.makeText(SignUpActivity.this, ""+getString(R.string.confirmPasswordRequired), Toast.LENGTH_SHORT).show();
        }  else if(!confirmPassword.getText().equals(password.getText())){
            Toast.makeText(SignUpActivity.this, ""+getString(R.string.confirmPasswordNotMatchesPassword), Toast.LENGTH_SHORT).show();
        } else if(phone.getText().equals(null) || phone.getText().equals("")){
            Toast.makeText(SignUpActivity.this, ""+getString(R.string.phoneRequired), Toast.LENGTH_SHORT).show();
        } else {
            SharedPreferences sharedPreferences = getSharedPreferences(AppConstants.KEY_SIGN_UP,MODE_PRIVATE);
            SharedPreferences.Editor editor_signUp = sharedPreferences.edit();
            editor_signUp.putString(AppConstants.EMAIL, email.toString());
            editor_signUp.putString(AppConstants.PASSWORD, password.toString());
            //boolean isDone = editor.commit();
            //editor.apply();
            editor_signUp.apply();
            Intent intent = new Intent(SignUpActivity.this, SwitchAccountTypeActivity.class);
            startActivity(intent);
            finish();
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
}
