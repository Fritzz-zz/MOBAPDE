package com.example.admin.mobapde.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.mobapde.BrowseRecycler.BrowseAdapter;
import com.example.admin.mobapde.BrowseRecycler.BrowseModel;
import com.example.admin.mobapde.CartRecycler.CartAdapter;
import com.example.admin.mobapde.CartRecycler.CartModel;
import com.example.admin.mobapde.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {

    private RecyclerView recycler;
    private CartAdapter adapter;
    private RecyclerView.LayoutManager manager;

    private Button confirm;
    private TextView totalView;
    private TextView yourFunds;

    private DatabaseReference mRootRef;
    private DatabaseReference mRef;
    private FirebaseAuth mAuth;

    private List<CartModel> list;
    private float totalPrice;

    private float yourMoney;





    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_cart, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list = new ArrayList<>();
        mAuth = FirebaseAuth.getInstance();

        totalView = view.findViewById(R.id.cartTotalView);
        totalView.setText("");

        recycler = view.findViewById(R.id.cartRecycler);
        manager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(manager);

        adapter = new CartAdapter(getActivity(), list);
        recycler.setAdapter(adapter);
        confirm = view.findViewById(R.id.cartCheckOut);

        yourFunds = view.findViewById(R.id.cartYourFunds);

        mRootRef = FirebaseDatabase.getInstance().getReference("Users/" +mAuth.getCurrentUser().getUid()+ "/userCart");
        mRootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    CartModel product = postSnapshot.getValue(CartModel.class);



                    list.add(product);
                    totalPrice +=product.getProdPrice() * product.getProdQty();
                }

                adapter = new CartAdapter(getActivity(), list);
                recycler.setAdapter(adapter);
                totalView.setText("Php " + Float.toString(totalPrice));


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        mRef = FirebaseDatabase.getInstance().getReference("Users/" +mAuth.getCurrentUser().getUid());
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    //Log.d("CARTFLOAT", Float.toString(dataSnapshot.getValue(float.class)));
                    yourFunds.setText("Your funds: Php " + Float.toString(dataSnapshot.child("userMoney").getValue(float.class)));
                    yourMoney = dataSnapshot.child("userMoney").getValue(float.class);




            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });






        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yourMoney -= totalPrice;
                mRootRef.removeValue();

                DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference("Users");
                mRoot.child(mAuth.getCurrentUser().getUid()).child("userMoney").setValue(yourMoney);




                Toast.makeText(v.getContext(), "Transaction Complete!", Toast.LENGTH_SHORT).show();
                loadFragment(new CartFragment());

            }
        });

    }

    public boolean loadFragment(Fragment fragment) {
        if (fragment != null){

            ((AppCompatActivity) getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

            return true;
        }


        return false;
    }
}
