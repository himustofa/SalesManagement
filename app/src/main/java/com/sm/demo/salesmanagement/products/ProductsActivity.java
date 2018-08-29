package com.sm.demo.salesmanagement.products;

import android.app.AlertDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.sm.demo.salesmanagement.R;

import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity {

    private EditText E1, E2, E3, E4, E5, E6, E7;
    private ListView productsListView;

    protected static final String TAG = "ProductsActivity";

    ProductsModel model;
    private ProductsService pServie;
    protected ProductsAdapter customAdapter;
    private ArrayList<ProductsModel> pArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        this.pServie = new ProductsService(this); //To get from service

        //===============================================| FloatingActionButton Add Button |=========================================
        FloatingActionButton fab = findViewById(R.id.add_product_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customAlertDialog();
            }
        });


        //===============================================| Getting All Data in ListView |=========================================
        productsListView = (ListView) findViewById(R.id.products_list_view_id);
        try {
            pArrayList = (ArrayList) pServie.getAllProducts();
            customAdapter = new ProductsAdapter(ProductsActivity.this, pArrayList, pServie);
            productsListView.setAdapter(customAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //===============================================| Custom adapter search |=========================================
        E7 = (EditText) findViewById(R.id.product_search);
        E7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                int textlength = cs.length();
                ArrayList<ProductsModel> tempArrayList = new ArrayList<ProductsModel>();
                for(ProductsModel c: pArrayList){
                    if (textlength <= c.getProductName().length()) {
                        if (c.getProductName().toLowerCase().contains(cs.toString().toLowerCase())) {
                            tempArrayList.add(c);
                        }
                    }
                }
                customAdapter = new ProductsAdapter(ProductsActivity.this, tempArrayList, pServie);
                productsListView.setAdapter(customAdapter);
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    //====================================================| OptionsMenu and Back press disabled |====================================================
    //Display option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.products_option_menu, menu);
        return true;
    }

    //To click option menu item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_product_option_menu:
                customAlertDialog(); //Add method
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Back press disabled
    @Override
    public void onBackPressed() {}

    //====================================================| Custom AlertDialog |====================================================
    //Add data into database using alert dialog
    protected void customAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ProductsActivity.this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Add Product");
        final View inflateForm = getLayoutInflater().inflate(R.layout.product_alert_dialog, null); // Get custom login form view.
        builder.setView(inflateForm); // Set above view in alert dialog.
        builder.setCancelable(true);
        builder.create();

        final AlertDialog dialog = builder.show(); // Because only AlertDialog has cancel method.

        this.E1 = (EditText) inflateForm.findViewById(R.id.product_name);
        this.E2 = (EditText) inflateForm.findViewById(R.id.product_code);
        this.E3 = (EditText) inflateForm.findViewById(R.id.product_quantity);
        this.E4 = (EditText) inflateForm.findViewById(R.id.product_price);
        this.E5 = (EditText) inflateForm.findViewById(R.id.product_expire_date);
        this.E6 = (EditText) inflateForm.findViewById(R.id.product_description);

        Button supplierSaveButton = (Button) inflateForm.findViewById(R.id.product_save_button);
        supplierSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    addData(E1,
                            E2,
                            E3,
                            E4,
                            E5,
                            E6);

                    if(customAdapter==null) {
                        customAdapter = new ProductsAdapter(ProductsActivity.this, pArrayList, pServie);
                        productsListView.setAdapter(customAdapter);
                    }
                    try {
                        customAdapter.productsModelArrayList = (ArrayList) pServie.getAllProducts();
                        ((BaseAdapter)productsListView.getAdapter()).notifyDataSetChanged(); //Refresh listView
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    dialog.cancel(); // Close Alert Dialog.
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    //====================================================| Select, Insert |====================================================
    private void addData(EditText e1, EditText e2, EditText e3, EditText e4, EditText e5, EditText e6) {
        model = new ProductsModel(e1.getText().toString(),e2.getText().toString(),Integer.parseInt(e3.getText().toString()),Double.parseDouble(e4.getText().toString()),e5.getText().toString(),e6.getText().toString());

        long data = ProductsActivity.this.pServie.addProduct(model);
        Log.d("Add Data ====== : ", String.valueOf(data));
        if (data > 0){
            Toast.makeText(getApplicationContext(),"Saved successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(),"Do not saved unsuccessfully", Toast.LENGTH_LONG).show();
        }
    }

    //====================================================| For Activity Starting and Closing |====================================================
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

}
