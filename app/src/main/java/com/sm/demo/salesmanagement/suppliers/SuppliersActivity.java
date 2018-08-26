package com.sm.demo.salesmanagement.suppliers;

import android.app.AlertDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.sm.demo.salesmanagement.R;

import java.sql.Timestamp;
import java.util.ArrayList;

public class SuppliersActivity extends AppCompatActivity {

    //private EditText supplierName, supplierCompanyName, supplierContactPerson, supplierPhoneNumber, supplierAddress, supplierBankName, supplierBankAccount, supplierEmail, supplierWebsite;
    //private Button supplierSaveButton;

    protected static final String TAG = "SuppliersActivity";
    private SuppliersModel suppliersModel;
    private SuppliersService suppliersService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suppliers);

        this.suppliersService = new SuppliersService(this); //To get from service

        ListView listView = (ListView) findViewById(R.id.suppliers_list_view_id);

        FloatingActionButton fab = findViewById(R.id.supplier_add_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customAlertDialog();
            }
        });

        /*ArrayList<SuppliersModel> arrayList = new ArrayList<>();
        arrayList.add(new SuppliersModel("Abdul Haque", "Haque Enterprise", "+8801910101007", "+8801914141707", "Dhaka Cantonment, Dhaka", "Uttara Bank", "UB-0000001", "abdulhaque@haqueenterprise.com", "www.haque.com", "Nothing to say", "001", "", String.valueOf(new Timestamp(System.currentTimeMillis()))));
        arrayList.add(new SuppliersModel("Abdul Karim", "Haque Enterprise", "+8801910101007", "+8801914141707", "Dhaka Cantonment, Dhaka", "Uttara Bank", "UB-0000001", "abdulhaque@haqueenterprise.com", "www.haque.com", "Nothing to say", "001", "", String.valueOf(new Timestamp(System.currentTimeMillis()))));
        arrayList.add(new SuppliersModel("Abdul Rahman", "Haque Enterprise", "+8801910101007", "+8801914141707", "Dhaka Cantonment, Dhaka", "Uttara Bank", "UB-0000001", "abdulhaque@haqueenterprise.com", "www.haque.com", "Nothing to say", "001", "", String.valueOf(new Timestamp(System.currentTimeMillis()))));
        arrayList.add(new SuppliersModel("Abdul Rob", "Haque Enterprise", "+8801910101007", "+8801914141707", "Dhaka Cantonment, Dhaka", "Uttara Bank", "UB-0000001", "abdulhaque@haqueenterprise.com", "www.haque.com", "Nothing to say", "001", "", String.valueOf(new Timestamp(System.currentTimeMillis()))));
        arrayList.add(new SuppliersModel("Abdul Razzak", "Haque Enterprise", "+8801910101007", "+8801914141707", "Dhaka Cantonment, Dhaka", "Uttara Bank", "UB-0000001", "abdulhaque@haqueenterprise.com", "www.haque.com", "Nothing to say", "001", "", String.valueOf(new Timestamp(System.currentTimeMillis()))));
        arrayList.add(new SuppliersModel("Abdul Aziz", "Haque Enterprise", "+8801910101007", "+8801914141707", "Dhaka Cantonment, Dhaka", "Uttara Bank", "UB-0000001", "abdulhaque@haqueenterprise.com", "www.haque.com", "Nothing to say", "001", "", String.valueOf(new Timestamp(System.currentTimeMillis()))));
        arrayList.add(new SuppliersModel("Abdul Majid", "Haque Enterprise", "+8801910101007", "+8801914141707", "Dhaka Cantonment, Dhaka", "Uttara Bank", "UB-0000001", "abdulhaque@haqueenterprise.com", "www.haque.com", "Nothing to say", "001", "", String.valueOf(new Timestamp(System.currentTimeMillis()))));
        arrayList.add(new SuppliersModel("Abdul Latif", "Haque Enterprise", "+8801910101007", "+8801914141707", "Dhaka Cantonment, Dhaka", "Uttara Bank", "UB-0000001", "abdulhaque@haqueenterprise.com", "www.haque.com", "Nothing to say", "001", "", String.valueOf(new Timestamp(System.currentTimeMillis()))));
        SuppliersAdapter adapter = new SuppliersAdapter(this,arrayList);
        listView.setAdapter(adapter);*/

    }

    //Back press disabled
    @Override
    public void onBackPressed() {
    }

    //====================================================| Custom AlertDialog |====================================================

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

        EditText supplierName = (EditText) inflateForm.findViewById(R.id.supplier_name);
        EditText supplierCompanyName = (EditText) inflateForm.findViewById(R.id.supplier_company_name);
        EditText supplierContactPerson = (EditText) inflateForm.findViewById(R.id.supplier_contact_person);
        EditText supplierPhoneNumber = (EditText) inflateForm.findViewById(R.id.supplier_phone_number);
        EditText supplierAddress = (EditText) inflateForm.findViewById(R.id.supplier_address);
        EditText supplierBankName = (EditText) inflateForm.findViewById(R.id.supplier_bank_name);
        EditText supplierBankAccount = (EditText) inflateForm.findViewById(R.id.supplier_bank_account);
        EditText supplierEmail = (EditText) inflateForm.findViewById(R.id.supplier_email);
        EditText supplierWebsite = (EditText) inflateForm.findViewById(R.id.supplier_website);

        Button supplierSaveButton = (Button) inflateForm.findViewById(R.id.supplier_save_button);
        supplierSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //addData(userPhoto, fullName, designation, email, phoneNumber, address, username, password, confirmPassword); //Adding data into database
                    dialog.cancel(); // Close Alert Dialog.
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

}
