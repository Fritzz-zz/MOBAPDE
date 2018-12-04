package com.example.admin.mobapde.FeaturedRecycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.mobapde.BrowseRecycler.BrowseHolder;
import com.example.admin.mobapde.BrowseRecycler.BrowseModel;
import com.example.admin.mobapde.R;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedHolder>{

    private ArrayList<FeaturedModel> list;


    public FeaturedAdapter() {
        list = new ArrayList<FeaturedModel>();
        //add all the data here
        //get from the firebase
        //when you buy, should update firebase and then put here
        list.add(new FeaturedModel("Test", R.drawable.gpu1));
        list.add(new FeaturedModel("Test2", R.drawable.gpu2));
        list.add(new FeaturedModel("Test3", R.drawable.gpu3));

    }

    @Override
    public FeaturedHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.featured_row, viewGroup, false);
        FeaturedHolder holder = new FeaturedHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedHolder featuredHolder, int i) {
        featuredHolder.setImg(list.get(i).getImg());
    }


    @Override
    public int getItemCount() {
        return list.size();

    }
}
