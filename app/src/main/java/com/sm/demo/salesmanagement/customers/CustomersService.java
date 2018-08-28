package com.sm.demo.salesmanagement.customers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.sm.demo.salesmanagement.database.ConstantKey;
import com.sm.demo.salesmanagement.database.SQLiteDAO;

import java.sql.Timestamp;
import java.util.ArrayList;

public class CustomersService {

    private SQLiteDAO dao;
    private ArrayList<CustomersModel> arrayList;

    protected CustomersService(Context context) {
        arrayList = new ArrayList<>();
        dao = new SQLiteDAO(context);
    }

    //Adding single object
    protected long addCustomer(CustomersModel model){
        final ContentValues values = new ContentValues();
        values.put(ConstantKey.CUSTOMERS_COLUMN1, model.getCustomerName());
        values.put(ConstantKey.CUSTOMERS_COLUMN2, model.getCustomerPhoneNumber());
        values.put(ConstantKey.CUSTOMERS_COLUMN3, model.getCustomerEmail());
        values.put(ConstantKey.CUSTOMERS_COLUMN4, model.getCustomerContactPerson());
        values.put(ConstantKey.CUSTOMERS_COLUMN5, model.getCustomerDiscount());
        values.put(ConstantKey.CUSTOMERS_COLUMN6, model.getCustomerAddress());
        values.put(ConstantKey.CUSTOMERS_COLUMN7, model.getCustomerDescription());
        values.put(ConstantKey.CUSTOMERS_COLUMN8, "created by kamal");
        values.put(ConstantKey.CUSTOMERS_COLUMN9, "");
        values.put(ConstantKey.CUSTOMERS_COLUMN10, String.valueOf(new Timestamp(System.currentTimeMillis())));

        return dao.addData(ConstantKey.CUSTOMERS_TABLE_NAME, values);
    }

    //Getting all objects
    protected ArrayList<CustomersModel> getAllCustomers(){
        arrayList = new ArrayList<>();
        Cursor cursor = dao.getAllData(ConstantKey.SELECT_CUSTOMERS_TABLE);
        if(cursor.moveToFirst()){
            do{
                String customerId = cursor.getString(cursor.getColumnIndex(ConstantKey.COLUMN_ID));
                String customerName = cursor.getString(cursor.getColumnIndex(ConstantKey.CUSTOMERS_COLUMN1));
                String customerPhoneNumber = cursor.getString(cursor.getColumnIndex(ConstantKey.CUSTOMERS_COLUMN2));
                String customerEmail = cursor.getString(cursor.getColumnIndex(ConstantKey.CUSTOMERS_COLUMN3));
                String customerContactPerson = cursor.getString(cursor.getColumnIndex(ConstantKey.CUSTOMERS_COLUMN4));
                double customerDiscount = Double.parseDouble(cursor.getString(cursor.getColumnIndex(ConstantKey.CUSTOMERS_COLUMN5)));
                String customerAddress = cursor.getString(cursor.getColumnIndex(ConstantKey.CUSTOMERS_COLUMN6));
                String customerDescription = cursor.getString(cursor.getColumnIndex(ConstantKey.CUSTOMERS_COLUMN7));
                String createdById = cursor.getString(cursor.getColumnIndex(ConstantKey.CUSTOMERS_COLUMN8));
                String updatedById = cursor.getString(cursor.getColumnIndex(ConstantKey.CUSTOMERS_COLUMN9));
                String createdAt = cursor.getString(cursor.getColumnIndex(ConstantKey.CUSTOMERS_COLUMN10));

                CustomersModel model = new CustomersModel(customerId, customerName,customerPhoneNumber,customerEmail,customerContactPerson,customerDiscount,customerAddress,customerDescription,createdById,updatedById,createdAt);
                arrayList.add(model);
            }while(cursor.moveToNext());
        }
        return arrayList;
    }

    //Deleting single object
    protected long deleteCustomerById(String id) {
        return dao.deleteDataById(ConstantKey.CUSTOMERS_TABLE_NAME, id);
    }

    //Updating single object
    public long updateCustomerById(CustomersModel model, String id) {
        ContentValues values = new ContentValues();
        values.put(ConstantKey.CUSTOMERS_COLUMN1, model.getCustomerName());
        values.put(ConstantKey.CUSTOMERS_COLUMN2, model.getCustomerPhoneNumber());
        values.put(ConstantKey.CUSTOMERS_COLUMN3, model.getCustomerEmail());
        values.put(ConstantKey.CUSTOMERS_COLUMN4, model.getCustomerContactPerson());
        values.put(ConstantKey.CUSTOMERS_COLUMN5, model.getCustomerDiscount());
        values.put(ConstantKey.CUSTOMERS_COLUMN6, model.getCustomerAddress());
        values.put(ConstantKey.CUSTOMERS_COLUMN7, model.getCustomerDescription());
        values.put(ConstantKey.CUSTOMERS_COLUMN8, "");
        values.put(ConstantKey.CUSTOMERS_COLUMN9, "updated by kamal");
        values.put(ConstantKey.CUSTOMERS_COLUMN10, String.valueOf(new Timestamp(System.currentTimeMillis())));

        Log.i("updateDataById======= ", id+" "+String.valueOf(model.getCustomerName()) );

        return dao.updateById(ConstantKey.CUSTOMERS_TABLE_NAME, values, id);
    }

}
