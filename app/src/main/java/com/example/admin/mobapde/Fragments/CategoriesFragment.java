package com.example.admin.mobapde.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.mobapde.R;

public class CategoriesFragment extends Fragment {

    private TextView category1;
    private TextView category2;
    private TextView category3;
    private TextView category4;
    private TextView category5;
    private TextView category6;
    private TextView category7;

    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView img5;
    private ImageView img6;
    private ImageView img7;

    private ConstraintLayout constraintLayout1;
    private ConstraintLayout constraintLayout2;
    private ConstraintLayout constraintLayout3;
    private ConstraintLayout constraintLayout4;
    private ConstraintLayout constraintLayout5;
    private ConstraintLayout constraintLayout6;
    private ConstraintLayout constraintLayout7;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_categories, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        category1 = view.findViewById(R.id.categoryText1);
        category2 = view.findViewById(R.id.categoryText2);
        category3 = view.findViewById(R.id.categoryText3);
        category4 = view.findViewById(R.id.categoryText4);
        category5 = view.findViewById(R.id.categoryText5);
        category6 = view.findViewById(R.id.categoryText6);
        category7 = view.findViewById(R.id.categoryText7);

        img1 = view.findViewById(R.id.catPic1);
        img2 = view.findViewById(R.id.catPic2);
        img3 = view.findViewById(R.id.catPic3);
        img4 = view.findViewById(R.id.catPic4);
        img5 = view.findViewById(R.id.catPic5);
        img6 = view.findViewById(R.id.catPic6);
        img7 = view.findViewById(R.id.catPic7);

        constraintLayout1 = view.findViewById(R.id.constraintLayout1);
        constraintLayout2 = view.findViewById(R.id.constraintLayout2);
        constraintLayout3 = view.findViewById(R.id.constraintLayout3);
        constraintLayout4 = view.findViewById(R.id.constraintLayout4);
        constraintLayout5 = view.findViewById(R.id.constraintLayout5);
        constraintLayout6 = view.findViewById(R.id.constraintLayout6);
        constraintLayout7 = view.findViewById(R.id.constraintLayout7);



        img1.setImageResource(R.drawable.ic_person);
        img2.setImageResource(R.drawable.ic_person);
        img3.setImageResource(R.drawable.ic_person);
        img4.setImageResource(R.drawable.ic_person);
        img5.setImageResource(R.drawable.ic_person);
        img6.setImageResource(R.drawable.ic_person);
        img7.setImageResource(R.drawable.ic_person);


        category1.setText("CPU");
        category2.setText("Graphics Card");
        category3.setText("Motherboard");
        category4.setText("Power Supply");
        category5.setText("RAM");
        category6.setText("Cooler");
        category7.setText("Chasis");


        constraintLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "TEST", Toast.LENGTH_SHORT).show();
            }
        });
        constraintLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "TEST", Toast.LENGTH_SHORT).show();
            }
        });
        constraintLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "TEST", Toast.LENGTH_SHORT).show();
            }
        });
        constraintLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "TEST", Toast.LENGTH_SHORT).show();
            }
        });
        constraintLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "TEST", Toast.LENGTH_SHORT).show();
            }
        });
        constraintLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "TEST", Toast.LENGTH_SHORT).show();
            }
        });
        constraintLayout7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "TEST", Toast.LENGTH_SHORT).show();
            }
        });


    }


}
