package com.barseghyan_massa.nsi_prospect.db.helper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.barseghyan_massa.nsi_prospect.MyApplication;
import com.barseghyan_massa.nsi_prospect.db.model.Prospect;

import java.util.ArrayList;
import java.util.List;

public class ProspectHelper {
    private static final DatabaseHelper db = DatabaseHelper.getInstance();

    private static final String PROSPECT_LOG = "ProspectHelper";

    private static final String TABLE_PROSPECT = DatabaseHelper.getTableProspect();

    //Prospects column names
    private static final String KEY_ID = DatabaseHelper.getKeyId();
    private static final String KEY_CREATED_AT = DatabaseHelper.getKeyCreatedAt();
    private static final String KEY_PROSPECT_NAME = DatabaseHelper.getKeyProspectName();
    private static final String KEY_PROSPECT_LASTNAME = DatabaseHelper.getKeyProspectLastname();
    private static final String KEY_PROSPECT_PHONE = DatabaseHelper.getKeyProspectPhone();
    private static final String KEY_PROSPECT_MAIL = DatabaseHelper.getKeyProspectMail();
    private static final String KEY_PROSPECT_NOTES = DatabaseHelper.getKeyProspectNotes();


    /*  FIND ALL PROSPECTS */
    public List<Prospect> find() {
        //Declaration of list to return
        List<Prospect> prospects = new ArrayList<>();
        //Query to execute
        String queryString = "SELECT * FROM " + TABLE_PROSPECT;
        //get db
        SQLiteDatabase db = ProspectHelper.db.getReadableDatabase();
        //get data in cursor
        try (Cursor cursor = db.rawQuery(queryString, null)) {
            //if cursor has data
            if (cursor.moveToFirst()) {
                do {
                    prospects.add(new Prospect(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5)));
                } while (cursor.moveToNext());
            } else {
                //If no result : message
                Toast.makeText(MyApplication.getAppContext(), "Aucun prospect trouvé", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(MyApplication.getAppContext(), "Erreur requête", Toast.LENGTH_SHORT).show();
            Log.d(PROSPECT_LOG, "Erreur find: " + e);
        }
        db.close();
        return prospects;
    }

    /*  FIND ONE PROSPECT BY ID */
    public Prospect findOne(int id) {
        //Declaration of list to return
        List<Prospect> prospects = new ArrayList<>();
        //Query to execute
        String queryString = "SELECT * FROM " + TABLE_PROSPECT
                + " WHERE " + KEY_ID + " = " + id;
        //get db
        SQLiteDatabase db = ProspectHelper.db.getReadableDatabase();
        //gest data in cursor
        try (Cursor cursor = db.rawQuery(queryString, null)) {
            db.close();
            //if cursor has data
            if (cursor.moveToFirst()) {
                //return Prospect
                return new Prospect(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5));
            } else {
                //If no result : message
                Toast.makeText(MyApplication.getAppContext(), "Aucun prospect trouvé", Toast.LENGTH_SHORT).show();
                return null;
            }
        } catch (Exception e) {
            Toast.makeText(MyApplication.getAppContext(), "Erreur requête", Toast.LENGTH_SHORT).show();
            Log.d(PROSPECT_LOG, "Erreur findOne: " + e);
            return null;
        }
    }

    /*  INSERT PROSPECT   */
    public boolean addOne(Prospect prospect) {
        SQLiteDatabase db = ProspectHelper.db.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(KEY_PROSPECT_NAME, prospect.getName());
        cv.put(KEY_PROSPECT_LASTNAME, prospect.getLastname());
        cv.put(KEY_PROSPECT_PHONE, prospect.getPhone());
        cv.put(KEY_PROSPECT_MAIL, prospect.getMail());
        cv.put(KEY_PROSPECT_NOTES, prospect.getNotes());
        cv.put(KEY_CREATED_AT, prospect.getCreatedAat());

        long insert = db.insert(TABLE_PROSPECT, null, cv);
        return insert != -1;
    }
}