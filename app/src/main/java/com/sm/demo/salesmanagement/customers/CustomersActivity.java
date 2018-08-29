package com.sm.demo.salesmanagement.customers;

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
import android.widget.Toast;

import com.sm.demo.salesmanagement.R;

import java.util.ArrayList;

public class CustomersActivity extends AppCompatActivity {

    private EditText E1, E2, E3, E4, E5, E6, E7, custSearch;
    private ListView custListView;

    protected static final String TAG = "CustomersActivity";

    CustomersModel custModel;
    private CustomersService cServie;
    protected CustomersAdapter custAdapter;
    private ArrayList<CustomersModel> custArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);

        this.cServie = new CustomersService(this); //To get from service

        //===============================================| FloatingActionButton Add Button |=========================================
        FloatingActionButton fab = findViewById(R.id.add_customer_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customAlertDialog();
            }
        });

        //===============================================| Getting All Data in ListView |=========================================
        custListView = (ListView) findViewById(R.id.customers_list_view_id);
        try {
            custArrayList = (ArrayList) cServie.getAllCustomers();
            custAdapter = new CustomersAdapter(CustomersActivity.this, custArrayList, cServie);
            custListView.setAdapter(custAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //===============================================| Custom adapter search |=========================================
        custSearch = (EditText) findViewById(R.id.customer_search);
        custSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                int textlength = cs.length();
                ArrayList<CustomersModel> tempArrayList = new ArrayList<CustomersModel>();
                for(CustomersModel c: custArrayList){
                    if (textlength <= c.getCustomerName().length()) {
                        if (c.getCustomerName().toLowerCase().contains(cs.toString().toLowerCase())) {
                            tempArrayList.add(c);
                        }
                    }
                }
                custAdapter = new CustomersAdapter(CustomersActivity.this, tempArrayList, cServie);
                custListView.setAdapter(custAdapter);
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });

    }

    //====================================================| OptionsMenu and Back press disabled |====================================================
    //Display option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cutomers_option_menu, menu);
        return true;
    }

    //To click option menu item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_customer_option_menu:
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
        AlertDialog.Builder builder = new AlertDialog.Builder(CustomersActivity.this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Add Customer");
        final View inflateForm = getLayoutInflater().inflate(R.layout.customer_alert_dialog, null); // Get custom login form view.
        builder.setView(inflateForm); // Set above view in alert dialog.
        builder.setCancelable(true);
        builder.create();

        final AlertDialog dialog = builder.show(); // Because only AlertDialog has cancel method.

        this.E1 = (EditText) inflateForm.findViewById(R.id.customer_name);
        this.E2 = (EditText) inflateForm.findViewById(R.id.customer_phone_number);
        this.E3 = (EditText) inflateForm.findViewById(R.id.customer_email);
        this.E4 = (EditText) inflateForm.findViewById(R.id.customer_contact_person);
        this.E5 = (EditText) inflateForm.findViewById(R.id.customer_discount);
        this.E6 = (EditText) inflateForm.findViewById(R.id.customer_address);
        this.E7 = (EditText) inflateForm.findViewById(R.id.customer_description);

        Button supplierSaveButton = (Button) inflateForm.findViewById(R.id.customer_save_button);
        supplierSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    addData(E1,
                            E2,
                            E3,
                            E4,
                            E5,
                            E6,
                            E7);

                    if(custAdapter==null) {
                        custAdapter = new CustomersAdapter(CustomersActivity.this, custArrayList, cServie);
                        custListView.setAdapter(custAdapter);
                    }
                    try {
                        custAdapter.customersModelArrayList = (ArrayList) cServie.getAllCustomers();
                        ((BaseAdapter)custListView.getAdapter()).notifyDataSetChanged(); //Refresh listView
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
    private void addData(EditText e1, EditText e2, EditText e3, EditText e4, EditText e5, EditText e6, EditText e7) {
        custModel = new CustomersModel(e1.getText().toString(),e2.getText().toString(),e3.getText().toString(),e4.getText().toString(),Double.parseDouble(e5.getText().toString()),e6.getText().toString(),e7.getText().toString());

        long data = CustomersActivity.this.cServie.addCustomer(custModel);
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
