package com.example.admin.mobapde.CartRecycler;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.mobapde.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CartHolder extends RecyclerView.ViewHolder{

    private TextView nameView;
    private TextView priceView;
    private TextView qtyView;
    private TextView totalView;
    private ImageView img;

    private String name;
    private float price;
    private int qty;
    private CartAdapter adapter;

    private DatabaseReference mRootRef;
    private FirebaseAuth mAuth;




    public CartHolder(@NonNull final View itemView, CartAdapter cartAdapter) {
        super(itemView);
        adapter = cartAdapter;

        img = itemView.findViewById(R.id.cancelImg);
        nameView = itemView.findViewById(R.id.cartItemName);
        priceView = itemView.findViewById(R.id.cartPriceView);
        qtyView = itemView.findViewById(R.id.cartQtyView);


        mRootRef = FirebaseDatabase.getInstance().getReference("Users");
        mAuth = FirebaseAuth.getInstance();



        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "REMOVE", Toast.LENGTH_SHORT).show();
                adapter.removeRow(getAdapterPosition());
            }
        });






//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), ItemDetails.class);
//                intent.putExtra("Name", name);
//                intent.putExtra("Details", details);
//                intent.putExtra("Price", price);
//                intent.putExtra("Quantity", qty);
//                intent.putExtra("Image", image);
//                v.getContext().startActivity(intent);
//            }
//        });

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
        qtyView.setText("x " + newText);
        qty = Integer.parseInt(newText);
    }



}
