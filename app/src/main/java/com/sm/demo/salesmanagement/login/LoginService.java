package com.sm.demo.salesmanagement.login;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.sm.demo.salesmanagement.database.ConstantKey;
import com.sm.demo.salesmanagement.database.SQLiteDAO;
import com.sm.demo.salesmanagement.users.UsersModel;

import java.util.ArrayList;

public class LoginService {

    private SQLiteDAO dao;
    UsersModel usersModel = null;

    protected LoginService(Context context) {
        usersModel = new UsersModel();
        dao = new SQLiteDAO(context);
    }

    protected UsersModel loginByUserPass(String user, String pass) {
        Cursor cursor = dao.getDataByUserPass(user, pass);
        if(cursor.getCount() > 0 && cursor != null) {
            cursor.moveToFirst();
            usersModel = new UsersModel(cursor.getString(cursor.getColumnIndex(ConstantKey.USERS_COLUMN6)), cursor.getString(cursor.getColumnIndex(ConstantKey.USERS_COLUMN7)), cursor.getString(cursor.getColumnIndex(ConstantKey.USERS_COLUMN9)), cursor.getString(cursor.getColumnIndex(ConstantKey.USERS_COLUMN10)));
            if(user.equals(usersModel.getUsername()) && pass.equals(usersModel.getPassword())){
                return usersModel;
            }
        }
        return usersModel;
    }

}
