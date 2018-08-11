package com.sm.demo.salesmanagement.suppliers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sm.demo.salesmanagement.database.ConstantKey;
import com.sm.demo.salesmanagement.database.SQLiteDatabaseHelper;

import java.sql.Timestamp;
import java.util.ArrayList;

public class SuppliersService {

    SQLiteDatabaseHelper databaseHelper;

    public SuppliersService(Context context) {
        databaseHelper = new SQLiteDatabaseHelper(context);
    }

    public long addSupplier(SuppliersModel model){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

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
        values.put(ConstantKey.SUPPLIERS_COLUMN11, "001");
        values.put(ConstantKey.SUPPLIERS_COLUMN12, "");
        values.put(ConstantKey.SUPPLIERS_COLUMN13, String.valueOf(new Timestamp(System.currentTimeMillis())));

        long insertRow = db.insert(ConstantKey.SUPPLIERS_TABLE_NAME,null, values);

        db.close();
        return insertRow;
    }

    public ArrayList<SuppliersModel> getAllStudent(){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        ArrayList<SuppliersModel> arrayList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(ConstantKey.SELECT_SUPPLIERS_TABLE,null);
        if(cursor.moveToFirst()){
            do{
                String supplierId = cursor.getString(cursor.getColumnIndex(ConstantKey.COLUMN_ID));
                String supplierName = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN1));
                String supplierCompanyName = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN1));
                String supplierContactPerson = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN1));
                String supplierPhoneNumber = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN1));
                String supplierAddress = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN1));
                String supplierBankName = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN1));
                String supplierBankAccount = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN1));
                String supplierEmail = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN1));
                String supplierWebsite = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN1));
                String supplierDescription = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN1));
                String createdById = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN1));
                String updatedById = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN1));
                String createdAt = cursor.getString(cursor.getColumnIndex(ConstantKey.SUPPLIERS_COLUMN1));

                SuppliersModel model = new SuppliersModel(supplierId, supplierName,supplierCompanyName,supplierContactPerson,supplierPhoneNumber,supplierAddress,supplierBankName,supplierBankAccount,supplierEmail,supplierWebsite,supplierDescription,createdById,updatedById,createdAt);
                arrayList.add(model);
            }while(cursor.moveToNext());
        }
        return arrayList;
    }

}
