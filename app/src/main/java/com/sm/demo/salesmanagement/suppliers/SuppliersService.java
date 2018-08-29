package com.sm.demo.salesmanagement.suppliers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.sm.demo.salesmanagement.database.ConstantKey;
import com.sm.demo.salesmanagement.database.SQLiteDAO;

import java.sql.Timestamp;
import java.util.ArrayList;

public class SuppliersService {

    private SQLiteDAO dao;
    private ArrayList<SuppliersModel> arrayList;

    public SuppliersService(Context context) {
        arrayList = new ArrayList<>();
        dao = new SQLiteDAO(context);
    }

    //Adding single object
    public long addData(SuppliersModel model){
        final ContentValues values = new ContentValues();
        values.put(ConstantKey.SUPPLIERS_COLUMN1, model.getSupplierName());
        values.put(ConstantKey.SUPPLIERS_COLUMN2, model.getSupplierCompanyName());
        values.put(ConstantKey.SUPPLIERS_COLUMN3, model.getSupplierContactPerson());
        values.put(ConstantKey.SUPPLIERS_COLUMN4, model.getSupplierPhoneNumber());
        values.put(ConstantKey.SUPPLIERS_COLUMN5, model.getSupplierAddress());
        values.put(ConstantKey.SUPPLIERS_COLUMN6, model.getSupplierBankName());
        values.put(ConstantKey.SUPPLIERS_COLUMN7, model.getSupplierBankAccount());
        values.put(ConstantKey.SUPPLIERS_COLUMN8, model.getSupplierEmail());
        values.put(ConstantKey.SUPPLIERS_COLUMN9, model.getSupplierWebsite());
        values.put(ConstantKey.SUPPLIERS_COLUMN10, model.getSupplierDescription());
        values.put(ConstantKey.SUPPLIERS_COLUMN11, "created by kamal");
        values.put(ConstantKey.SUPPLIERS_COLUMN12, "");
        values.put(ConstantKey.SUPPLIERS_COLUMN13, String.valueOf(new Timestamp(System.currentTimeMillis())));

        return dao.addData(ConstantKey.SUPPLIERS_TABLE_NAME, values);
    }

    //Getting all objects
    public ArrayList<SuppliersModel> getAllData(){
        arrayList = new ArrayList<>();
        Cursor cursor = dao.getAllData(ConstantKey.SELECT_SUPPLIERS_TABLE);
        if(cursor.moveToFirst()){
            do{
                String supplierId = cursor.getString(cursor.getColumnIndex(ConstantKey.COLUMN_ID));
                String supplierName = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN1));
                String supplierCompanyName = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN2));
                String supplierContactPerson = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN3));
                String supplierPhoneNumber = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN4));
                String supplierAddress = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN5));
                String supplierBankName = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN6));
                String supplierBankAccount = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN7));
                String supplierEmail = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN8));
                String supplierWebsite = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN9));
                String supplierDescription = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN10));
                String createdById = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN11));
                String updatedById = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN12));
                String createdAt = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN13));

                SuppliersModel model = new SuppliersModel(supplierId, supplierName,supplierCompanyName,supplierContactPerson,supplierPhoneNumber,supplierAddress,supplierBankName,supplierBankAccount,supplierEmail,supplierWebsite,supplierDescription,createdById,updatedById,createdAt);
                arrayList.add(model);
            }while(cursor.moveToNext());
        }
        return arrayList;
    }

    //Deleting single object
    public long deleteDataById(String id) {
        return dao.deleteDataById(ConstantKey.SUPPLIERS_TABLE_NAME, id);
    }

    //Updating single object
    public long updateDataById(SuppliersModel model, String id) {
        ContentValues values = new ContentValues();
        values.put(ConstantKey.SUPPLIERS_COLUMN1, model.getSupplierName());
        values.put(ConstantKey.SUPPLIERS_COLUMN2, model.getSupplierCompanyName());
        values.put(ConstantKey.SUPPLIERS_COLUMN3, model.getSupplierContactPerson());
        values.put(ConstantKey.SUPPLIERS_COLUMN4, model.getSupplierPhoneNumber());
        values.put(ConstantKey.SUPPLIERS_COLUMN5, model.getSupplierAddress());
        values.put(ConstantKey.SUPPLIERS_COLUMN6, model.getSupplierBankName());
        values.put(ConstantKey.SUPPLIERS_COLUMN7, model.getSupplierBankAccount());
        values.put(ConstantKey.SUPPLIERS_COLUMN8, model.getSupplierEmail());
        values.put(ConstantKey.SUPPLIERS_COLUMN9, model.getSupplierWebsite());
        values.put(ConstantKey.SUPPLIERS_COLUMN10, model.getSupplierDescription());
        values.put(ConstantKey.SUPPLIERS_COLUMN11, "");
        values.put(ConstantKey.SUPPLIERS_COLUMN12, "updated by kamal");
        values.put(ConstantKey.SUPPLIERS_COLUMN13, String.valueOf(new Timestamp(System.currentTimeMillis())));

        Log.i("updateDataById======= ", id+" "+String.valueOf(model.getSupplierName()) );

        return dao.updateById(ConstantKey.SUPPLIERS_TABLE_NAME, values, id);
    }

}
