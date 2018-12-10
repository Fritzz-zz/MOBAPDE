package com.example.admin.mobapde.FeaturedRecycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.mobapde.BrowseRecycler.BrowseHolder;
import com.example.admin.mobapde.BrowseRecycler.BrowseModel;
import com.example.admin.mobapde.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedHolder>{

    private List<FeaturedModel> list;


    public FeaturedAdapter(List<FeaturedModel> list) {
        this.list = list;

//        list.add(new FeaturedModel("Test", R.drawable.gpu1));
//        list.add(new FeaturedModel("Test2", R.drawable.gpu2));
//        list.add(new FeaturedModel("Test3", R.drawable.gpu3));

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
        //featuredHolder.setImg(list.get(i).getImg());
        FeaturedModel current = list.get(i);
        featuredHolder.setName(list.get(i).getProdName());
        featuredHolder.setDescription(list.get(i).getProdDesc());
        featuredHolder.setPrice(Float.toString(list.get(i).getProdPrice()));
        featuredHolder.setImageURL(list.get(i).getProdImageUrl());
        featuredHolder.setQty(String.valueOf(list.get(i).getProdQty()));
        Picasso.get()
                .load(list.get(i).getProdImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .fit()
                .centerCrop()
                .into(featuredHolder.getImageView());
    }


    @Override
    public int getItemCount() {
        return list.size();

    }
}
