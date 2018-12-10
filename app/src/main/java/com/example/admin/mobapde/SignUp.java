package com.example.admin.mobapde;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SignUp extends AppCompatActivity {

    private TextInputEditText email, pass, cpass;
    private Button login, signup;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);

        email = findViewById(R.id.textMailS);
        pass = findViewById(R.id.textPassS);
        cpass = findViewById(R.id.textCPassS);
        login = findViewById(R.id.loginSbtn);
        signup = findViewById(R.id.SignUpSbtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log = new Intent(getApplicationContext(), Login.class);
                SignUp.this.startActivity(log);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add to firebase
            }
        });

    }


}
