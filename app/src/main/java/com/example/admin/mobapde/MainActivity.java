package com.example.admin.mobapde;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.admin.mobapde.Fragments.BrowseFragment;
import com.example.admin.mobapde.Fragments.CartFragment;
import com.example.admin.mobapde.Fragments.CategoriesFragment;
import com.example.admin.mobapde.Fragments.FeaturedFragment;
import com.example.admin.mobapde.Fragments.OptionsFragment;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;
    private Toolbar toolbar;

    private int selected;

    private Context c;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.c = this;





        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bottomNav = findViewById(R.id.navigationView);



//        recycler = findViewById(R.id.recycler);
//        recycler.setLayoutManager(manager);
//        recycler.setAdapter(adapter);

//        recycler.addItemDecoration(new DividerItemDecoration(recycler.getContext(), 1));

        loadFragment(new FeaturedFragment());


        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;
                switch (menuItem.getItemId()) {

                    case R.id.home:

                        selectedFragment = new FeaturedFragment();
                        selected = 1;
                        break;

                    case R.id.browse:

                        selectedFragment = new BrowseFragment();
                        selected = 2;
                        break;

                    case R.id.categories:

                        selectedFragment = new CategoriesFragment();
                        selected = 3;
                        break;

                    case R.id.cart:

                        selectedFragment = new CartFragment();
                        selected = 4;
                        break;

                    case R.id.options:
                        //toolbar.setTitle("Options");
                        selectedFragment = new OptionsFragment();
                        selected = 5;
                        break;


                }
                return loadFragment(selectedFragment);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        //(2) Inflaters are used to populate items from the layout XML. These can be used to make
        //    views without needing to arrange the items programaitcally.
        MenuInflater inflater = getMenuInflater();
        //if they there is no user logged in
        inflater.inflate(R.menu.menu_layout, menu);
        //else
        //inflater.inflate(R.menu.menu_layout_logout, menu);
        MenuItem item = menu.findItem(R.id.pc_parts);
        SearchView searchView =(SearchView)item.getActionView();
        return true;
    }

    public boolean loadFragment(Fragment fragment) {
        if (fragment != null){

            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();


            return true;
        }


        return false;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.login:
                Intent loginIntent = new Intent(c, LogInActivity.class);
                c.startActivity(loginIntent);

                selected = 6;
                break;

            case R.id.signup:
                Intent signupIntent = new Intent(c, SignUpActivity.class);
                c.startActivity(signupIntent);
                selected = 7;
                break;
            case R.id.logout:
                selected = 8;
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}

