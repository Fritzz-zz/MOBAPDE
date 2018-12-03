package com.example.admin.mobapde;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Holder extends RecyclerView.ViewHolder{

    private TextView nameView;
    private TextView priceView;
    private TextView qtyView;
    private ImageView img;
    private Button btn;

    private String name;
    private String details;
    private float price;
    private int qty;
    private int image;

    public Holder(@NonNull final View itemView) {
        super(itemView);

        nameView = itemView.findViewById(R.id.itemName);
        priceView = itemView.findViewById(R.id.price);
        qtyView = itemView.findViewById(R.id.quantity);
        btn = itemView.findViewById(R.id.button);
        img = itemView.findViewById(R.id.imageView);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ItemDetails.class);
                intent.putExtra("Name", name);
                intent.putExtra("Details", details);
                intent.putExtra("Price", price);
                intent.putExtra("Quantity", qty);
                intent.putExtra("Image", image);
                v.getContext().startActivity(intent);
            }
        });

    }

    public void setName (String newText) {
        nameView.setText(newText);
        name = newText;
    }

    public void setPrice (String newText) {
        priceView.setText("Php " + newText);
        price = Float.parseFloat(newText);
    }

    public void setQty (String newText) {
        qtyView.setText("Available: " + newText);
        qty = Integer.parseInt(newText);
    }

    public void setImg (int n) {
        image = n;
        img.setImageResource(n);
    }

}
