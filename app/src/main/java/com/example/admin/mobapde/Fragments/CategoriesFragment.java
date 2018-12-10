package com.example.admin.mobapde.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.admin.mobapde.ItemDetails;
import com.example.admin.mobapde.R;
import com.example.admin.mobapde.ResultsActivity;

public class CategoriesFragment extends Fragment {

    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView img5;
    private ImageView img6;
    private ImageView img7;
    private ImageView img8;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_categories, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        img1 = view.findViewById(R.id.catPic1);
        img2 = view.findViewById(R.id.catPic2);
        img3 = view.findViewById(R.id.catPic3);
        img4 = view.findViewById(R.id.catPic4);
        img5 = view.findViewById(R.id.catPic5);
        img6 = view.findViewById(R.id.catPic6);
        img7 = view.findViewById(R.id.catPic7);
        img8 = view.findViewById(R.id.catPic8);

        img1.setImageResource(R.drawable.gpu);
        img2.setImageResource(R.drawable.cpu);
        img3.setImageResource(R.drawable.chasis);
        img4.setImageResource(R.drawable.ram);
        img5.setImageResource(R.drawable.mobo);
        img6.setImageResource(R.drawable.psu);
        img7.setImageResource(R.drawable.heatsink);
        img8.setImageResource(R.drawable.casecool);



        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ResultsActivity.class);
//                intent.putExtra("Name", name);
//                intent.putExtra("Description", description);
//                intent.putExtra("Price", price);
//                intent.putExtra("Quantity", qty);
//                intent.putExtra("Image", image);
//                intent.putExtra("ImageURL", imageURL);
                v.getContext().startActivity(intent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "TEST", Toast.LENGTH_SHORT).show();
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "TEST", Toast.LENGTH_SHORT).show();
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "TEST", Toast.LENGTH_SHORT).show();
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "TEST", Toast.LENGTH_SHORT).show();
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "TEST", Toast.LENGTH_SHORT).show();
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "TEST", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public boolean loadFragment(Fragment fragment) {
        if (fragment != null){

            getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();


            return true;
        }


        return false;
    }


}
