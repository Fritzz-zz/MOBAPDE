package com.example.admin.mobapde;

import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private Adapter adapter;
    private RecyclerView.LayoutManager manager;


    private BottomNavigationView bottomNav;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = new LinearLayoutManager(this);

        adapter = new Adapter(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bottomNav = findViewById(R.id.navigationView);

        recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        //(2) Inflaters are used to populate items from the layout XML. These can be used to make
        //    views without needing to arrange the items programaitcally.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout, menu);
        MenuItem item = menu.findItem(R.id.pc_parts);
        SearchView searchView =(SearchView)item.getActionView();
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

