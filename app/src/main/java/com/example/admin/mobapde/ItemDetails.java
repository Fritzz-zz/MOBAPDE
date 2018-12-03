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
    private TextView quantityView;
    private TextView quantity;

    private Button button;
    private Button add;
    private Button minus;

    private String itemName;
    private String itemDetails;
    private float itemPrice;
    private int itemQuantity;
    private int itemImage;

    private int qtycount;

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

        quantity = findViewById(R.id.Quantity);
        qtycount = 0;
        add = findViewById(R.id.addQty);
        minus = findViewById(R.id.minusQty);

        itemName = getIntent().getExtras().getString("Name");
        itemDetails = getIntent().getExtras().getString("Details");
        itemPrice = getIntent().getExtras().getFloat("Price");
        itemQuantity = getIntent().getExtras().getInt("Quantity");
        itemImage = getIntent().getExtras().getInt("Image");

        image.setImageResource(itemImage);
        nameView.setText("Item: " + itemName);
        detailsView.setText("Details:\n" + itemDetails);
        priceView.setText("Php " + Float.toString(itemPrice));
        quantityView.setText("Quantity Available: " + Integer.toString(itemQuantity));

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qtycount++;
                quantity.setText(Integer.toString(qtycount));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (qtycount > 0)
                qtycount--;
                quantity.setText(Integer.toString(qtycount));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), itemName + " was added to cart!", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
