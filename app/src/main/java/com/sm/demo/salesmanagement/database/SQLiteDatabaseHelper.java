package com.sm.demo.salesmanagement.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "sales_management";
    private static final int DATABASE_VERSION = 1;

    public SQLiteDatabaseHelper(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ConstantKey.CREATE_SALES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(ConstantKey.DROP_SALES_TABLE);
        onCreate(sqLiteDatabase);
    }
}
