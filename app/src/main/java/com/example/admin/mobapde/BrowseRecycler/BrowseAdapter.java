package com.example.admin.mobapde.BrowseRecycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.mobapde.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;



import java.util.List;

public class BrowseAdapter extends RecyclerView.Adapter<BrowseHolder>{

    private List <BrowseModel> list;


    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;

    private Context context;



    public BrowseAdapter(Context c, List<BrowseModel> products) {
        this.context = c;
        list = products;

//
//        list.add(new BrowseModel("Test", R.drawable.gpu, 12300, 3));
//        list.add(new BrowseModel("Test1", R.drawable.gpu1, 22600, 3));
//        list.add(new BrowseModel("Test1", R.drawable.casecool, 540, 3));
//        list.add(new BrowseModel("Test1", R.drawable.chasis, 3300, 3));
//        list.add(new BrowseModel("Test1", R.drawable.cpu, 10500, 3));
//        list.add(new BrowseModel("Test1", R.drawable.mobo, 10300, 3));

//        list.add(new BrowseModel("Name", "ImageUrl", "Type", 10000, "Desc"));

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
//        holder.setName(list.get(i).getName());
//        holder.setPrice(Float.toString(list.get(i).getPrice()));
//        holder.setQty(Integer.toString(list.get(i).getQty()));
//        holder.setImg(list.get(i).getImg());

//        holder.setName(list.get(i).getProdName());
//        holder.setPrice(Float.toString(list.get(i).getProdPrice()));
//        holder.setQty("0");
//        holder.setImg(R.drawable.casecool);
        BrowseModel current = list.get(i);
        holder.setName(list.get(i).getProdName());
        holder.setDescription(list.get(i).getProdDesc());
        holder.setPrice(Float.toString(list.get(i).getProdPrice()));
        holder.setImageURL(list.get(i).getProdImageUrl());
        holder.setQty(String.valueOf(list.get(i).getProdQty()));
        Picasso.get()
                .load(list.get(i).getProdImageUrl())
                .fit()
                .centerCrop()
                .into(holder.getImageView());

        Log.d("ITEMLIST", "LIST: " + list.get(i).getProdName());


    }

    @Override
    public int getItemCount() {
        return list.size();

    }

//    public class ImageViewHolder extends RecyclerView.ViewHolder {
//
//        public TextView textView;
//        public ImageView imageView;
//
//        public ImageViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//
//
//
//        }
//    }
}
