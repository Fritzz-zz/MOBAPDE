package com.example.admin.mobapde;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemDetails extends AppCompatActivity {

    private ImageView image;
    private TextView nameView;
    private TextView detailsView;
    private TextView priceView;
    private Button button;

    private String itemName;
    private String itemDetails;
    private float itemPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        image = findViewById(R.id.imageView);
        nameView = findViewById(R.id.nameView);
        detailsView = findViewById(R.id.detailsView);
        priceView = findViewById(R.id.priceView);

        itemName = getIntent().getExtras().getString("Name");
        itemDetails = getIntent().getExtras().getString("Details");




    }

    private void addToCart (View view) {
        //add to firebase cart here
        Toast.makeText(view.getContext(), itemName + " was added to cart!", Toast.LENGTH_SHORT).show();
    }
}
