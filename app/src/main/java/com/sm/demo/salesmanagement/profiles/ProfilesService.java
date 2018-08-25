package com.sm.demo.salesmanagement.profiles;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.sm.demo.salesmanagement.database.ConstantKey;
import com.sm.demo.salesmanagement.database.SQLiteDAO;

import java.sql.Timestamp;
import java.util.ArrayList;

public class ProfilesService {

    private SQLiteDAO dao;
    private ArrayList<ProfilesModel> arrayList;

    public ProfilesService(Context context) {
        arrayList = new ArrayList<>();
        dao = new SQLiteDAO(context);
    }

    //Adding single object
    public long addData(ProfilesModel model){
        final ContentValues values = new ContentValues();
        values.put(ConstantKey.PROFILES_COLUMN1, model.getCompanyName());
        values.put(ConstantKey.PROFILES_COLUMN2, model.getCompanyEmail());
        values.put(ConstantKey.PROFILES_COLUMN3, model.getCompanyPhoneNumber());
        values.put(ConstantKey.PROFILES_COLUMN4, model.getCompanyAddress());
        values.put(ConstantKey.PROFILES_COLUMN5, model.getCompanyLogoName());
        values.put(ConstantKey.PROFILES_COLUMN6, model.getCompanyLogoPath());
        values.put(ConstantKey.PROFILES_COLUMN12, "001");
        values.put(ConstantKey.PROFILES_COLUMN13, "");
        values.put(ConstantKey.PROFILES_COLUMN14, String.valueOf(new Timestamp(System.currentTimeMillis())));
        return dao.addData(ConstantKey.PROFILES_TABLE_NAME, values);
    }

    //Getting all objects
    public ArrayList<ProfilesModel> getAllData(){
        arrayList = new ArrayList<>();
        Cursor cursor = dao.getAllData(ConstantKey.SELECT_PROFILES_TABLE);
        if(cursor.moveToFirst()){
            do{
                int companyId = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ConstantKey.COLUMN_ID)));
                String companyName = cursor.getString(cursor.getColumnIndex(ConstantKey.PROFILES_COLUMN1));
                String companyEmail = cursor.getString(cursor.getColumnIndex(ConstantKey.PROFILES_COLUMN2));
                String companyPhoneNumber = cursor.getString(cursor.getColumnIndex(ConstantKey.PROFILES_COLUMN3));
                String companyAddress = cursor.getString(cursor.getColumnIndex(ConstantKey.PROFILES_COLUMN4));
                String companyLogoName = cursor.getString(cursor.getColumnIndex(ConstantKey.PROFILES_COLUMN5));
                String companyLogoPath = cursor.getString(cursor.getColumnIndex(ConstantKey.PROFILES_COLUMN6));

