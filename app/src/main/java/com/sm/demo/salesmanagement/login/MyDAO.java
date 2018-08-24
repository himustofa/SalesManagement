package com.sm.demo.salesmanagement.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.sm.demo.salesmanagement.database.ConstantKey;

public final class MyDAO {

    private static final String DATABASE_NAME = "MY_DATABASE";
    private static final int DATABASE_VERSION = 1;

    private final SQLiteDatabase database;
    private final SQLiteOpenHelper helper;

    public MyDAO(final Context context) {
        this.helper = new SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
            @Override
            public void onCreate(final SQLiteDatabase db) {
                db.execSQL(ConstantKey.CREATE_TABLE_QUERY);
            }
            @Override
            public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
                db.execSQL(ConstantKey.DROP_TABLE);
                this.onCreate(db);
            }
        };
        this.database = this.helper.getWritableDatabase();
    }

    public long addData(String tableName, ContentValues values) {
        return this.database.insert(tableName, null, values);
    }

    public void deleteData(final String field_params) {
        this.database.delete(ConstantKey.TABLE_NAME, field_params, null);
    }

    public void deleteById(final String id) {
        this.database.delete(ConstantKey.TABLE_NAME, id, null);
    }

    public Cursor getAllData() {
        final Cursor cursor = this.database.query(ConstantKey.TABLE_NAME, new String[]{"USER_NAME"}, null, null, null, null, null);
        return cursor;
    }

}
