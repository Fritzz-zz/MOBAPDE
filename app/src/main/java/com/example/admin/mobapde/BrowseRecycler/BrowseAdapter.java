package com.example.admin.mobapde.BrowseRecycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.mobapde.MainActivity;
import com.example.admin.mobapde.R;

import java.util.ArrayList;

public class BrowseAdapter extends RecyclerView.Adapter<BrowseHolder>{

    private ArrayList<BrowseModel> list;

    public BrowseAdapter(MainActivity activity) {
        list = new ArrayList<BrowseModel>();
        //add all the data here
        //get from the firebase
        //when you buy, should update firebase and then put here
        list.add(new BrowseModel("Test", R.drawable.hamburger, 2300, 3));
        list.add(new BrowseModel("Test1", R.drawable.hamburger, 2300, 3));
        list.add(new BrowseModel("Test1", R.drawable.hamburger, 2300, 3));
        list.add(new BrowseModel("Test1", R.drawable.hamburger, 2300, 3));
        list.add(new BrowseModel("Test1", R.drawable.hamburger, 2300, 3));
        list.add(new BrowseModel("Test1", R.drawable.hamburger, 2300, 3));

    }

    @Override
    public BrowseHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.row, viewGroup, false);
        BrowseHolder holder = new BrowseHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BrowseHolder holder, int i) {
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