                ProfilesModel model = new ProfilesModel(companyId,companyName,companyEmail,companyPhoneNumber,companyAddress,companyLogoName,companyLogoPath);
                arrayList.add(model);
            }while(cursor.moveToNext());
        }
        return arrayList;
    }
    //====| OR |====
    /*public ArrayList<ProfilesModel> getAllProfiles() {
        arrayList = new ArrayList<ProfilesModel>();
        Cursor cursor = dao.getAllData(ConstantKey.SELECT_PROFILES_TABLE);
        if (cursor.moveToFirst()) {
            do {
                ProfilesModel country = new ProfilesModel(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
                arrayList.add(country);
            } while (cursor.moveToNext());
        }
        return arrayList;
    }*/

    //Getting single object
    /*public ProfilesModel getData(int id) {
        Cursor cursor = sqLiteDatabase.query(ConstantKey.PROFILES_TABLE_NAME, new String[] { ConstantKey.COLUMN_ID,ConstantKey.PROFILES_COLUMN1,ConstantKey.PROFILES_COLUMN2,ConstantKey.PROFILES_COLUMN3,ConstantKey.PROFILES_COLUMN4,ConstantKey.PROFILES_COLUMN5,ConstantKey.PROFILES_COLUMN6,ConstantKey.PROFILES_COLUMN7,ConstantKey.PROFILES_COLUMN8,ConstantKey.PROFILES_COLUMN9,ConstantKey.PROFILES_COLUMN10,ConstantKey.PROFILES_COLUMN11,ConstantKey.PROFILES_COLUMN12,ConstantKey.PROFILES_COLUMN13,ConstantKey.PROFILES_COLUMN14}, ConstantKey.COLUMN_ID + "=?", new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        ProfilesModel model = new ProfilesModel(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(12),cursor.getString(13),Timestamp.valueOf(cursor.getString(14)));
        return model;
    }*/

    //Updating single object
    /*public int updateData(ProfilesModel model) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstantKey.PROFILES_COLUMN1, model.getCompanyName());
        values.put(ConstantKey.PROFILES_COLUMN2, model.getCompanyEmail());
        values.put(ConstantKey.PROFILES_COLUMN3, model.getCompanyPhoneNumber());
        values.put(ConstantKey.PROFILES_COLUMN4, model.getCompanyAddress());
        values.put(ConstantKey.PROFILES_COLUMN5, model.getCompanyLogoName());
        values.put(ConstantKey.PROFILES_COLUMN6, model.getCompanyLogoPath());
        values.put(ConstantKey.PROFILES_COLUMN12, "001");
        values.put(ConstantKey.PROFILES_COLUMN13, "");
        values.put(ConstantKey.PROFILES_COLUMN14, String.valueOf(new Timestamp(System.currentTimeMillis())));
        // updating row
        return db.update(ConstantKey.PROFILES_TABLE_NAME, values, ConstantKey.COLUMN_ID + " = ?", new String[] { String.valueOf(model.getCompanyId()) });
    }*/

    //Deleting single object
    public long deleteDataById(String id) {
        return dao.deleteDataById(ConstantKey.PROFILES_TABLE_NAME, id);
    }

    //Deleting all objects
    /*public void deleteAllCountries() {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.delete(ConstantKey.PROFILES_TABLE_NAME,null,null);
        db.close();
    }*/

}



