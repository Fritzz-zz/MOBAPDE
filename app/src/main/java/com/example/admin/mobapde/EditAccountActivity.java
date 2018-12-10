package com.example.admin.mobapde;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.admin.mobapde.R;

public class EditAccountActivity extends AppCompatActivity {

    private EditText username;
    private EditText email;
    private EditText birthday;
    private EditText password;

    private Button addPayment;
    private Button confirm;

    private Toolbar toolbar;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);

        username = findViewById(R.id.usernameText);
        email = findViewById(R.id.emailText);
        birthday = findViewById(R.id.birthdayText);
        password = findViewById(R.id.passwordText);

        addPayment = findViewById(R.id.addPayBtn);
        confirm = findViewById(R.id.confirmBtn);
        toolbar = findViewById(R.id.editAccountToolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });
    }


}
