package com.sm.demo.salesmanagement.users;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.sm.demo.salesmanagement.database.ConstantKey;
import com.sm.demo.salesmanagement.database.SQLiteDAO;

import java.sql.Timestamp;
import java.util.ArrayList;

public class UsersService {

    private SQLiteDAO dao;
    private ArrayList<UsersModel> arrayList;

    protected UsersService(Context context) {
        arrayList = new ArrayList<>();
        dao = new SQLiteDAO(context);
    }

    //Adding single object
    protected long addUser(UsersModel model){
        Log.d("Service model ====== : ", String.valueOf(model.getPhotoName())+String.valueOf(model.getFullName()));
        final ContentValues values = new ContentValues();
        values.put(ConstantKey.USERS_COLUMN1, model.getFullName());
        values.put(ConstantKey.USERS_COLUMN2, model.getDesignation());
        values.put(ConstantKey.USERS_COLUMN3, model.getEmail());
        values.put(ConstantKey.USERS_COLUMN4, model.getPhoneNumber());
        values.put(ConstantKey.USERS_COLUMN5, model.getAddress());
        values.put(ConstantKey.USERS_COLUMN6, model.getUsername());
        values.put(ConstantKey.USERS_COLUMN7, model.getPassword());
        values.put(ConstantKey.USERS_COLUMN9, model.getPhotoName());
        values.put(ConstantKey.USERS_COLUMN10, model.getPhotoPath());
        values.put(ConstantKey.USERS_COLUMN11, "created by kamal");
        values.put(ConstantKey.USERS_COLUMN12, "");
        values.put(ConstantKey.USERS_COLUMN13, String.valueOf(new Timestamp(System.currentTimeMillis())));
        return dao.addData(ConstantKey.USERS_TABLE_NAME, values);
    }

    //Getting all objects
    protected ArrayList<UsersModel> getUsers(){
        arrayList = new ArrayList<>();
        Cursor cursor = dao.getAllData(ConstantKey.SELECT_USERS_TABLE);
        if(cursor.moveToFirst()){
            do{
                int userId = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ConstantKey.COLUMN_ID)));
                String fullName = cursor.getString(cursor.getColumnIndex(ConstantKey.USERS_COLUMN1));
                String designation = cursor.getString(cursor.getColumnIndex(ConstantKey.USERS_COLUMN2));
                String email = cursor.getString(cursor.getColumnIndex(ConstantKey.USERS_COLUMN3));
                String phoneNumber = cursor.getString(cursor.getColumnIndex(ConstantKey.USERS_COLUMN4));
                String address = cursor.getString(cursor.getColumnIndex(ConstantKey.USERS_COLUMN5));
                String username = cursor.getString(cursor.getColumnIndex(ConstantKey.USERS_COLUMN6));
                String password = cursor.getString(cursor.getColumnIndex(ConstantKey.USERS_COLUMN7));
                String photoName = cursor.getString(cursor.getColumnIndex(ConstantKey.USERS_COLUMN9));
                String photoPath = cursor.getString(cursor.getColumnIndex(ConstantKey.USERS_COLUMN10));

                UsersModel model = new UsersModel(userId,fullName,designation,email,phoneNumber,address,username,password,photoName,photoPath);
                arrayList.add(model);
            }while(cursor.moveToNext());
        }
        return arrayList;
    }

    //Deleting single object
    protected long deleteDataById(String id) {
        return dao.deleteDataById(ConstantKey.USERS_TABLE_NAME, id);
    }

    //Updating single object
    public long updateDataById(UsersModel model, String id) {
        ContentValues values = new ContentValues();
        values.put(ConstantKey.USERS_COLUMN1, model.getFullName());
        values.put(ConstantKey.USERS_COLUMN2, model.getDesignation());
        values.put(ConstantKey.USERS_COLUMN3, model.getEmail());
        values.put(ConstantKey.USERS_COLUMN4, model.getPhoneNumber());
        values.put(ConstantKey.USERS_COLUMN5, model.getAddress());
        values.put(ConstantKey.USERS_COLUMN6, model.getUsername());
        values.put(ConstantKey.USERS_COLUMN7, model.getPassword());
        values.put(ConstantKey.USERS_COLUMN8, "No role");
        values.put(ConstantKey.USERS_COLUMN9, model.getPhotoName());
        values.put(ConstantKey.USERS_COLUMN10, model.getPhotoPath());
        values.put(ConstantKey.USERS_COLUMN11, "");
        values.put(ConstantKey.USERS_COLUMN12, "updated by kamal");
        values.put(ConstantKey.USERS_COLUMN13, String.valueOf(new Timestamp(System.currentTimeMillis())));

        Log.i("updateDataById======= ", id+" "+String.valueOf(model.getFullName()+model.getDesignation()+model.getEmail()+model.getPhoneNumber()+model.getAddress()+model.getUsername()+model.getPassword()+model.getPhotoName()+model.getPhotoPath()) );

        return dao.updateById(ConstantKey.USERS_TABLE_NAME, values, id);
    }
}