/*
    SQLiteDatabaseHelper databaseHelper;

    public ProfilesService(Context context) {
        databaseHelper = new SQLiteDatabaseHelper(context);
    }

    //Adding single object
    public long addData(ProfilesModel model){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ConstantKey.PROFILES_COLUMN1, model.getCompanyName());
        values.put(ConstantKey.PROFILES_COLUMN2, model.getCompanyEmail());
        values.put(ConstantKey.PROFILES_COLUMN3, model.getCompanyPhoneNumber());
        values.put(ConstantKey.PROFILES_COLUMN4, model.getCompanyAddress());
        values.put(ConstantKey.PROFILES_COLUMN5, model.getCompanyLogoName());
        values.put(ConstantKey.PROFILES_COLUMN6, model.getCompanyLogoPath());
        values.put(ConstantKey.PROFILES_COLUMN12, "001");
        values.put(ConstantKey.PROFILES_COLUMN13, "");
        values.put(ConstantKey.PROFILES_COLUMN14, String.valueOf(new Timestamp(System.currentTimeMillis())));

        long insertRow = db.insert(ConstantKey.PROFILES_TABLE_NAME,null, values);

        db.close();
        return insertRow;
    }

    //Getting all objects
    public ArrayList<ProfilesModel> getAllData(){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        ArrayList<ProfilesModel> arrayList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(ConstantKey.SELECT_PROFILES_TABLE,null);
        if(cursor.moveToFirst()){
            do{
                int companyId = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ConstantKey.COLUMN_ID)));
                String companyName = cursor.getString(cursor.getColumnIndex(ConstantKey.PROFILES_COLUMN1));
                String companyEmail = cursor.getString(cursor.getColumnIndex(ConstantKey.PROFILES_COLUMN2));
                String companyPhoneNumber = cursor.getString(cursor.getColumnIndex(ConstantKey.PROFILES_COLUMN3));
                String companyAddress = cursor.getString(cursor.getColumnIndex(ConstantKey.PROFILES_COLUMN4));
                String companyLogoName = cursor.getString(cursor.getColumnIndex(ConstantKey.PROFILES_COLUMN5));
                String companyLogoPath = cursor.getString(cursor.getColumnIndex(ConstantKey.PROFILES_COLUMN6));
                String createdById = cursor.getString(cursor.getColumnIndex(ConstantKey.PROFILES_COLUMN12));
                String updatedById = cursor.getString(cursor.getColumnIndex(ConstantKey.PROFILES_COLUMN13));
                Timestamp createdAt = Timestamp.valueOf(cursor.getString(cursor.getColumnIndex(ConstantKey.PROFILES_COLUMN14)));

                ProfilesModel model = new ProfilesModel(companyId,companyName,companyEmail,companyPhoneNumber,companyAddress,companyLogoName,companyLogoPath,createdById,updatedById,createdAt);
                arrayList.add(model);
            }while(cursor.moveToNext());
        }
        return arrayList;
    }

    //Getting single object
    public ProfilesModel getData(int id) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(ConstantKey.PROFILES_TABLE_NAME, new String[] { ConstantKey.COLUMN_ID,ConstantKey.PROFILES_COLUMN1,ConstantKey.PROFILES_COLUMN2,ConstantKey.PROFILES_COLUMN3,ConstantKey.PROFILES_COLUMN4,ConstantKey.PROFILES_COLUMN5,ConstantKey.PROFILES_COLUMN6,ConstantKey.PROFILES_COLUMN7,ConstantKey.PROFILES_COLUMN8,ConstantKey.PROFILES_COLUMN9,ConstantKey.PROFILES_COLUMN10,ConstantKey.PROFILES_COLUMN11,ConstantKey.PROFILES_COLUMN12,ConstantKey.PROFILES_COLUMN13,ConstantKey.PROFILES_COLUMN14}, ConstantKey.COLUMN_ID + "=?", new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        ProfilesModel model = new ProfilesModel(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(12),cursor.getString(13),Timestamp.valueOf(cursor.getString(14)));
        return model;
    }

    //Updating single object
    public int updateData(ProfilesModel model) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstantKey.PROFILES_COLUMN1, model.getCompanyName());
        values.put(ConstantKey.PROFILES_COLUMN2, model.getCompanyEmail());
        values.put(ConstantKey.PROFILES_COLUMN3, model.getCompanyPhoneNumber());
        values.put(ConstantKey.PROFILES_COLUMN4, model.getCompanyAddress());
        values.put(ConstantKey.PROFILES_COLUMN5, model.getCompanyLogoName());
        values.put(ConstantKey.PROFILES_COLUMN6, model.getCompanyLogoPath());
        values.put(ConstantKey.PROFILES_COLUMN12, "001");
        values.put(ConstantKey.PROFILES_COLUMN13, "");
        values.put(ConstantKey.PROFILES_COLUMN14, String.valueOf(new Timestamp(System.currentTimeMillis())));
        // updating row
        return db.update(ConstantKey.PROFILES_TABLE_NAME, values, ConstantKey.COLUMN_ID + " = ?", new String[] { String.valueOf(model.getCompanyId()) });
    }

    //Deleting single object
    public void deleteCountry(ProfilesModel model) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.delete(ConstantKey.PROFILES_TABLE_NAME, ConstantKey.COLUMN_ID + " = ?", new String[] { String.valueOf(model.getCompanyId()) });
        db.close();
    }

    //Deleting all objects
    public void deleteAllCountries() {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.delete(ConstantKey.PROFILES_TABLE_NAME,null,null);
        db.close();
    }*/
