package com.barseghyan_massa.nsi_prospect.db.helper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.barseghyan_massa.nsi_prospect.MyApplication;
import com.barseghyan_massa.nsi_prospect.db.model.Company;
import com.barseghyan_massa.nsi_prospect.db.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserHelper {

    private static final DatabaseHelper db = DatabaseHelper.getInstance();

    private static final String USER_LOG = "CompanyHelper";

    private static final String TABLE_USER = DatabaseHelper.getTableUser();

    //Prospects column names
    private static final String KEY_ID = DatabaseHelper.getKeyId();
    private static final String KEY_CREATED_AT = DatabaseHelper.getKeyCreatedAt();
    private static final String KEY_USER_NAME = DatabaseHelper.getKeyUserName();
    private static final String KEY_USER_LASTNAME = DatabaseHelper.getKeyUserLastname();
    private static final String KEY_USER_PASSWORD = DatabaseHelper.getKeyUserPassword();
    private static final String KEY_USER_PHONE = DatabaseHelper.getKeyUserPhone();
    private static final String KEY_USER_MAIL = DatabaseHelper.getKeyUserMail();



    /*  FIND ALL COMPAGNIES */
    public List<User> find() {
        //Declaration of list to return
        List<User> users = new ArrayList<>();
        //Query to execute
        String queryString = "SELECT * FROM " + TABLE_USER;
        //get db
        SQLiteDatabase db = com.barseghyan_massa.nsi_prospect.db.helper.UserHelper.db.getReadableDatabase();
        //get data in cursor
        try (Cursor cursor = db.rawQuery(queryString, null)) {
            //if cursor has data
            if (cursor.moveToFirst()) {
                do {
                    users.add(new User(cursor.getString(0), cursor.getString(1), cursor.getString(3), cursor.getString(4), cursor.getString(5)));
                } while (cursor.moveToFirst());
            } else {
                //If no result : message
                Toast.makeText(MyApplication.getAppContext(), "No users found", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(MyApplication.getAppContext(), "Query error", Toast.LENGTH_SHORT).show();
            Log.d(USER_LOG, "Error find: " + e);
        }
        db.close();
        return users;
    }

    /*  FIND ONE COMPANY BY ID */
    public Company findOne(int id) {
        //Declaration of list to return
        List<Company> prospects = new ArrayList<>();
        //Query to execute
        String queryString = "SELECT * FROM " + TABLE_USER + " WHERE " + KEY_ID + " = " + id;
        //get db
        SQLiteDatabase db = com.barseghyan_massa.nsi_prospect.db.helper.UserHelper.db.getReadableDatabase();
        //gest data in cursor
        try (Cursor cursor = db.rawQuery(queryString, null)) {
            db.close();
            //if cursor has data
            if (cursor.moveToFirst()) {
                //return Company
                return new Company(cursor.getString(0), cursor.getInt(1));
            } else {
                //If no result : message
                Toast.makeText(MyApplication.getAppContext(), "No user found", Toast.LENGTH_SHORT).show();
                return null;
            }
        } catch (Exception e) {
            Toast.makeText(MyApplication.getAppContext(), "Query error", Toast.LENGTH_SHORT).show();
            Log.d(USER_LOG, "Error findOne: " + e);
            return null;
        }
    }

    /*  INSERT COMPANY   */
    public boolean addOne(User user) {
        SQLiteDatabase db = com.barseghyan_massa.nsi_prospect.db.helper.UserHelper.db.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(KEY_USER_NAME, user.getName());
        cv.put(KEY_USER_LASTNAME, user.getLastname());
        cv.put(KEY_USER_PASSWORD, user.getPassword());
        cv.put(KEY_USER_PHONE, user.getPhone());
        cv.put(KEY_USER_MAIL, user.getMail());
        cv.put(KEY_CREATED_AT, user.getCreatedAt());

        long insert = db.insert(TABLE_USER, null, cv);
        return insert != -1;
    }
}
