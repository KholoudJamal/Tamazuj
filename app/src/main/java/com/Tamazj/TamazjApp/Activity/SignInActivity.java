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

public class SignInActivity extends AppCompatActivity {

    EditText email, password;
    Button sign, signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email = findViewById(R.id.etSignInEmail);
        password = findViewById(R.id.etSignInPassword);

        sign = findViewById(R.id.buttonSignInSign);
        signUp = findViewById(R.id.buttonSignInSignUp);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        if(email.getText().equals(null) || email.getText().equals("")){
            Toast.makeText(SignInActivity.this, ""+getString(R.string.emailRequired), Toast.LENGTH_SHORT).show();
        }  else if(password.getText().equals(null) || password.getText().equals("")){
            Toast.makeText(SignInActivity.this, ""+getString(R.string.passwordRequired), Toast.LENGTH_SHORT).show();
        }
        else {
            SharedPreferences sharedPreferences = getSharedPreferences(AppConstants.KEY_SIGN_UP,MODE_PRIVATE);
            SharedPreferences.Editor editor_signUp = sharedPreferences.edit();
            editor_signUp.putString(AppConstants.AUTHOR_EMAIL, email.toString());
            editor_signUp.putString(AppConstants.AUTHOR_PASSWORD, password.toString());
            //boolean isDone = editor.commit();
            //editor.apply();
            editor_signUp.apply();
            Intent intent = new Intent(SignInActivity.this, SwitchAccountTypeActivity.class);
            startActivity(intent);
            finish();
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
}
