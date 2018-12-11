package com.example.admin.mobapde;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener{

    private Context c;

    private Toolbar toolbar;

    private EditText login;
    private EditText password;

    private Button proceed;

    private ImageView img;

    private FirebaseAuth mAuth;

    private String Email,Password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        this.c = this;

        findViewById(R.id.RegTxt).setOnClickListener(this);
        findViewById(R.id.loginProceedBtn).setOnClickListener(this);
        login = findViewById(R.id.logInText);
        password = findViewById(R.id.logInPassword);
        toolbar = findViewById(R.id.toolbar);
        proceed = findViewById(R.id.loginProceedBtn);
        img = findViewById(R.id.logInImageView);

        img.setImageResource(R.drawable.ic_person);

        mAuth = FirebaseAuth.getInstance();

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });

        /*proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = login.getText().toString();
                String pass = password.getText().toString();

                Toast.makeText(c, "Email: " + email + " " + "Password: " + pass, Toast.LENGTH_SHORT).show();



            }
        });*/





    }

    private void userLogin(){
        Email = login.getText().toString().trim();
        Password = password.getText().toString().trim();

        if(Email.isEmpty()){
            login.setError("Email is Required");
            login.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            login.setError("Please enter a valid Email");
            login.requestFocus();
            return;

        }

        if(Password.isEmpty()){
            password.setError("Password is required");
            password.requestFocus();
            return;
        }

        if (Password.length()<6){
            password.setError("Minimum length of Password should be 6 characters");
            password.requestFocus();
            return;
        }


        mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Log In Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LogInActivity.this, MainActivity.class);

                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    finish();
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.RegTxt:

                startActivity(new Intent(this, SignUpActivity.class));

                break;

            case R.id.loginProceedBtn:
                userLogin();
                break;

        }
    }
}
