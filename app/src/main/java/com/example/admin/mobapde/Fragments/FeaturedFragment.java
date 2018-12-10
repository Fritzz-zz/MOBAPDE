package com.example.admin.mobapde.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.admin.mobapde.FeaturedRecycler.FeaturedModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import com.example.admin.mobapde.BrowseRecycler.BrowseAdapter;
import com.example.admin.mobapde.FeaturedRecycler.FeaturedAdapter;
import com.example.admin.mobapde.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FeaturedFragment extends Fragment {

    private RecyclerView recycler;
    private FeaturedAdapter adapter;
    private RecyclerView.LayoutManager manager;

    private DatabaseReference databaseReference;
    private List<FeaturedModel> list;
    private List<FeaturedModel> rngList;

    private Random random;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_featured, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = new ArrayList<>();
        rngList = new ArrayList<>();
        random = new Random();

        recycler = view.findViewById(R.id.featuredRecycler);
        manager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(manager);

        databaseReference = FirebaseDatabase.getInstance().getReference("Products");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    FeaturedModel featured = postSnapshot.getValue(FeaturedModel.class);
                    list.add(featured);
                }



                for (int i=0;i<3;i++){
                    int rng = random.nextInt((list.size() - 0) + 0) + 0;
                    if (!rngList.contains(list.get(rng)))
                        rngList.add(list.get(rng));
                }

                adapter = new FeaturedAdapter(rngList);
                recycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }
}
