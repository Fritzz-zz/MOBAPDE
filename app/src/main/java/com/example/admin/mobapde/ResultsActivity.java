package com.example.admin.mobapde;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.admin.mobapde.CategoriesRecycler.CategoriesAdapter;
import com.example.admin.mobapde.CategoriesRecycler.CategoriesModel;
import com.example.admin.mobapde.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ResultsActivity extends AppCompatActivity{

    private Toolbar toolbar;

    private RecyclerView recycler;
    private CategoriesAdapter adapter;
    private RecyclerView.LayoutManager manager;

    private ProgressBar progressCircle;
    private Context c;

    private List<CategoriesModel> list;
    private DatabaseReference databaseReference;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        this.c = this;

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });

        recycler = findViewById(R.id.resultsRecycler);
        recycler.hasFixedSize();
        manager = new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);
        list = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("Products");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    CategoriesModel product = postSnapshot.getValue(CategoriesModel.class);
                    list.add(product);
                }

                adapter = new CategoriesAdapter(c, list);
                recycler.setAdapter(adapter);
//                progressCircle.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(c, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
//                progressCircle.setVisibility(View.INVISIBLE);
            }
        });
    }


}