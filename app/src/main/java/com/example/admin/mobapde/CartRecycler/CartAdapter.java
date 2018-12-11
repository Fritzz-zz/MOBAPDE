package com.example.admin.mobapde.CartRecycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.mobapde.FeaturedRecycler.FeaturedHolder;
import com.example.admin.mobapde.FeaturedRecycler.FeaturedModel;
import com.example.admin.mobapde.R;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartHolder>{

    private List<CartModel> list;
    private Context context;


    public CartAdapter(Context c, List<CartModel> cart) {
        list = cart;
        context = c;

        //add all the data here
        //get from the firebase
        //when you buy, should update firebase and then put here



    }

    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.cart_row, viewGroup, false);
        CartHolder holder = new CartHolder(view, this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder cartHolder, int i) {
        cartHolder.setName(list.get(i).getProdName());
        cartHolder.setPrice(Float.toString(list.get(i).getProdPrice()));
        cartHolder.setQty(Integer.toString(list.get(i).getProdQty()));
        cartHolder.setCartID(list.get(i).getCartID());
        cartHolder.setContext(context);

    }


    @Override
    public int getItemCount() {
        return list.size();

    }

    public void removeRow(int position){
        list.remove(position);
        notifyItemRemoved(position);
    }
}
