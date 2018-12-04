package com.example.admin.mobapde.CartRecycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.mobapde.FeaturedRecycler.FeaturedHolder;
import com.example.admin.mobapde.FeaturedRecycler.FeaturedModel;
import com.example.admin.mobapde.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartHolder>{

    private ArrayList<CartModel> list;


    public CartAdapter() {
        list = new ArrayList<CartModel>();
        //add all the data here
        //get from the firebase
        //when you buy, should update firebase and then put here
        list.add(new CartModel("GTX 1060", 12000, 1));
        list.add(new CartModel("GTX 1080ti", 23000, 1));


    }

    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.cart_row, viewGroup, false);
        CartHolder holder = new CartHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder cartHolder, int i) {
        cartHolder.setName(list.get(i).getsItemName());
        cartHolder.setPrice(Float.toString(list.get(i).getfPrice()));
        cartHolder.setQty(Integer.toString(list.get(i).getnQuantity()));

    }


    @Override
    public int getItemCount() {
        return list.size();

    }
}
