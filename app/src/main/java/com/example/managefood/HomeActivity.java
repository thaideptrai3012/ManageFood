package com.example.managefood;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView nav_view;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    ImageView imgFastFood, imgRice, imgHealthy, imgBeverage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerLayout = findViewById(R.id.drawerLayout);
        nav_view = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        imgBeverage = findViewById(R.id.drink);
        imgRice = findViewById(R.id.rice);
        imgHealthy = findViewById(R.id.healthyFood);
        imgFastFood = findViewById(R.id.fastFood);


        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        nav_view.setNavigationItemSelectedListener(this);
        imgFastFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, FoodActivity.class);
                intent.putExtra("TYPE_FOOD","FastFood");
                startActivity(intent);
            }
        });
        imgHealthy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, FoodActivity.class);
                intent.putExtra("TYPE_FOOD","Healthy");
                startActivity(intent);
            }
        });
        imgRice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, FoodActivity.class);
                intent.putExtra("TYPE_FOOD","Rice");
                startActivity(intent);
            }
        });
        imgBeverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, FoodActivity.class);
                intent.putExtra("TYPE_FOOD","Beverage");
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.cart:
                Intent x = new Intent(HomeActivity.this, CartActivity.class);
                startActivity(x);
                break;
            case R.id.order:
                Intent y = new Intent(HomeActivity.this, OrderActivity.class);
                startActivity(y);
                break;
            case R.id.changePass:
                Intent z = new Intent(HomeActivity.this, ChangePassActivity.class);
                startActivity(z);
                break;
            case R.id.logOut:
                Intent t = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(t);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}