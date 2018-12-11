package com.example.admin.mobapde;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.mobapde.BrowseRecycler.BrowseModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;



public class ItemDetails extends AppCompatActivity {

    private ImageView image;
    private TextView nameView;
    private TextView detailsView;
    private TextView priceView;
    private TextView quantityView;
    private TextView quantity;
    private Toolbar toolbar;

    private Button button;
    private Button add;
    private Button minus;

    private String itemType;
    private String itemName;
    private String itemDetails;
    private float itemPrice;
    private int itemQuantity;
    private int itemImage;

    private String itemImageURL;

    private int qtycount;

    private DatabaseReference mRootRef;
    private FirebaseAuth mAuth;
    private String pushKey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        image = findViewById(R.id.itemPicture);
        nameView = findViewById(R.id.nameView);
        detailsView = findViewById(R.id.detailsView);
        priceView = findViewById(R.id.priceView);
        quantityView = findViewById(R.id.quantityView);
        button = findViewById(R.id.button2);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });

        quantity = findViewById(R.id.Quantity);
        qtycount = 1;
        add = findViewById(R.id.addQty);
        minus = findViewById(R.id.minusQty);

        pushKey = "";

        itemName = getIntent().getExtras().getString("Name");
        itemDetails = getIntent().getExtras().getString("Description");
        itemPrice = getIntent().getExtras().getFloat("Price");
        itemQuantity = getIntent().getExtras().getInt("Quantity");
        itemImage = getIntent().getExtras().getInt("Image");
        itemImageURL = getIntent().getExtras().getString("ImageURL");
        itemType = getIntent().getExtras().getString("Type");

        mRootRef = FirebaseDatabase.getInstance().getReference("Users");
        mAuth = FirebaseAuth.getInstance();

        //image.setImageResource(itemImage);
        nameView.setText("Item: " + itemName);
        detailsView.setText("Details:\n" + itemDetails);
        priceView.setText("Php " + Float.toString(itemPrice));
        quantityView.setText("Quantity Available: " + Integer.toString(itemQuantity));
        Picasso.get()
                .load(itemImageURL)
                .fit()
                .placeholder(R.mipmap.ic_launcher)
                .centerCrop()
                .into(image);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (qtycount < itemQuantity) {
                    qtycount++;
                    quantity.setText(Integer.toString(qtycount));


                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (qtycount > 1)
                qtycount--;
                quantity.setText(Integer.toString(qtycount));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (qtycount < itemQuantity) {

//                    if (pushKey.isEmpty()) {

                        BrowseModel item = new BrowseModel(itemName, itemImageURL, itemType, itemPrice, itemDetails, qtycount);

                        DatabaseReference cartRef = mRootRef.child(mAuth.getCurrentUser().getUid()).child("userCart").push();

                        cartRef.setValue(item);
                        pushKey = cartRef.getKey();
//                    }


                    Toast.makeText(v.getContext(), itemName + " was added to cart!", Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(v.getContext(), "Not enough stock!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
