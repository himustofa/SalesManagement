package com.sm.demo.salesmanagement.purchases;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.sm.demo.salesmanagement.R;
import com.sm.demo.salesmanagement.purchases.PurchasesAdapter;
import com.sm.demo.salesmanagement.purchases.PurchasesModel;

import java.sql.Timestamp;
import java.util.ArrayList;

public class PurchasesActivity extends AppCompatActivity {

    ListView listView;
    PurchasesModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchases);

        listView = (ListView) findViewById(R.id.purchases_list_view_id);

        ArrayList<PurchasesModel> arrayList = new ArrayList<>();
        arrayList.add(new PurchasesModel("Soap","Abdul Rahman",100, String.valueOf(new Timestamp(System.currentTimeMillis())), 5000.0, 3000.0, 2000.0));
        arrayList.add(new PurchasesModel("Hand Wash","Abdul Rahman",100, String.valueOf(new Timestamp(System.currentTimeMillis())), 5000.0, 3000.0, 2000.0));
        arrayList.add(new PurchasesModel("Face Wash","Abdul Rahman",100, String.valueOf(new Timestamp(System.currentTimeMillis())), 5000.0, 3000.0, 2000.0));
        arrayList.add(new PurchasesModel("Detergent","Abdul Rahman",100, String.valueOf(new Timestamp(System.currentTimeMillis())), 5000.0, 3000.0, 2000.0));
        arrayList.add(new PurchasesModel("Toothpaste","Abdul Rahman",100, String.valueOf(new Timestamp(System.currentTimeMillis())), 5000.0, 3000.0, 2000.0));
        arrayList.add(new PurchasesModel("Brush","Abdul Rahman",100, String.valueOf(new Timestamp(System.currentTimeMillis())), 5000.0, 3000.0, 2000.0));
        arrayList.add(new PurchasesModel("Mouthwash","Abdul Rahman",100, String.valueOf(new Timestamp(System.currentTimeMillis())), 5000.0, 3000.0, 2000.0));
        arrayList.add(new PurchasesModel("Shampoo","Abdul Rahman",100, String.valueOf(new Timestamp(System.currentTimeMillis())), 5000.0, 3000.0, 2000.0));
        PurchasesAdapter adapter = new PurchasesAdapter(this,arrayList);
        listView.setAdapter(adapter);
    }
}
