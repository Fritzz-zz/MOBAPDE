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


public class SignUpActivity extends AppCompatActivity {

    private Context c;

    private EditText email;
    private EditText password;
    private ImageView img;
    private Button btn;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.c = this;

        email = findViewById(R.id.signupEditEmail);
        password = findViewById(R.id.signupEditPass);
        img = findViewById(R.id.signupImg);
        btn = findViewById(R.id.signupProceed);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });

        img.setImageResource(R.drawable.ic_person_add);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tempEmail = email.getText().toString();
                String tempPass = password.getText().toString();


                Toast.makeText(c, "Email: " + tempEmail + " " + "Password: " + tempPass, Toast.LENGTH_SHORT).show();
            }
        });







    }
}
