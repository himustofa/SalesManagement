package com.sm.demo.salesmanagement.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.sm.demo.salesmanagement.database.ConstantKey;

import java.util.ArrayList;
import java.util.List;

public class MyService {

    private MyDAO dao;
    private List<String> list;

    public MyService(Context context) {
        list = new ArrayList<String>();
        dao = new MyDAO(context);
    }

    public long addTask(MyModel model) {
        final ContentValues values = new ContentValues();
        values.put(ConstantKey.COLUMN2, model.getUserName());
        values.put(ConstantKey.COLUMN3, model.getPassWord());
        return dao.addData(ConstantKey.TABLE_NAME, values);
    }

    public void deleteTask(final String title) {
        dao.deleteData("USER_NAME='" + title + "'");
    }

    public void deleteById(final long id) {
        dao.deleteById("id='" + id + "'");
    }

    public List<String> getTasks() {
        Cursor cursor = dao.getAllData();
        list.clear();
        if (cursor != null) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                list.add(cursor.getString(0));
                cursor.moveToNext();
            }
            cursor.close();
        }
        return list;
    }


}
