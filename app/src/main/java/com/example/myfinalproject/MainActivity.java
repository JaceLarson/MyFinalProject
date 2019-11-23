package com.example.myfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment())
                .commit();}

        private BottomNavigationView.OnNavigationItemSelectedListener navListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment selectedFragment = null;
                ProductsFragment product = null;

                switch (menuItem.getItemId()) {
                    case R.id.menu_home:
                        selectedFragment  = new HomeFragment();
                        break;

                    case R.id.menu_prouducts:
                        //selectedFragment = new ProductsFragment();

                        Intent intent=new Intent(MainActivity.this,ProductsFragment.class);
                        startActivity(intent);
                        break;

                    case R.id.menu_my_cart:
                        selectedFragment = new MyCartFragment();

                    case R.id.menu_my_account:
                        selectedFragment = new AccountFragment();
                        break;


                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment)
                        .commit();


                return true;
            }
        };
    }

