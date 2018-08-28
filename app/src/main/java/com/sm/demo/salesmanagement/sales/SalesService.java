package com.sm.demo.salesmanagement.sales;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.sm.demo.salesmanagement.database.ConstantKey;
import com.sm.demo.salesmanagement.database.SQLiteDAO;

import java.sql.Timestamp;
import java.util.ArrayList;

public class SalesService {

    private SQLiteDAO dao;
    private ArrayList<SalesModel> arrayList;

    protected SalesService(Context context) {
        arrayList = new ArrayList<>();
        dao = new SQLiteDAO(context);
    }

    //Adding single object
    protected long addAdd(SalesModel model){
        final ContentValues values = new ContentValues();
        values.put(ConstantKey.SALES_COLUMN1, model.getProductName());
        values.put(ConstantKey.SALES_COLUMN2, model.getProductId());
        values.put(ConstantKey.SALES_COLUMN3, model.getProductQuantity());
        values.put(ConstantKey.SALES_COLUMN4, model.getPurchaseProductQuantity());
        values.put(ConstantKey.SALES_COLUMN5, model.getCustomerName());
        values.put(ConstantKey.SALES_COLUMN6, model.getCustomerId());
        values.put(ConstantKey.SALES_COLUMN7, model.getSalesDate());
        values.put(ConstantKey.SALES_COLUMN8, model.getSalesDiscount());
        values.put(ConstantKey.SALES_COLUMN9, model.getSalesVat());
        values.put(ConstantKey.SALES_COLUMN10, model.getSalesAmount());
        values.put(ConstantKey.SALES_COLUMN11, model.getSalesPayment());
        values.put(ConstantKey.SALES_COLUMN12, model.getSalesBalance());
        values.put(ConstantKey.SALES_COLUMN13, model.getSalesDescription());
        values.put(ConstantKey.SALES_COLUMN14, "created by kamal");
        values.put(ConstantKey.SALES_COLUMN15, "");
        values.put(ConstantKey.SALES_COLUMN16, String.valueOf(new Timestamp(System.currentTimeMillis())));

        return dao.addData(ConstantKey.SALES_TABLE_NAME, values);
    }

    //Getting all objects
    protected ArrayList<SalesModel> getAllData(){
        arrayList = new ArrayList<>();
        Cursor cursor = dao.getAllData(ConstantKey.SELECT_SALES_TABLE);
        if(cursor.moveToFirst()){
            do{
                String salesId = cursor.getString(cursor.getColumnIndex(ConstantKey.COLUMN_ID));
                String productName = cursor.getString(cursor.getColumnIndex(ConstantKey.SALES_COLUMN1));
                String productId = cursor.getString(cursor.getColumnIndex(ConstantKey.SALES_COLUMN2));
                int productQuantity = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ConstantKey.SALES_COLUMN3)));
                int purchaseProductQuantity = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ConstantKey.SALES_COLUMN4)));
                String customerName = cursor.getString(cursor.getColumnIndex(ConstantKey.SALES_COLUMN5));
                String customerId = cursor.getString(cursor.getColumnIndex(ConstantKey.SALES_COLUMN6));
                String salesDate = cursor.getString(cursor.getColumnIndex(ConstantKey.SALES_COLUMN7));
                double salesDiscount = Double.parseDouble(cursor.getString(cursor.getColumnIndex(ConstantKey.SALES_COLUMN8)));
                double salesVat = Double.parseDouble(cursor.getString(cursor.getColumnIndex(ConstantKey.SALES_COLUMN9)));
                double salesAmount = Double.parseDouble(cursor.getString(cursor.getColumnIndex(ConstantKey.SALES_COLUMN10)));
                double salesPayment = Double.parseDouble(cursor.getString(cursor.getColumnIndex(ConstantKey.SALES_COLUMN11)));
                double salesBalance = Double.parseDouble(cursor.getString(cursor.getColumnIndex(ConstantKey.SALES_COLUMN12)));
                String salesDescription = cursor.getString(cursor.getColumnIndex(ConstantKey.SALES_COLUMN13));
                String createdById = cursor.getString(cursor.getColumnIndex(ConstantKey.SALES_COLUMN14));
                String updatedById = cursor.getString(cursor.getColumnIndex(ConstantKey.SALES_COLUMN15));
                String createdAt = cursor.getString(cursor.getColumnIndex(ConstantKey.SALES_COLUMN16));

                SalesModel model = new SalesModel(salesId, productName,productId,productQuantity,purchaseProductQuantity,customerName,customerId,salesDate,salesDiscount,salesVat,salesAmount,salesPayment,salesBalance,salesDescription,createdById,updatedById,createdAt);
                arrayList.add(model);
            }while(cursor.moveToNext());
        }
        return arrayList;
    }

    //Deleting single object
    protected long deleteDataById(String id) {
        return dao.deleteDataById(ConstantKey.SALES_TABLE_NAME, id);
    }

    //Updating single object
    public long updateDataById(SalesModel model, String id) {
        ContentValues values = new ContentValues();
        values.put(ConstantKey.SALES_COLUMN1, model.getProductName());
        values.put(ConstantKey.SALES_COLUMN2, model.getProductId());
        values.put(ConstantKey.SALES_COLUMN3, model.getProductQuantity());
        values.put(ConstantKey.SALES_COLUMN4, model.getPurchaseProductQuantity());
        values.put(ConstantKey.SALES_COLUMN5, model.getCustomerName());
        values.put(ConstantKey.SALES_COLUMN6, model.getCustomerId());
        values.put(ConstantKey.SALES_COLUMN7, model.getSalesDate());
        values.put(ConstantKey.SALES_COLUMN8, model.getSalesDiscount());
        values.put(ConstantKey.SALES_COLUMN9, model.getSalesVat());
        values.put(ConstantKey.SALES_COLUMN10, model.getSalesAmount());
        values.put(ConstantKey.SALES_COLUMN11, model.getSalesPayment());
        values.put(ConstantKey.SALES_COLUMN12, model.getSalesBalance());
        values.put(ConstantKey.SALES_COLUMN13, model.getSalesDescription());
        values.put(ConstantKey.SALES_COLUMN14, "");
        values.put(ConstantKey.SALES_COLUMN15, "updated by kamal");
        values.put(ConstantKey.SALES_COLUMN16, String.valueOf(new Timestamp(System.currentTimeMillis())));

        Log.i("updateDataById======= ", id+" "+String.valueOf(model.getProductName()) );

        return dao.updateById(ConstantKey.SALES_TABLE_NAME, values, id);
    }
    
}
