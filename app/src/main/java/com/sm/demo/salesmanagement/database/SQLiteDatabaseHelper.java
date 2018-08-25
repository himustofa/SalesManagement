package com.sm.demo.salesmanagement.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.sm.demo.salesmanagement.users.UsersModel;

import java.sql.Timestamp;

public class SQLiteDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "sales_management";
    private static final int DATABASE_VERSION = 1;

    public SQLiteDatabaseHelper(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //sqLiteDatabase.execSQL(ConstantKey.CREATE_SALES_TABLE);
        sqLiteDatabase.execSQL(ConstantKey.CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //sqLiteDatabase.execSQL(ConstantKey.DROP_SALES_TABLE);
        sqLiteDatabase.execSQL(ConstantKey.DROP_USERS_TABLE);
        onCreate(sqLiteDatabase);
    }

    public long addData(UsersModel model){
        Log.d("Service model ====== : ", String.valueOf(model.getPhotoName())+String.valueOf(model.getFullName()));
        SQLiteDatabase db = this.getWritableDatabase();
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
        values.put(ConstantKey.USERS_COLUMN11, "001");
        values.put(ConstantKey.USERS_COLUMN12, "");
        values.put(ConstantKey.USERS_COLUMN13, String.valueOf(new Timestamp(System.currentTimeMillis())));
        long data = db.insert(ConstantKey.USERS_TABLE_NAME, null, values);
        db.close();
        return data;
    }
}
