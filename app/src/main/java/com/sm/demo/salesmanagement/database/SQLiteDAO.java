package com.sm.demo.salesmanagement.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class SQLiteDAO {

    private static final String DATABASE_NAME = "sales_management";
    private static final int DATABASE_VERSION = 1;

    private final SQLiteDatabase database;
    private final SQLiteOpenHelper helper;

    public SQLiteDAO(final Context context) {
        this.helper = new SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
            @Override
            public void onCreate(final SQLiteDatabase db) {
                db.execSQL(ConstantKey.CREATE_PROFILES_TABLE);
            }
            @Override
            public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
                db.execSQL(ConstantKey.DROP_PROFILES_TABLE);
                this.onCreate(db);
            }
        };
        this.database = this.helper.getWritableDatabase();
    }

    public long addData(String tableName, ContentValues values) {
        long data = this.database.insert(tableName, null, values);
        //this.database.close();
        return data;
    }

    public long deleteById(String tableName, final String id) {
        long data = this.database.delete(tableName, id, null);
        //this.database.close();
        return data;
    }

    public long deleteDataById(String tableName, final String id) {
        long data = this.database.delete(tableName, ConstantKey.COLUMN_ID + " = ?", new String[] { String.valueOf(id) });
        //this.database.close();
        return data;
    }

    public Cursor getAllData(String query) {
        final Cursor cursor = this.database.rawQuery(query,null);
        //this.database.close();
        return cursor;
    }

}
