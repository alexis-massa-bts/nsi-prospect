package com.barseghyan_massa.nsi_prospect.db.helper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.barseghyan_massa.nsi_prospect.MyApplication;
import com.barseghyan_massa.nsi_prospect.db.model.Company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class CompanyHelper {

    private static final DatabaseHelper db = DatabaseHelper.getInstance();

    private static final String COMPANY_LOG = "CompanyHelper";

    private static final String TABLE_COMPANY = DatabaseHelper.getTableCompany();

    //Prospects column names
    private static final String KEY_ID = DatabaseHelper.getKeyId();
    private static final String KEY_CREATED_AT = DatabaseHelper.getKeyCreatedAt();
    private static final String KEY_COMPANY_NAME = DatabaseHelper.getKeyCompanyName();
    private static final String KEY_COMPANY_SIRET = DatabaseHelper.getKeyCompanySiret();

    /*  FIND ALL COMPAGNIES */
    public static List<Company> find() {
        //Declaration of list to return
        List<Company> compagnies = new ArrayList<>();
        //Query to execute
        String queryString = "SELECT * FROM " + TABLE_COMPANY;
        //get db
        SQLiteDatabase db = CompanyHelper.db.getReadableDatabase();
        //get data in cursor
        try (Cursor cursor = db.rawQuery(queryString, null)) {
            //if cursor has data
            if (cursor.moveToFirst()) {
                do {
                    compagnies.add(new Company(cursor.getString(1), cursor.getInt(2)));
                } while (cursor.moveToNext());
            } else {
                //If no result : message
                Toast.makeText(MyApplication.getAppContext(), "No companies found", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(MyApplication.getAppContext(), "Query error", Toast.LENGTH_SHORT).show();
            Log.d(COMPANY_LOG, "Error find: " + e);
        }
        db.close();
        return compagnies;
    }

    /*  FIND ONE COMPANY BY ID */
    public static Company findOne(int siret) {
        //Declaration of list to return
        List<Company> prospects = new ArrayList<>();
        //Query to execute
        String queryString = "SELECT * FROM " + TABLE_COMPANY + " WHERE " + KEY_COMPANY_SIRET + " = " + siret;
        //get db
        SQLiteDatabase db = CompanyHelper.db.getReadableDatabase();
        //gest data in cursor
        try (Cursor cursor = db.rawQuery(queryString, null)) {
            //if cursor has data
            if (cursor.moveToFirst()) {
                //return Company
                return new Company(cursor.getString(1), cursor.getInt(2));
            } else {
                //If no result : message
                Toast.makeText(MyApplication.getAppContext(), "No company found", Toast.LENGTH_SHORT).show();
                return null;
            }
        } catch (Exception e) {
            Toast.makeText(MyApplication.getAppContext(), "Query error", Toast.LENGTH_SHORT).show();
            Log.d(COMPANY_LOG, "Error findOne: " + e);
            db.close();
            return null;
        }
    }

    /*  INSERT COMPANY   */
    public boolean addOne(Company company) {
        SQLiteDatabase db = CompanyHelper.db.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(KEY_COMPANY_NAME, company.getName());
        cv.put(KEY_COMPANY_SIRET, company.getSiret());
        cv.put(KEY_CREATED_AT, company.getCreatedAt());

        long insert = db.insert(TABLE_COMPANY, null, cv);
        return insert != -1;
    }
}