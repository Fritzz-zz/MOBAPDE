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

import com.example.admin.mobapde.BrowseRecycler.BrowseModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private Context c;

    private EditText EmailRegTxt;
    private EditText PassRegTxt;
    private ImageView img;
    private Button btn;
    private Toolbar toolbar;
    private String Email, Password;

    private FirebaseAuth mAuth;

    private DatabaseReference mRootRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.c = this;

        EmailRegTxt= findViewById(R.id.signupEditEmail);
        PassRegTxt = findViewById(R.id.signupEditPass);
        img = findViewById(R.id.signupImg);
        btn = findViewById(R.id.signupProceed);

        mAuth = FirebaseAuth.getInstance();

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

        mRootRef = FirebaseDatabase.getInstance().getReference("Users");

        btn.setOnClickListener(this);

        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tempEmail = email.getText().toString();
                String tempPass = password.getText().toString();


                Toast.makeText(c, "Email: " + tempEmail + " " + "Password: " + tempPass, Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    private void registerEmail(){
        Email = EmailRegTxt.getText().toString().trim();
        Password = PassRegTxt.getText().toString().trim();

        if(Email.isEmpty()){
            EmailRegTxt.setError("Email is Required");
            EmailRegTxt.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            EmailRegTxt.setError("Please enter a valid Email");
            EmailRegTxt.requestFocus();
            return;

        }

        if(Password.isEmpty()){
            PassRegTxt.setError("Password is required");
            PassRegTxt.requestFocus();
            return;
        }

        if (Password.length()<6){
            PassRegTxt.setError("Minimum length of Password should be 6 characters");
            PassRegTxt.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Sign Up Successful", Toast.LENGTH_SHORT).show();

                    UserModel user = new UserModel(Email,0.0f);

                    String uploadID = mRootRef.push().getKey();
                    mRootRef.child(uploadID).setValue(user);

                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else
                if(task.getException() instanceof FirebaseAuthUserCollisionException){
                    Toast.makeText(getApplicationContext(),"User is already registered", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signupProceed:
                registerEmail();
                break;


            case R.id.LogInTxt:
                startActivity(new Intent(this, LogInActivity.class));
                break;
        }
    }
}
