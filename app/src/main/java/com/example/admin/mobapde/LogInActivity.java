package com.example.admin.mobapde;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity{

    private Context c;

    private Toolbar toolbar;

    private EditText login;
    private EditText password;

    private Button proceed;

    private ImageView img;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        this.c = this;

        login = findViewById(R.id.logInText);
        password = findViewById(R.id.logInPassword);
        toolbar = findViewById(R.id.toolbar);
        proceed = findViewById(R.id.loginProceedBtn);
        img = findViewById(R.id.logInImageView);

        img.setImageResource(R.drawable.ic_person);


        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = login.getText().toString();
                String pass = password.getText().toString();

                Toast.makeText(c, "Email: " + email + " " + "Password: " + pass, Toast.LENGTH_SHORT).show();



            }
        });





    }
}
