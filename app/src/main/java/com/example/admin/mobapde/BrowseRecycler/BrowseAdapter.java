package com.example.admin.mobapde.BrowseRecycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.mobapde.R;

import java.util.ArrayList;

public class BrowseAdapter extends RecyclerView.Adapter<BrowseHolder>{

    private ArrayList<BrowseModel> list;


    public BrowseAdapter() {
        list = new ArrayList<BrowseModel>();
        //add all the data here
        //get from the firebase
        //when you buy, should update firebase and then put here
        list.add(new BrowseModel("Test", R.drawable.gpu, 12300, 3));
        list.add(new BrowseModel("Test1", R.drawable.gpu1, 22600, 3));
        list.add(new BrowseModel("Test1", R.drawable.casecool, 540, 3));
        list.add(new BrowseModel("Test1", R.drawable.chasis, 3300, 3));
        list.add(new BrowseModel("Test1", R.drawable.cpu, 10500, 3));
        list.add(new BrowseModel("Test1", R.drawable.mobo, 10300, 3));

    }

    @Override
    public BrowseHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.browse_row, viewGroup, false);
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
