package com.sm.demo.salesmanagement.sales;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.sm.demo.salesmanagement.R;
import com.sm.demo.salesmanagement.sales.SalesAdapter;
import com.sm.demo.salesmanagement.sales.SalesModel;

import java.sql.Timestamp;
import java.util.ArrayList;

public class SalesActivity extends AppCompatActivity {

    ListView listView;
    SalesModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        listView = (ListView) findViewById(R.id.sales_list_view_id);

        ArrayList<SalesModel> arrayList = new ArrayList<>();
        arrayList.add(new SalesModel("Soap", 2, String.valueOf(new Timestamp(System.currentTimeMillis())), "Mr. Munir", 0.0, 100.0));
        arrayList.add(new SalesModel("Hand Wash", 2, String.valueOf(new Timestamp(System.currentTimeMillis())), "Mr. Munir", 0.0, 100.0));
        arrayList.add(new SalesModel("Face Wash", 2, String.valueOf(new Timestamp(System.currentTimeMillis())), "Mr. Munir", 0.0, 100.0));
        arrayList.add(new SalesModel("Detergent", 2, String.valueOf(new Timestamp(System.currentTimeMillis())), "Mr. Munir", 0.0, 100.0));
        arrayList.add(new SalesModel("Toothpaste", 2, String.valueOf(new Timestamp(System.currentTimeMillis())), "Mr. Munir", 0.0, 100.0));
        arrayList.add(new SalesModel("Brush", 2, String.valueOf(new Timestamp(System.currentTimeMillis())), "Mr. Munir", 0.0, 100.0));
        arrayList.add(new SalesModel("Mouthwash", 2, String.valueOf(new Timestamp(System.currentTimeMillis())), "Mr. Munir", 0.0, 100.0));
        arrayList.add(new SalesModel("Shampoo", 2, String.valueOf(new Timestamp(System.currentTimeMillis())), "Mr. Munir", 0.0, 100.0));
        SalesAdapter adapter = new SalesAdapter(this,arrayList);
        listView.setAdapter(adapter);
    }
}
