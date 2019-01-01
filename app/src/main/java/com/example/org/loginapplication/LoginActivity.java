package com.example.org.loginapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class LoginActivity extends AppCompatActivity {

    EditText emailEditTxt,  passwordEditTxt;
    LoginButton loginFaceBtn;
    Button loginTwitterBtn, loginGoogleBtn, loginBtn;
    TextView signUpTxtView;

    CallbackManager callbackManager;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditTxt = findViewById(R.id.emailEditTxt);
        passwordEditTxt = findViewById(R.id.passwordEditTxt);
        loginFaceBtn = findViewById(R.id.loginFaceBtn);
        loginTwitterBtn = findViewById(R.id.loginTwitterBtn);
        loginGoogleBtn = findViewById(R.id.loginGoogleBtn);
        loginBtn = findViewById(R.id.loginBtn);
        signUpTxtView = findViewById(R.id.signUpTxtView);
        callbackManager = CallbackManager.Factory.create();
        loginFaceBtn.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                Intent intent = new Intent(LoginActivity.this, RecordActivity.class);
                startActivity(intent);

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RecordActivity.class);
                startActivity(intent);
            }
        });

        signUpTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
