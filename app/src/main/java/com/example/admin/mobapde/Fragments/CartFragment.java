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

import com.example.admin.mobapde.BrowseRecycler.BrowseAdapter;
import com.example.admin.mobapde.CartRecycler.CartAdapter;
import com.example.admin.mobapde.R;

public class CartFragment extends Fragment {

    private RecyclerView recycler;
    private CartAdapter adapter;
    private RecyclerView.LayoutManager manager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_cart, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recycler = view.findViewById(R.id.cartRecycler);
        manager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(manager);

        adapter = new CartAdapter();
        recycler.setAdapter(adapter);
    }
}