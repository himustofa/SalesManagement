package com.sm.demo.salesmanagement.customers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.sm.demo.salesmanagement.R;
import com.sm.demo.salesmanagement.customers.CustomersAdapter;
import com.sm.demo.salesmanagement.customers.CustomersModel;

import java.sql.Timestamp;
import java.util.ArrayList;

public class CustomersActivity extends AppCompatActivity {

    ListView listView;
    CustomersModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);

        listView = (ListView) findViewById(R.id.customers_list_view_id);

        ArrayList<CustomersModel> arrayList = new ArrayList<>();
        arrayList.add(new CustomersModel("Mr. Munir","+8801914141707","mustofa2008@gmail.com", 10.0));
        arrayList.add(new CustomersModel("Mr. Mamun","+8801914141707","mustofa2008@gmail.com", 10.0));
        arrayList.add(new CustomersModel("Mr. Mustofa","+8801914141707","mustofa2008@gmail.com", 10.0));
        arrayList.add(new CustomersModel("Mr. Musharoof","+8801914141707","mustofa2008@gmail.com", 10.0));
        arrayList.add(new CustomersModel("Mr. Masud","+8801914141707","mustofa2008@gmail.com", 10.0));
        arrayList.add(new CustomersModel("Mr. Manik","+8801914141707","mustofa2008@gmail.com", 10.0));
        arrayList.add(new CustomersModel("Mr. Munna","+8801914141707","mustofa2008@gmail.com", 10.0));
        CustomersAdapter adapter = new CustomersAdapter(this,arrayList);
        listView.setAdapter(adapter);
    }
}
