package com.example.org.loginapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class SignupActivity extends AppCompatActivity {

    private EditText emailEditTxt,  passwordEditTxt;
    private LoginButton signUpFaceBtn;
    private Button signUpTwitterBtn, signUpGoogleBtn, signUpBtn;
    CallbackManager callbackManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //databaseReference = FirebaseDatabase.getInstance().getReference();


        emailEditTxt = findViewById(R.id.emailEditTxt);
        passwordEditTxt = findViewById(R.id.passwordEditTxt);
        signUpFaceBtn = findViewById(R.id.signUpFaceBtn);
        signUpTwitterBtn = findViewById(R.id.signUpTwitterBtn);
        signUpGoogleBtn = findViewById(R.id.signUpGoogleBtn);
        signUpBtn = findViewById(R.id.signUpBtn);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, RecordActivity.class);
                startActivity(intent);
            }
        });


        callbackManager = CallbackManager.Factory.create();
        signUpFaceBtn.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                Intent intent = new Intent(SignupActivity.this, RecordActivity.class);
                startActivity(intent);

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

   /*private void writeNewUser(String userId, String email, String password) {
        User user = new User(email, password);

        databaseReference.child("users").child(userId).setValue(user);
        databaseReference.child("users").child(userId).child("username").setValue(email);
        databaseReference.child("users").child(userId).child("password").setValue(password);
    }*/
}
