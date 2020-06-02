package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LogIn extends AppCompatActivity {

    EditText edtEmail,edtPassword;
    Button btnLogIn,btnSignUP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        setTitle("LogIn");

        edtEmail=findViewById(R.id.edtLoginEmail);
        edtPassword=findViewById(R.id.edtLoginPassword);
        btnLogIn=findViewById(R.id.btnLoginLogIn);
        btnSignUP=findViewById(R.id.btnSignUP);
        btnSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseUser.logInInBackground(edtEmail.getText().toString(), edtPassword.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                       if (user !=null && e==null){
                           Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                           socialMediaActivity();
                       }
                    }
                });
            }
        });

        if (ParseUser.getCurrentUser() !=null){
            ParseUser.getCurrentUser().logOut();
        }
    }
    public void socialMediaActivity(){
        Intent intent =new Intent(LogIn.this,SocialMediaActivity.class);
        startActivity(intent);
    }
}
