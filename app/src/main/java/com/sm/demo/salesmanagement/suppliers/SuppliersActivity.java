package com.sm.demo.salesmanagement.suppliers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.sm.demo.salesmanagement.R;
import com.sm.demo.salesmanagement.suppliers.SuppliersAdapter;
import com.sm.demo.salesmanagement.suppliers.SuppliersModel;

import java.sql.Timestamp;
import java.util.ArrayList;

public class SuppliersActivity extends AppCompatActivity {

    ListView listView;
    SuppliersModel model;

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
}
