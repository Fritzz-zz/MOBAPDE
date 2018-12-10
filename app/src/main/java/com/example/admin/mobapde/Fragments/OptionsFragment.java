package com.example.admin.mobapde.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.admin.mobapde.EditAccountActivity;
import com.example.admin.mobapde.FundsActivity;
import com.example.admin.mobapde.R;

public class OptionsFragment extends Fragment {

    private ImageView op1;
    private ImageView op2;
    private ImageView op3;
    private ImageView op4;

    private ConstraintLayout option1;
    private ConstraintLayout option2;
    private ConstraintLayout option3;
    private ConstraintLayout option4;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_options, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        op1 = view.findViewById(R.id.optionImg1);
        op2 = view.findViewById(R.id.optionImg2);
        op3 = view.findViewById(R.id.optionImg3);
        op4 = view.findViewById(R.id.optionImg4);

        option1 = view.findViewById(R.id.option1);
        option2 = view.findViewById(R.id.option2);
        option3 = view.findViewById(R.id.option3);
        option4 = view.findViewById(R.id.option4);

        op1.setImageResource(R.drawable.ic_edit_account);
        op2.setImageResource(R.drawable.ic_credit_card);
        op3.setImageResource(R.drawable.ic_attach_money);
        op4.setImageResource(R.drawable.ic_cance);

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EditAccountActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FundsActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "TEST", Toast.LENGTH_SHORT).show();
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Cart Cleared!", Toast.LENGTH_SHORT).show();
            }
        });




    }

}
