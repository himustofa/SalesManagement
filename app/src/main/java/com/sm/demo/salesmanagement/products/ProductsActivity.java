package com.sm.demo.salesmanagement.products;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.sm.demo.salesmanagement.R;
import com.sm.demo.salesmanagement.products.ProductsAdapter;
import com.sm.demo.salesmanagement.products.ProductsModel;

import java.sql.Timestamp;
import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity {

    ListView listView;
    ProductsModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        listView = (ListView) findViewById(R.id.products_list_view_id);
        ArrayList<ProductsModel> arrayList = new ArrayList<>();
        arrayList.add(new ProductsModel("Soap","SP001",100,50.0,String.valueOf(new Timestamp(System.currentTimeMillis())),"Nothing to say..","001","",String.valueOf(new Timestamp(System.currentTimeMillis()))));
        arrayList.add(new ProductsModel("Hand Wash","SP001",100,50.0,String.valueOf(new Timestamp(System.currentTimeMillis())),"Nothing to say..","001","",String.valueOf(new Timestamp(System.currentTimeMillis()))));
        arrayList.add(new ProductsModel("Face Wash","SP001",100,50.0,String.valueOf(new Timestamp(System.currentTimeMillis())),"Nothing to say..","001","",String.valueOf(new Timestamp(System.currentTimeMillis()))));
        arrayList.add(new ProductsModel("Detergent","SP001",100,50.0,String.valueOf(new Timestamp(System.currentTimeMillis())),"Nothing to say..","001","",String.valueOf(new Timestamp(System.currentTimeMillis()))));
        arrayList.add(new ProductsModel("Toothpaste","SP001",100,50.0,String.valueOf(new Timestamp(System.currentTimeMillis())),"Nothing to say..","001","",String.valueOf(new Timestamp(System.currentTimeMillis()))));
        arrayList.add(new ProductsModel("Brush","SP001",100,50.0,String.valueOf(new Timestamp(System.currentTimeMillis())),"Nothing to say..","001","",String.valueOf(new Timestamp(System.currentTimeMillis()))));
        arrayList.add(new ProductsModel("Mouthwash","SP001",100,50.0,String.valueOf(new Timestamp(System.currentTimeMillis())),"Nothing to say..","001","",String.valueOf(new Timestamp(System.currentTimeMillis()))));
        arrayList.add(new ProductsModel("Shampoo","SP001",100,50.0,String.valueOf(new Timestamp(System.currentTimeMillis())),"Nothing to say..","001","",String.valueOf(new Timestamp(System.currentTimeMillis()))));
        ProductsAdapter adapter = new ProductsAdapter(this,arrayList);
        listView.setAdapter(adapter);
    }
}
