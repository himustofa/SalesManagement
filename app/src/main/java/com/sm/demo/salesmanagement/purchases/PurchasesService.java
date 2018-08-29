package com.sm.demo.salesmanagement.purchases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.sm.demo.salesmanagement.database.ConstantKey;
import com.sm.demo.salesmanagement.database.SQLiteDAO;

import java.sql.Timestamp;
import java.util.ArrayList;

public class PurchasesService {

    private SQLiteDAO dao;
    private ArrayList<PurchasesModel> arrayList;

    protected PurchasesService(Context context) {
        arrayList = new ArrayList<>();
        dao = new SQLiteDAO(context);
    }

    //Adding single object
    protected long addPurchase(PurchasesModel model){
        final ContentValues values = new ContentValues();
        values.put(ConstantKey.PURCHASES_COLUMN1, model.getProductName());
        values.put(ConstantKey.PURCHASES_COLUMN2, model.getProductId());
        values.put(ConstantKey.PURCHASES_COLUMN3, model.getSupplierName());
        values.put(ConstantKey.PURCHASES_COLUMN4, model.getSupplierId());
        values.put(ConstantKey.PURCHASES_COLUMN5, model.getPurchaseDate());
        values.put(ConstantKey.PURCHASES_COLUMN6, model.getPurchaseProductQuantity());
        values.put(ConstantKey.PURCHASES_COLUMN7, model.getPurchaseProductPrice());
        values.put(ConstantKey.PURCHASES_COLUMN8, model.getPurchaseAmount());
        values.put(ConstantKey.PURCHASES_COLUMN9, model.getPurchasePayment());
        values.put(ConstantKey.PURCHASES_COLUMN10, model.getPurchaseBalance());
        values.put(ConstantKey.PURCHASES_COLUMN11, model.getPurchaseDescription());
        values.put(ConstantKey.PURCHASES_COLUMN12, "created by kamal");
        values.put(ConstantKey.PURCHASES_COLUMN13, "");
        values.put(ConstantKey.PURCHASES_COLUMN14, String.valueOf(new Timestamp(System.currentTimeMillis())));

        return dao.addData(ConstantKey.PURCHASES_TABLE_NAME, values);
    }

    //Getting all objects
    protected ArrayList<PurchasesModel> getPurchases(){
        arrayList = new ArrayList<>();
        Cursor cursor = dao.getAllData(ConstantKey.SELECT_PURCHASES_TABLE);
        if(cursor.moveToFirst()){
            do{
                String purchaseId = cursor.getString(cursor.getColumnIndex(ConstantKey.COLUMN_ID));
                String productName = cursor.getString(cursor.getColumnIndex(ConstantKey.PURCHASES_COLUMN1));
                String productId = cursor.getString(cursor.getColumnIndex(ConstantKey.PURCHASES_COLUMN2));
                String supplierName = cursor.getString(cursor.getColumnIndex(ConstantKey.PURCHASES_COLUMN3));
                String supplierId = cursor.getString(cursor.getColumnIndex(ConstantKey.PURCHASES_COLUMN4));
                String purchaseDate = cursor.getString(cursor.getColumnIndex(ConstantKey.PURCHASES_COLUMN5));
                int purchaseProductQuantity = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ConstantKey.PURCHASES_COLUMN6)));
                double purchaseProductPrice = Double.parseDouble(cursor.getString(cursor.getColumnIndex(ConstantKey.PURCHASES_COLUMN7)));
                double purchaseAmount = Double.parseDouble(cursor.getString(cursor.getColumnIndex(ConstantKey.PURCHASES_COLUMN8)));
                double purchasePayment = Double.parseDouble(cursor.getString(cursor.getColumnIndex(ConstantKey.PURCHASES_COLUMN9)));
                double purchaseBalance = Double.parseDouble(cursor.getString(cursor.getColumnIndex(ConstantKey.PURCHASES_COLUMN10)));
                String purchaseDescription = cursor.getString(cursor.getColumnIndex(ConstantKey.PURCHASES_COLUMN11));
                String createdById = cursor.getString(cursor.getColumnIndex(ConstantKey.PURCHASES_COLUMN12));
                String updatedById = cursor.getString(cursor.getColumnIndex(ConstantKey.PURCHASES_COLUMN13));
                String createdAt = cursor.getString(cursor.getColumnIndex(ConstantKey.PURCHASES_COLUMN14));

                PurchasesModel model = new PurchasesModel(purchaseId, productName,productId,supplierName,supplierId,purchaseDate,purchaseProductQuantity,purchaseProductPrice,purchaseAmount,purchasePayment,purchaseBalance,purchaseDescription,createdById,updatedById,createdAt);
                arrayList.add(model);
            }while(cursor.moveToNext());
        }
        return arrayList;
    }

    //Deleting single object
    protected long deletePurchaseById(String id) {
        return dao.deleteDataById(ConstantKey.PURCHASES_TABLE_NAME, id);
    }

    //Updating single object
    public long updatePurchaseById(PurchasesModel model, String id) {
        ContentValues values = new ContentValues();
        values.put(ConstantKey.PURCHASES_COLUMN1, model.getSupplierName());
        values.put(ConstantKey.PURCHASES_COLUMN2, model.getProductId());
        values.put(ConstantKey.PURCHASES_COLUMN3, model.getSupplierName());
        values.put(ConstantKey.PURCHASES_COLUMN4, model.getSupplierId());
        values.put(ConstantKey.PURCHASES_COLUMN5, model.getPurchaseDate());
        values.put(ConstantKey.PURCHASES_COLUMN6, model.getPurchaseProductQuantity());
        values.put(ConstantKey.PURCHASES_COLUMN7, model.getPurchaseProductPrice());
        values.put(ConstantKey.PURCHASES_COLUMN8, model.getPurchaseAmount());
        values.put(ConstantKey.PURCHASES_COLUMN9, model.getPurchasePayment());
        values.put(ConstantKey.PURCHASES_COLUMN10, model.getPurchaseBalance());
        values.put(ConstantKey.PURCHASES_COLUMN11, model.getPurchaseDescription());
        values.put(ConstantKey.PURCHASES_COLUMN12, "");
        values.put(ConstantKey.PURCHASES_COLUMN13, "updated by kamal");
        values.put(ConstantKey.PURCHASES_COLUMN14, String.valueOf(new Timestamp(System.currentTimeMillis())));

        Log.i("updateDataById======= ", id+" "+String.valueOf(model.getSupplierName()) );

        return dao.updateById(ConstantKey.PURCHASES_TABLE_NAME, values, id);
    }

}
