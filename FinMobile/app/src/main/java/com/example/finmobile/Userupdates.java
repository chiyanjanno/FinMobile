package com.example.finmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.finmobile.other.Cont;
import com.example.finmobile.other.ContAdapter;
import com.example.finmobile.other.Contributions;
import com.example.finmobile.other.Fines;
import com.example.finmobile.other.List_Data;
import com.example.finmobile.other.List_DataAdapter;
import com.example.finmobile.other.Loans;
import com.example.finmobile.other.Welfare;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Userupdates extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

   ContAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userupdates);



        setTitle("member transaction updates");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loadFragment(new Contributions());

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.contributions:
                fragment = new Contributions();
                break;

            case R.id.welfare:
                fragment = new Welfare();
                break;

            case R.id.loans:
                fragment = new Loans();
                break;

            case R.id.fines:
                fragment = new Fines();
                break;
        }

        return loadFragment(fragment);
    }





    }



