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
    private static final String TABLE_COMPANY = DatabaseHelper.getTableCompany();

    //Prospects column names
    private static final String KEY_ID = DatabaseHelper.getKeyId();
    private static final String KEY_CREATED_AT = DatabaseHelper.getKeyCreatedAt();
    private static final String KEY_PROSPECT_NAME = DatabaseHelper.getKeyProspectName();
    private static final String KEY_PROSPECT_LASTNAME = DatabaseHelper.getKeyProspectLastname();
    private static final String KEY_PROSPECT_PHONE = DatabaseHelper.getKeyProspectPhone();
    private static final String KEY_PROSPECT_MAIL = DatabaseHelper.getKeyProspectMail();
    private static final String KEY_PROSPECT_NOTES = DatabaseHelper.getKeyProspectNotes();
    private static final String KEY_PROSPECT_COMPANY = DatabaseHelper.getKeyProspectCompany();


    /**
     * FIND ALL PROSPECTS
     *
     * @return List of Prospect
     */
    public static List<Prospect> find() {
        //Declaration of list to return
        List<Prospect> prospects = new ArrayList<>();
        //Query to execute
        String queryStringP = "SELECT * FROM " + TABLE_PROSPECT;
        //get db
        SQLiteDatabase db = ProspectHelper.db.getReadableDatabase();
        //get data in cursor
        try (Cursor cursorP = db.rawQuery(queryStringP, null)) {
            //if cursor has data
            if (cursorP.moveToFirst()) {
                do {
                    Prospect nProspect = new Prospect(cursorP.getString(1), cursorP.getString(2), cursorP.getString(3), cursorP.getString(4), cursorP.getString(5));
                    nProspect.setCompany(CompanyHelper.findOne(cursorP.getInt(6)));
                    prospects.add(nProspect);
                } while (cursorP.moveToNext());
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

    /**
     * FIND ONE PROSPECT BY ID
     *
     * @param id : Prospect to find id
     * @return Prospect (null is not found)
     */
    public Prospect findOne(int id) {
        //Query to execute
        String queryString = "SELECT * FROM " + TABLE_PROSPECT
                + " WHERE " + KEY_ID + " = " + id;
        //get db
        SQLiteDatabase db = ProspectHelper.db.getReadableDatabase();
        //get data in cursor
        try (Cursor cursor = db.rawQuery(queryString, null)) {
            db.close();
            //if cursor has data
            if (cursor.moveToFirst()) {
                //return Prospect
                return new Prospect(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
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

    /**
     * INSERT PROSPECT
     *
     * @param prospect : Prospect to insert
     * @return boolean
     */
    public static boolean addOne(Prospect prospect) {
//        Get db
        SQLiteDatabase db = ProspectHelper.db.getWritableDatabase();

//        Values to insert : key - value
        ContentValues cv = new ContentValues();
        cv.put(KEY_PROSPECT_NAME, prospect.getName());
        cv.put(KEY_PROSPECT_LASTNAME, prospect.getLastname());
        cv.put(KEY_PROSPECT_PHONE, prospect.getPhone());
        cv.put(KEY_PROSPECT_MAIL, prospect.getMail());
        cv.put(KEY_PROSPECT_NOTES, prospect.getNotes());
        cv.put(KEY_CREATED_AT, prospect.getCreatedAt());

//       Query returns long
        long insert = db.insert(TABLE_PROSPECT, null, cv);
        return insert != -1;
    }

    /**
     * UPDATE PROSPECT
     *
     * @param oldProspect : Prospect to update
     * @param newProspect : Propect updated
     * @return boolean
     */
    public static boolean update(Prospect oldProspect, Prospect newProspect) {
//      Get db
        SQLiteDatabase db = ProspectHelper.db.getWritableDatabase();

        //      Values to insert : key - value
        ContentValues cv = new ContentValues();
        cv.put(KEY_PROSPECT_NAME, newProspect.getName());
        cv.put(KEY_PROSPECT_LASTNAME, newProspect.getLastname());
        cv.put(KEY_PROSPECT_PHONE, newProspect.getPhone());
        cv.put(KEY_PROSPECT_MAIL, newProspect.getMail());
        cv.put(KEY_PROSPECT_NOTES, newProspect.getNotes());
        cv.put(KEY_CREATED_AT, newProspect.getCreatedAt());

//      Where clause
        String whereClause = ""
                + KEY_PROSPECT_NAME + "= ? AND "
                + KEY_PROSPECT_LASTNAME + "= ? AND "
                + KEY_PROSPECT_PHONE + "= ? AND "
                + KEY_PROSPECT_MAIL + "= ? AND "
                + KEY_PROSPECT_NOTES + "= ? AND "
                + KEY_CREATED_AT + "= ? ;";


//      Where arguments
        String[] whereArgs = new String[]{oldProspect.getName(), oldProspect.getLastname(), oldProspect.getPhone(), oldProspect.getMail(), oldProspect.getNotes(), oldProspect.getCreatedAt()};



//      Query returns long
        long updated = db.update(TABLE_PROSPECT, cv, whereClause, whereArgs);
        return updated != -1;
    }
}