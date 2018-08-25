package com.sm.demo.salesmanagement;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.sm.demo.salesmanagement.login.LoginActivity;
import com.sm.demo.salesmanagement.users.UsersActivity;
import com.sm.demo.salesmanagement.customers.CustomersActivity;
import com.sm.demo.salesmanagement.products.ProductsActivity;
import com.sm.demo.salesmanagement.profiles.ProfilesActivity;
import com.sm.demo.salesmanagement.purchases.PurchasesActivity;
import com.sm.demo.salesmanagement.sales.SalesActivity;
import com.sm.demo.salesmanagement.suppliers.SuppliersActivity;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_id);
        toggle = new ActionBarDrawerToggle(HomeActivity.this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView) findViewById(R.id.navigation_id);
        navigationView.setNavigationItemSelectedListener(HomeActivity.this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if(menuItem.getItemId()==R.id.sales_id){
            Intent intent = new Intent(HomeActivity.this, SalesActivity.class);
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.customers_id){
            Intent intent = new Intent(HomeActivity.this, CustomersActivity.class);
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.purchases_id){
            Intent intent = new Intent(HomeActivity.this, PurchasesActivity.class);
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.products_id){
            Intent intent = new Intent(HomeActivity.this, ProductsActivity.class);
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.suppliers_id){
            Intent intent = new Intent(HomeActivity.this, SuppliersActivity.class);
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.profiles_id){
            Intent intent = new Intent(HomeActivity.this, ProfilesActivity.class);
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.users_id){
            Intent intent = new Intent(HomeActivity.this, UsersActivity.class);
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.login_id){
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        if(menuItem.getItemId()==R.id.about_id){
            aboutMe();
        }
        return false;
    }

    public void aboutMe(){
        new AlertDialog.Builder(HomeActivity.this)
                .setTitle("About")
                .setMessage("Sales Management 2018 \nVersion 1.0 \n" + HomeActivity.this.getString(R.string.developed_by))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Thank You", Toast.LENGTH_SHORT);
                    }
                }).show();
    }
}
