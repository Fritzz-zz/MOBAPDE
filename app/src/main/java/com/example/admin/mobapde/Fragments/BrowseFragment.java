package com.example.admin.mobapde.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.admin.mobapde.BrowseRecycler.BrowseAdapter;
import com.example.admin.mobapde.BrowseRecycler.BrowseModel;
import com.example.admin.mobapde.MainActivity;
import com.example.admin.mobapde.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BrowseFragment extends Fragment {

    private RecyclerView recycler;
    private BrowseAdapter adapter;
    private RecyclerView.LayoutManager manager;

    private List<BrowseModel> list;
    private DatabaseReference databaseReference;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_browse, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = new ArrayList<>();

        recycler = view.findViewById(R.id.recycler);
        recycler.hasFixedSize();
        manager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(manager);

        databaseReference = FirebaseDatabase.getInstance().getReference("Products");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    BrowseModel product = postSnapshot.getValue(BrowseModel.class);
                    list.add(product);
                }

                adapter = new BrowseAdapter(getActivity(), list);
                recycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }
}
