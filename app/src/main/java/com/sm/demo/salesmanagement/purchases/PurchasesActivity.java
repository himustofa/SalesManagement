package com.sm.demo.salesmanagement.purchases;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sm.demo.salesmanagement.R;
import com.sm.demo.salesmanagement.products.ProductsModel;
import com.sm.demo.salesmanagement.products.ProductsService;
import com.sm.demo.salesmanagement.suppliers.SuppliersModel;
import com.sm.demo.salesmanagement.suppliers.SuppliersService;

import java.util.ArrayList;

public class PurchasesActivity extends AppCompatActivity {

    private EditText E3, E4, E5, E6, E7, E8, E9, E10;
    private ListView purListView;
    private TextView E1d, E2d;
    private Spinner E1, E2;
    private DatePicker picker;

    protected static final String TAG = "PurchasesActivity";

    PurchasesModel model;
    private PurchasesService purService;
    protected PurchasesAdapter purAdapter;
    private ArrayList<PurchasesModel> purArrayList;

    private ProductsService pServie;
    private ArrayList<ProductsModel> pArrayList;

    private SuppliersService supService;
    private ArrayList<SuppliersModel> supArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchases);

        this.purService = new PurchasesService(this); //To get from service
        this.pServie = new ProductsService(this); //To get from product service
        this.supService = new SuppliersService(this); //To get from supplier service

        //===============================================| Getting All Data in ListView |=========================================
        purListView = (ListView) findViewById(R.id.purchases_list_view_id);
        try {
            pArrayList = (ArrayList) pServie.getAllProducts(); //Product table
            supArrayList = (ArrayList) supService.getAllData(); //Supplier table
            purArrayList = (ArrayList) purService.getPurchases();
            purAdapter = new PurchasesAdapter(PurchasesActivity.this, purArrayList, purService, pArrayList, pServie, supArrayList, supService);
            purListView.setAdapter(purAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //===============================================| FloatingActionButton Add Button |=========================================
        FloatingActionButton fab = findViewById(R.id.add_purchase_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customAlertDialog();
            }
        });


        //===============================================| Custom adapter search |=========================================
        E10 = (EditText) findViewById(R.id.purchase_search);
        E10.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                int textlength = cs.length();
                ArrayList<PurchasesModel> tempArrayList = new ArrayList<PurchasesModel>();
                for(PurchasesModel c: purArrayList){
                    if (textlength <= c.getProductName().length()) {
                        if (c.getProductName().toLowerCase().contains(cs.toString().toLowerCase())) {
                            tempArrayList.add(c);
                        }
                    }
                }
                purAdapter = new PurchasesAdapter(PurchasesActivity.this, tempArrayList, purService, pArrayList, pServie, supArrayList, supService);
                purListView.setAdapter(purAdapter);
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    //====================================================| OptionsMenu and Back press disabled |====================================================
    //Display option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.purchase_option_menu, menu);
        return true;
    }

    //To click option menu item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_purchase_option_menu:
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
        AlertDialog.Builder builder = new AlertDialog.Builder(PurchasesActivity.this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Add Purchase");
        final View inflateForm = getLayoutInflater().inflate(R.layout.purchase_alert_dialog, null); // Get custom login form view.
        builder.setView(inflateForm); // Set above view in alert dialog.
        builder.setCancelable(true);
        builder.create();

        final AlertDialog dialog = builder.show(); // Because only AlertDialog has cancel method.

        //------------------------------------------------------| Spinner |------------------------------------------------------
        this.E1 = (Spinner) inflateForm.findViewById(R.id.product_name);
        ArrayAdapter<String> pro = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);
        for(ProductsModel obj : pArrayList){
            pro.add(obj.getProductName());
        }
        E1.setAdapter(pro);
        this.E1d = (TextView) inflateForm.findViewById(R.id.product_id);
        E1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                E1d.setText(pArrayList.get(position).getProductId());
                E5.setText(String.valueOf(pArrayList.get(position).getProductPrice()));
                Log.d("Product: ", String.valueOf(pArrayList.get(position).getProductCode()));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        //---------------------------------
        this.E2 = (Spinner) inflateForm.findViewById(R.id.supplier_name);
        ArrayAdapter<String> sup = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);
        for(SuppliersModel obj : supArrayList){
            sup.add(obj.getSupplierName());
        }
        E2.setAdapter(sup);
        this.E2d = (TextView) inflateForm.findViewById(R.id.supplier_id);
        E2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                E2d.setText(supArrayList.get(position).getSupplierId());
                Log.d("Supplier: ", String.valueOf(supArrayList.get(position).getSupplierName()));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        //---------------------------------
        this.E3 = (EditText) inflateForm.findViewById(R.id.purchase_date);
        E3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchaseDate();
            }
        });
        //---------------------------------
        this.E4 = (EditText) inflateForm.findViewById(R.id.purchase_product_quantity);
        E4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    E6.setText(String.valueOf(Double.parseDouble(E4.getText().toString())*Double.parseDouble(E5.getText().toString())));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //----------------------------------
        this.E5 = (EditText) inflateForm.findViewById(R.id.purchase_product_price);
        this.E6 = (EditText) inflateForm.findViewById(R.id.purchase_amount);
        this.E7 = (EditText) inflateForm.findViewById(R.id.purchase_payment);
        //----------------------------------
        E7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    E8.setText(String.valueOf(Double.parseDouble(E6.getText().toString()) - Double.parseDouble(E7.getText().toString())));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //----------------------------------
        this.E8 = (EditText) inflateForm.findViewById(R.id.purchase_balance);
        this.E9 = (EditText) inflateForm.findViewById(R.id.purchase_description);
        //---------------------------------------------------------------------------------------------------------------------------

        Button supplierSaveButton = (Button) inflateForm.findViewById(R.id.purchase_save_button);
        supplierSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    addData(E1,E1d,
                            E2,E2d,
                            E3,
                            E4,
                            E5,
                            E6,
                            E7,
                            E8,
                            E9);

                    if(purAdapter==null) {
                        purAdapter = new PurchasesAdapter(PurchasesActivity.this, purArrayList, purService, pArrayList, pServie, supArrayList, supService);
                        purListView.setAdapter(purAdapter);
                    }
                    try {
                        purAdapter.purchasesModelArrayList = (ArrayList) purService.getPurchases();
                        ((BaseAdapter)purListView.getAdapter()).notifyDataSetChanged(); //Refresh listView
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

    //DatePicker
    private void purchaseDate() {
        picker = new DatePicker(this);
        int curYear = picker.getYear();
        int curMonth = picker.getMonth()+1;
        int curDayOfMonth = picker.getDayOfMonth();
        DatePickerDialog pickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                E3.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            }
        }, curYear, curMonth, curDayOfMonth);
        pickerDialog.show();
    }

    //====================================================| Select, Insert |====================================================
    private void addData(Spinner e1, TextView e1d, Spinner e2, TextView e2d, EditText e3, EditText e4, EditText e5, EditText e6, EditText e7, EditText e8, EditText e9) {
        model = new PurchasesModel(
                e1.getSelectedItem().toString(),
                e1d.getText().toString(),
                e2.getSelectedItem().toString(),
                e2d.getText().toString(),
                e3.getText().toString(),
                Integer.parseInt(e4.getText().toString()),
                Double.parseDouble(e5.getText().toString()),
                Double.parseDouble(e6.getText().toString()),
                Double.parseDouble(e7.getText().toString()),
                Double.parseDouble(e8.getText().toString()),
                e9.getText().toString());

        long data = PurchasesActivity.this.purService.addPurchase(model);
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
