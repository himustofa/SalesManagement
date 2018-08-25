package com.sm.demo.salesmanagement.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public final class SQLiteDAO {

    private static final String DATABASE_NAME = "sales_management";
    private static final int DATABASE_VERSION = 1; //After table creating and column adding then must be increment database version

    private final SQLiteDatabase database;
    private final SQLiteOpenHelper helper;

    public SQLiteDAO(final Context context) {
        this.helper = new SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
            @Override
            public void onCreate(final SQLiteDatabase db) {
                db.execSQL(ConstantKey.CREATE_PROFILES_TABLE);
                db.execSQL(ConstantKey.CREATE_USERS_TABLE);
                db.execSQL(ConstantKey.CREATE_LOGIN_TABLE);
                db.execSQL(ConstantKey.INSERT_ADMIN_DATA);
            }
            @Override
            public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
                db.execSQL(ConstantKey.DROP_PROFILES_TABLE);
                db.execSQL(ConstantKey.DROP_USERS_TABLE);
                db.execSQL(ConstantKey.DROP_LOGIN_TABLE);
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

    public long updateById(String tableName, ContentValues values, String id) {
        long data = this.database.update(tableName, values, ConstantKey.COLUMN_ID + " = ?", new String[] { String.valueOf(id) });
        //this.database.close();
        return data;
    }

    public Cursor getDataByUserPass(String userName, String passWord) {
        Cursor cursor = this.database.rawQuery("SELECT * FROM " + ConstantKey.USERS_TABLE_NAME + " WHERE " + ConstantKey.USERS_COLUMN6 + "=? AND " + ConstantKey.USERS_COLUMN7 + "=?", new String[] {userName, passWord});
        //SELECT username, password FROM login_table WHERE username=userName AND password=passWord
        //final Cursor cursor = this.database.query(ConstantKey.LOGIN_TABLE_NAME, new String[]{"id, username, password"}, "username=? AND password=?", new String[]{userName, passWord}, null, null, null);
        //this.database.close();
        return cursor;
    }

}
