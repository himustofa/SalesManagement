package com.sm.demo.salesmanagement.suppliers;

import android.app.AlertDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.sm.demo.salesmanagement.R;

import java.util.ArrayList;

public class SuppliersActivity extends AppCompatActivity {

    private EditText E1, E2, E3, E4, E5, E6, E7, E8, E9;
    private ListView listView;
    private SearchView searchView;

    protected static final String TAG = "SuppliersActivity";

    private SuppliersService suppliersService;
    protected SuppliersAdapter customAdapter;
    private ArrayList<SuppliersModel> modelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suppliers);

        this.suppliersService = new SuppliersService(this); //To get from service


        FloatingActionButton fab = findViewById(R.id.supplier_add_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customAlertDialog();
            }
        });

        //Get all data from database and set in list view
        listView = listView = (ListView) findViewById(R.id.suppliers_list_view_id);
        modelArrayList = (ArrayList) suppliersService.getAllData();
        customAdapter = new SuppliersAdapter(SuppliersActivity.this, modelArrayList, suppliersService);
        listView.setAdapter(customAdapter);

        //Search Bar
        searchView = (SearchView) findViewById(R.id.supplier_search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                //customAdapter.getItem()
                return false;
            }
        });

    }

    //Back press disabled
    @Override
    public void onBackPressed() {
    }


    //Add data into database using alert dialog
    protected void customAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SuppliersActivity.this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Add Supplier Alert Dialog");
        final View inflateForm = getLayoutInflater().inflate(R.layout.supplier_alert_dialog, null); // Get custom login form view.
        builder.setView(inflateForm); // Set above view in alert dialog.
        builder.setCancelable(true);
        builder.create();

        final AlertDialog dialog = builder.show(); // Because only AlertDialog has cancel method.

        this.E1 = (EditText) inflateForm.findViewById(R.id.suppliers_alert_1);
        this.E2 = (EditText) inflateForm.findViewById(R.id.suppliers_alert_2);
        this.E3 = (EditText) inflateForm.findViewById(R.id.suppliers_alert_3);
        this.E4 = (EditText) inflateForm.findViewById(R.id.suppliers_alert_4);
        this.E5 = (EditText) inflateForm.findViewById(R.id.suppliers_alert_5);
        this.E6 = (EditText) inflateForm.findViewById(R.id.suppliers_alert_6);
        this.E7 = (EditText) inflateForm.findViewById(R.id.suppliers_alert_7);
        this.E8 = (EditText) inflateForm.findViewById(R.id.suppliers_alert_8);
        this.E9 = (EditText) inflateForm.findViewById(R.id.suppliers_alert_9);

        Button supplierSaveButton = (Button) inflateForm.findViewById(R.id.supplier_save_button);
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
                            E7,
                            E8,
                            E9); //Adding data into database

                    //Displaying data from database and sets listView
                    if(customAdapter==null) {
                        customAdapter = customAdapter = new SuppliersAdapter(SuppliersActivity.this, modelArrayList, suppliersService);
                        listView.setAdapter(customAdapter);
                    }
                    customAdapter.suppliersArrayList = (ArrayList) suppliersService.getAllData();
                    ((BaseAdapter)listView.getAdapter()).notifyDataSetChanged(); //Refresh listView

                    dialog.cancel(); // Close Alert Dialog.
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }


    //Adding data into database
    protected void addData(EditText e1, EditText e2, EditText e3, EditText e4, EditText e5, EditText e6, EditText e7, EditText e8, EditText e9) {
        if(!e1.getText().toString().trim().isEmpty() && !e4.getText().toString().trim().isEmpty()){

            SuppliersModel model = new SuppliersModel(
                    e1.getText().toString(),
                    e2.getText().toString(),
                    e3.getText().toString(),
                    e4.getText().toString(),
                    e5.getText().toString(),
                    e6.getText().toString(),
                    e7.getText().toString(),
                    e8.getText().toString(),
                    e9.getText().toString()
            );

            long data = SuppliersActivity.this.suppliersService.addData(model);
            Log.d("Add Data ====== : ", String.valueOf(data));
            if (data > 0){
                Toast.makeText(getApplicationContext(),"Saved successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(),"Do not saved unsuccessfully", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(),"Please insert the values in your mandatory fields.", Toast.LENGTH_LONG).show();
        }
    }

}
