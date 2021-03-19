package com.barseghyan_massa.nsi_prospect.db.helper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.barseghyan_massa.nsi_prospect.MyApplication;
import com.barseghyan_massa.nsi_prospect.db.model.Prospect;

import java.util.ArrayList;
import java.util.List;

public class ProspectHelper {
    private static final DatabaseHelper db = DatabaseHelper.getInstance();

    //Common column names
    private static final String KEY_ID = DatabaseHelper.getKeyId();
    private static final String KEY_CREATED_AT = DatabaseHelper.getKeyCreatedAt();

    private static final String TABLE_PROSPECT  = DatabaseHelper.getTableProspect();

    //Prospects column names
    private static final String KEY_PROSPECT_NAME = DatabaseHelper.getKeyProspectName();
    private static final String KEY_PROSPECT_LASTNAME = DatabaseHelper.getKeyProspectLastname();
    private static final String KEY_PROSPECT_PHONE = DatabaseHelper.getKeyProspectPhone();
    private static final String KEY_PROSPECT_MAIL = DatabaseHelper.getKeyProspectMail();
    private static final String KEY_PROSPECT_NOTES = DatabaseHelper.getKeyProspectNotes();


    /*  FIND ALL PROSPECTS */
    public List<Prospect> find(@Nullable String[] filter) {
        //Declaration of list to return
        List<Prospect> prospects = new ArrayList<>();
        //Query to execute
        String queryString = "SELECT * FROM " + TABLE_PROSPECT;
        //get db
        SQLiteDatabase db = this.db.getReadableDatabase();
        //gest data in cursor
        Cursor cursor = db.rawQuery(queryString, filter);
        //if cursor has data
        if (cursor.moveToFirst()) {
            do {
                prospects.add(new Prospect(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5)));
            } while (cursor.moveToFirst());
        } else {
            //If no result : message
            Toast.makeText(MyApplication.getAppContext(), "Aucun prospect trouvé", Toast.LENGTH_SHORT).show();

        }
        db.close();
        return prospects;
    }

    /*  FIND ONE PROSPECT BY ID */
    public Prospect findOne(@NonNull int id) {
        //Declaration of list to return
        List<Prospect> prospects = new ArrayList<>();
        //Query to execute
        String queryString = "SELECT * FROM " + TABLE_PROSPECT
                + " WHERE " + KEY_ID + " = " + id;
        //get db
        SQLiteDatabase db = this.db.getReadableDatabase();
        //gest data in cursor
        Cursor cursor = db.rawQuery(queryString, null);
        db.close();
        //if cursor has data
        if (cursor.moveToFirst()) {
//            return Prospect
            return new Prospect(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5));
        } else {
            //If no result : message
            Toast.makeText(MyApplication.getAppContext(), "Aucun prospect trouvé", Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    /*  INSERT PROSPECT   */
    public boolean addOne(Prospect prospect) {
        SQLiteDatabase db = this.db.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(KEY_PROSPECT_NAME, prospect.getName());
        cv.put(KEY_PROSPECT_LASTNAME, prospect.getLastname());
        cv.put(KEY_PROSPECT_PHONE, prospect.getPhone());
        cv.put(KEY_PROSPECT_MAIL, prospect.getMail());
        cv.put(KEY_PROSPECT_NOTES, prospect.getNotes());

        long insert = db.insert(TABLE_PROSPECT, null, cv);
        return insert != -1;
    }



}
