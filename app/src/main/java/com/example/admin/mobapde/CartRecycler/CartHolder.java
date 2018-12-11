package com.example.admin.mobapde.CartRecycler;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.mobapde.Fragments.CartFragment;
import com.example.admin.mobapde.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class CartHolder extends RecyclerView.ViewHolder{

    private TextView nameView;
    private TextView priceView;
    private TextView qtyView;


    private ImageView img;

    private String name;
    private float price;
    private int qty;
    private CartAdapter adapter;

    private DatabaseReference mRootRef;
    private FirebaseAuth mAuth;

    private CartModel selected;
    private int index;

    private String cartID;

    private Context c;



    public CartHolder(@NonNull final View itemView, CartAdapter cartAdapter) {
        super(itemView);
        adapter = cartAdapter;

        index = 0;

        img = itemView.findViewById(R.id.cancelImg);
        nameView = itemView.findViewById(R.id.cartItemName);
        priceView = itemView.findViewById(R.id.cartPriceView);
        qtyView = itemView.findViewById(R.id.cartQtyView);


        mAuth = FirebaseAuth.getInstance();
        mRootRef = FirebaseDatabase.getInstance().getReference("Users/" +mAuth.getCurrentUser().getUid()+ "/userCart");
        mRootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(final DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    CartModel product = postSnapshot.getValue(CartModel.class);

                    Log.d("DEBUGCART", "Name: " + product.getProdName());
                    Log.d("CARTID", "ID: " + postSnapshot.getKey());

                    cartID = postSnapshot.getKey();




                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "REMOVE", Toast.LENGTH_SHORT).show();
                adapter.removeRow(getAdapterPosition());


                DatabaseReference db = FirebaseDatabase.getInstance().getReference("Users")
                        .child(mAuth.getCurrentUser().getUid())
                        .child("userCart").child(cartID);


                db.removeValue();
                loadFragment(new CartFragment());


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

    public boolean loadFragment(Fragment fragment) {
        if (fragment != null){

            ((AppCompatActivity) c).getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

            return true;
        }


        return false;
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

    public void setCartID (String text) {
        cartID = text;
    }

    public void setContext(Context c) {
        this.c = c;
    }
}
