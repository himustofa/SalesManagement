package com.sm.demo.salesmanagement.suppliers;

import android.app.AlertDialog;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.sm.demo.salesmanagement.R;
import com.sm.demo.salesmanagement.suppliers.SuppliersAdapter;
import com.sm.demo.salesmanagement.suppliers.SuppliersModel;

import java.sql.Timestamp;
import java.util.ArrayList;

public class SuppliersActivity extends AppCompatActivity {

    private ListView listView;
    private EditText supplierName, supplierCompanyName, supplierContactPerson, supplierPhoneNumber, supplierAddress, supplierBankName, supplierBankAccount, supplierEmail, supplierWebsite;
    private Button supplierSaveButton;

    public static final String TAG = "SuppliersActivity";
    SuppliersModel suppliersModel;
    SuppliersService suppliersService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suppliers);


        listView = (ListView) findViewById(R.id.suppliers_list_view_id);

        ArrayList<SuppliersModel> arrayList = new ArrayList<>();
        arrayList.add(new SuppliersModel("Abdul Haque", "Haque Enterprise", "+8801910101007", "+8801914141707", "Dhaka Cantonment, Dhaka", "Uttara Bank", "UB-0000001", "abdulhaque@haqueenterprise.com", "www.haque.com", "Nothing to say", "001", "", String.valueOf(new Timestamp(System.currentTimeMillis()))));
        arrayList.add(new SuppliersModel("Abdul Karim", "Haque Enterprise", "+8801910101007", "+8801914141707", "Dhaka Cantonment, Dhaka", "Uttara Bank", "UB-0000001", "abdulhaque@haqueenterprise.com", "www.haque.com", "Nothing to say", "001", "", String.valueOf(new Timestamp(System.currentTimeMillis()))));
        arrayList.add(new SuppliersModel("Abdul Rahman", "Haque Enterprise", "+8801910101007", "+8801914141707", "Dhaka Cantonment, Dhaka", "Uttara Bank", "UB-0000001", "abdulhaque@haqueenterprise.com", "www.haque.com", "Nothing to say", "001", "", String.valueOf(new Timestamp(System.currentTimeMillis()))));
        arrayList.add(new SuppliersModel("Abdul Rob", "Haque Enterprise", "+8801910101007", "+8801914141707", "Dhaka Cantonment, Dhaka", "Uttara Bank", "UB-0000001", "abdulhaque@haqueenterprise.com", "www.haque.com", "Nothing to say", "001", "", String.valueOf(new Timestamp(System.currentTimeMillis()))));
        arrayList.add(new SuppliersModel("Abdul Razzak", "Haque Enterprise", "+8801910101007", "+8801914141707", "Dhaka Cantonment, Dhaka", "Uttara Bank", "UB-0000001", "abdulhaque@haqueenterprise.com", "www.haque.com", "Nothing to say", "001", "", String.valueOf(new Timestamp(System.currentTimeMillis()))));
        arrayList.add(new SuppliersModel("Abdul Aziz", "Haque Enterprise", "+8801910101007", "+8801914141707", "Dhaka Cantonment, Dhaka", "Uttara Bank", "UB-0000001", "abdulhaque@haqueenterprise.com", "www.haque.com", "Nothing to say", "001", "", String.valueOf(new Timestamp(System.currentTimeMillis()))));
        arrayList.add(new SuppliersModel("Abdul Majid", "Haque Enterprise", "+8801910101007", "+8801914141707", "Dhaka Cantonment, Dhaka", "Uttara Bank", "UB-0000001", "abdulhaque@haqueenterprise.com", "www.haque.com", "Nothing to say", "001", "", String.valueOf(new Timestamp(System.currentTimeMillis()))));
        arrayList.add(new SuppliersModel("Abdul Latif", "Haque Enterprise", "+8801910101007", "+8801914141707", "Dhaka Cantonment, Dhaka", "Uttara Bank", "UB-0000001", "abdulhaque@haqueenterprise.com", "www.haque.com", "Nothing to say", "001", "", String.valueOf(new Timestamp(System.currentTimeMillis()))));
        SuppliersAdapter adapter = new SuppliersAdapter(this,arrayList);
        listView.setAdapter(adapter);

    }

    //Display option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.suppliers_option_menu, menu);
        return true;
    }

    //To click option menu item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add_supplier) {
        }
        return true;
    }

    //Back press disabled
    /*@Override
    public void onBackPressed() {
    }*/

    //====================================================| Custom AlertDialog |====================================================

    //Add data into database using alert dialog
    protected void customAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SuppliersActivity.this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Custom View Alert Dialog");
        final View inflateForm = getLayoutInflater().inflate(R.layout.users_alert_dialog, null); // Get custom login form view.
        builder.setView(inflateForm); // Set above view in alert dialog.
        builder.setCancelable(true);
        builder.create();

        final AlertDialog dialog = builder.show(); // Because only AlertDialog has cancel method.

        supplierName = (EditText) findViewById(R.id.supplier_name);
        supplierCompanyName = (EditText) findViewById(R.id.supplier_company_name);
        supplierContactPerson = (EditText) findViewById(R.id.supplier_contact_person);
        supplierPhoneNumber = (EditText) findViewById(R.id.supplier_phone_number);
        supplierAddress = (EditText) findViewById(R.id.supplier_address);
        supplierBankName = (EditText) findViewById(R.id.supplier_bank_name);
        supplierBankAccount = (EditText) findViewById(R.id.supplier_bank_account);
        supplierEmail = (EditText) findViewById(R.id.supplier_email);
        supplierWebsite = (EditText) findViewById(R.id.supplier_website);

        supplierSaveButton = (Button) findViewById(R.id.supplier_save_button);
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
