package com.example.admin.mobapde;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main2Activity extends AppCompatActivity {

    EditText editTextModel, editTextBrand;
    Button SaveBtn;
    Spinner spinnerType;
    DatabaseReference mRootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editTextModel = findViewById(R.id.editTextModel);
        editTextBrand = findViewById(R.id.editTextBrand);
        SaveBtn = findViewById(R.id.SaveBtn);
        spinnerType = findViewById(R.id.spinnerType);


        mRootRef = FirebaseDatabase.getInstance().getReference("Product");

        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProduct();
            }
        });

    }

    private void addProduct(){
        String Model = editTextModel.getText().toString().trim();
        String Brand = editTextBrand.getText().toString().trim();
        String Type = spinnerType.getSelectedItem().toString();

        if(!TextUtils.isEmpty(Model) || !TextUtils.isEmpty(Brand)){
            String id = mRootRef.push().getKey();

            Product product = new Product(id,Model,Brand,Type);

            mRootRef.child(id).setValue(product);

            Toast.makeText(this,"Product Added",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"Fill up all the fields",Toast.LENGTH_LONG).show();
        }
    }


}
