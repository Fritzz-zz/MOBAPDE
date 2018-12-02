package com.example.admin.mobapde;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Holder>{

    private ArrayList<Model> list;

    public Adapter (MainActivity activity) {
        list = new ArrayList<Model>();
        //add all the data here
        //get from the firebase
        //when you buy, should update firebase and then put here
        list.add(new Model("Test", R.drawable.hamburger, 2300, 3));
        list.add(new Model("Test1", R.drawable.hamburger, 2300, 3));
        list.add(new Model("Test1", R.drawable.hamburger, 2300, 3));
        list.add(new Model("Test1", R.drawable.hamburger, 2300, 3));
        list.add(new Model("Test1", R.drawable.hamburger, 2300, 3));
        list.add(new Model("Test1", R.drawable.hamburger, 2300, 3));

    }

    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.row, viewGroup, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        holder.setName(list.get(i).getName());
        holder.setPrice(Float.toString(list.get(i).getPrice()));
        holder.setQty(Integer.toString(list.get(i).getQty()));
        holder.setImg(list.get(i).getImg());

    }

    @Override
    public int getItemCount() {
        return list.size();

    }
}
