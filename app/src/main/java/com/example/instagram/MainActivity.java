package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtUsername, edtEmail, edtPassword;
    private Button btnSignUp, btnLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("SignUp");

        if (ParseUser.getCurrentUser()!=null){
            socialMediaActivity();}

        final ProgressDialog progressDialog=new ProgressDialog(this);
        edtUsername = findViewById(R.id.edtUsername);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnLogIn = findViewById(R.id.btnLogIn);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edtUsername.getText().toString().equals("") || edtEmail.getText().toString().equals("") || edtPassword.getText().toString().equals("")) {
                    FancyToast.makeText(MainActivity.this, "Enter All Values", FancyToast.LENGTH_LONG, FancyToast.INFO, true).show();
                } else {
                    ParseUser parseUser = new ParseUser();
                    parseUser.put("username", edtUsername.getText().toString());
                    parseUser.put("email", edtEmail.getText().toString());
                    parseUser.put("password", edtPassword.getText().toString());
                    parseUser.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
                            socialMediaActivity();
                        }
                    });
                }
            }
        });
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LogIn.class);
                startActivity(intent);
            }
        });
        if (ParseUser.getCurrentUser()!=null){
            socialMediaActivity();        }
    }

    @Override
    public void onClick(View v) {

    }
    public void rootLayoutTapped(View view) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }catch (Exception e){
        }
    }

    public void socialMediaActivity(){
        Intent intent =new Intent(MainActivity.this,SocialMediaActivity.class);
        startActivity(intent);
    }

}