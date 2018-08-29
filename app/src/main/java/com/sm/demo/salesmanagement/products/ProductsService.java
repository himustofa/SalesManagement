package com.sm.demo.salesmanagement.products;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.sm.demo.salesmanagement.database.ConstantKey;
import com.sm.demo.salesmanagement.database.SQLiteDAO;

import java.sql.Timestamp;
import java.util.ArrayList;

public class ProductsService {

    private SQLiteDAO dao;
    private ArrayList<ProductsModel> arrayList;

    public ProductsService(Context context) {
        arrayList = new ArrayList<>();
        dao = new SQLiteDAO(context);
    }

    //Adding single object
    public long addProduct(ProductsModel model){
        final ContentValues values = new ContentValues();
        values.put(ConstantKey.PRODUCTS_COLUMN1, model.getProductName());
        values.put(ConstantKey.PRODUCTS_COLUMN2, model.getProductCode());
        values.put(ConstantKey.PRODUCTS_COLUMN3, model.getProductQuantity());
        values.put(ConstantKey.PRODUCTS_COLUMN4, model.getProductPrice());
        values.put(ConstantKey.PRODUCTS_COLUMN5, model.getProductExpireDate());
        values.put(ConstantKey.PRODUCTS_COLUMN6, model.getProductDescription());
        values.put(ConstantKey.PRODUCTS_COLUMN7, "created by kamal");
        values.put(ConstantKey.PRODUCTS_COLUMN8, "");
        values.put(ConstantKey.PRODUCTS_COLUMN9, String.valueOf(new Timestamp(System.currentTimeMillis())));

        return dao.addData(ConstantKey.PRODUCTS_TABLE_NAME, values);
    }

    //Getting all objects
    public ArrayList<ProductsModel> getAllProducts(){
        arrayList = new ArrayList<>();
        Cursor cursor = dao.getAllData(ConstantKey.SELECT_PRODUCTS_TABLE);
        if(cursor.moveToFirst()){
            do{
                String productId = cursor.getString(cursor.getColumnIndex(ConstantKey.COLUMN_ID));
                String productName = cursor.getString(cursor.getColumnIndex(ConstantKey.PRODUCTS_COLUMN1));
                String productCode = cursor.getString(cursor.getColumnIndex(ConstantKey.PRODUCTS_COLUMN2));
                int productQuantity = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ConstantKey.PRODUCTS_COLUMN3)));
                double productPrice = Double.parseDouble(cursor.getString(cursor.getColumnIndex(ConstantKey.PRODUCTS_COLUMN4)));
                String productExpireDate = cursor.getString(cursor.getColumnIndex(ConstantKey.PRODUCTS_COLUMN5));
                String productDescription = cursor.getString(cursor.getColumnIndex(ConstantKey.PRODUCTS_COLUMN6));
                String createdById = cursor.getString(cursor.getColumnIndex(ConstantKey.PRODUCTS_COLUMN7));
                String updatedById = cursor.getString(cursor.getColumnIndex(ConstantKey.PRODUCTS_COLUMN8));
                String createdAt = cursor.getString(cursor.getColumnIndex(ConstantKey.PRODUCTS_COLUMN9));

                ProductsModel model = new ProductsModel(productId, productName,productCode,productQuantity,productPrice,productExpireDate,productDescription,createdById,updatedById,createdAt);
                arrayList.add(model);
            }while(cursor.moveToNext());
        }
        return arrayList;
    }

    //Deleting single object
    public long deleteDataById(String id) {
        return dao.deleteDataById(ConstantKey.PRODUCTS_TABLE_NAME, id);
    }

    //Updating single object
    public long updateDataById(ProductsModel model, String id) {
        ContentValues values = new ContentValues();
        values.put(ConstantKey.PRODUCTS_COLUMN1, model.getProductName());
        values.put(ConstantKey.PRODUCTS_COLUMN2, model.getProductCode());
        values.put(ConstantKey.PRODUCTS_COLUMN3, model.getProductQuantity());
        values.put(ConstantKey.PRODUCTS_COLUMN4, model.getProductPrice());
        values.put(ConstantKey.PRODUCTS_COLUMN5, model.getProductExpireDate());
        values.put(ConstantKey.PRODUCTS_COLUMN6, model.getProductDescription());
        values.put(ConstantKey.PRODUCTS_COLUMN7, "");
        values.put(ConstantKey.PRODUCTS_COLUMN8, "updated by kamal");
        values.put(ConstantKey.PRODUCTS_COLUMN9, String.valueOf(new Timestamp(System.currentTimeMillis())));

        Log.i("updateDataById======= ", id+" "+String.valueOf(model.getProductName()) );

        return dao.updateById(ConstantKey.PRODUCTS_TABLE_NAME, values, id);
    }

}
