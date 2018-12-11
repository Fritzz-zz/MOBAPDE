package com.example.admin.mobapde;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FundsActivity extends AppCompatActivity {

    private Context c;

    private TextView funds;

    private Toolbar toolbar;

    private Button btn100;
    private Button btn200;
    private Button btn500;
    private Button btn1000;
    private Button btn2000;
    private Button accept;
    private Button cancel;

    private float fFund;
    private float fTemp;


    @Override
    public void onBackPressed() {
        fTemp = 0;
        funds.setText(Float.toString(fFund));
        super.onBackPressed();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_funds);
        this.c = this;

        toolbar = findViewById(R.id.addFundsToolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });

        btn100 = findViewById(R.id.funds100);
        btn200 = findViewById(R.id.funds200);
        btn500 = findViewById(R.id.funds500);
        btn1000 = findViewById(R.id.funds1000);
        btn2000 = findViewById(R.id.funds2000);
        accept = findViewById(R.id.fundsAccept);
        cancel = findViewById(R.id.fundsCancel);

        funds = findViewById(R.id.fundsView);



        //set funds to user's funds
        //for now we set it to 0

        fFund = 0;
        fTemp = fFund;
        funds.setText(Float.toString(fTemp));

        btn100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fTemp +=100;
                funds.setText(Float.toString(fTemp));
            }
        });

        btn200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fTemp +=200;
                funds.setText(Float.toString(fTemp));
            }
        });

        btn500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fTemp +=500;
                funds.setText(Float.toString(fTemp));
            }
        });

        btn1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fTemp +=1000;
                funds.setText(Float.toString(fTemp));
            }
        });

        btn2000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fTemp +=2000;
                funds.setText(Float.toString(fTemp));
            }
        });

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fFund = fTemp;
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fTemp = 0;
                funds.setText(Float.toString(fFund));
            }
        });




    }
}