package com.barseghyan_massa.nsi_prospect.db.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.barseghyan_massa.nsi_prospect.HomepageActivity;
import com.barseghyan_massa.nsi_prospect.db.model.Prospect;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Logcat tag
    private static final String LOG = "DatabaseHelper";

    //Database version
    private static final int DATABASE_VERSION = 1;

    //Database name
    private static final String DATABASE_NAME = "NSI_DB";

    //Table names
    private static final String TABLE_USER = "user";
    private static final String TABLE_COMPANY = "company";
    private static final String TABLE_EVENT = "event";
    private static final String TABLE_PROSPECT = "prospect";
    private static final String TABLE_PROJECT = "project";

    //Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_AT = "created_at";

    //User column names
    private static final String KEY_USER_NAME = "name";
    private static final String KEY_USER_LASTNAME = "lastname";
    private static final String KEY_USER_PHONE = "phone";
    private static final String KEY_USER_MAIL = "mail";


    //Company
    private static final String KEY_COMPANY_NAME = "name";
    private static final String KEY_COMPANY_SIRET = "siret";

    //Event
    private static final String KEY_EVENT_NAME = "name";
    private static final String KEY_EVENT_LOCATION = "lastname";
    private static final String KEY_EVENT_STARTDATE = "startDate";
    private static final String KEY_EVENT_ENDDATE = "endDate";

    //Prospects
    private static final String KEY_PROSPECT_NAME = "name";
    private static final String KEY_PROSPECT_LASTNAME = "lastname";
    private static final String KEY_PROSPECT_PHONE = "phone";
    private static final String KEY_PROSPECT_MAIL = "mail";
    private static final String KEY_PROSPECT_NOTES = "notes";

    //Project
    private static final String KEY_PROJECT_WORDING = "wording";
    private static final String KEY_PROJECT_NOTES = "notes";

    //Create table statements
    //User table
    private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + "(" +
            KEY_ID + " INTEGER PRIMARY KEY, " +
            KEY_USER_NAME + " TEXT, " +
            KEY_USER_LASTNAME + " TEXT, " +
            KEY_USER_MAIL + " TEXT, " +
            KEY_USER_PHONE + " TEXT, " +
            KEY_CREATED_AT + " DATETIME);";

    //Company table
    private static final String CREATE_TABLE_COMPANY = "CREATE TABLE " + TABLE_COMPANY + "(" +
            KEY_ID + " INTEGER PRIMARY KEY, " +
            KEY_COMPANY_NAME + " TEXT, " +
            KEY_COMPANY_SIRET + " INTEGER, " +
            KEY_CREATED_AT + " DATETIME);";

    //Project table
    private static final String CREATE_TABLE_EVENT = "CREATE TABLE " + TABLE_EVENT + "(" +
            KEY_ID + " INTEGER PRIMARY KEY, " +
            KEY_EVENT_NAME + " TEXT, " +
            KEY_EVENT_LOCATION + " TEXT, " +
            KEY_EVENT_STARTDATE + " DATETIME, " +
            KEY_EVENT_ENDDATE + " DATETIME, " +
            KEY_CREATED_AT + " DATETIME);";

    //Event table
    private static final String CREATE_TABLE_PROSPECT = "CREATE TABLE " + TABLE_PROSPECT + "(" +
            KEY_ID + " INTEGER PRIMARY KEY, " +
            KEY_PROSPECT_NAME + " TEXT, " +
            KEY_PROSPECT_LASTNAME + " TEXT, " +
            KEY_PROSPECT_PHONE + " TEXT, " +
            KEY_PROSPECT_MAIL + " TEXT, " +
            KEY_PROSPECT_NOTES + " TEXT, " +
            KEY_CREATED_AT + " DATETIME);";

    //Project table
    private static final String CREATE_TABLE_PROJECT = "CREATE TABLE " + TABLE_PROJECT + "(" +
            KEY_ID + " INTEGER PRIMARY KEY, " +
            KEY_PROJECT_WORDING + " TEXT, " +
            KEY_PROJECT_NOTES + " TEXT, " +
            KEY_CREATED_AT + " DATETIME);";

    //Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create tables
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_COMPANY);
        db.execSQL(CREATE_TABLE_EVENT);
        db.execSQL(CREATE_TABLE_PROSPECT);
        db.execSQL(CREATE_TABLE_PROJECT);

        //TODO : Hard-coded importsit
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPANY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROSPECT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROJECT);

        //Create new tables
        onCreate(db);
    }

    /*====================================Methods=================================================*/
    /*  FIND PROSPECT FILTER */
    public List<Prospect> findProspect(@Nullable String filter[]) {
        //Declaration of list to return
        List<Prospect> prospects = new ArrayList<>();
        //Query to execute
        String queryString = "SELECT * FROM " + TABLE_PROSPECT
                + " WHERE " + KEY_PROSPECT_NAME + " LIKE ? AND "
                + KEY_PROSPECT_LASTNAME + " LIKE ? AND "
                + KEY_PROSPECT_PHONE + " LIKE ? AND "
                + KEY_PROSPECT_MAIL + " LIKE ? AND  "
                + KEY_PROSPECT_NOTES + " LIKE ? ";
        //get db
        SQLiteDatabase db = this.getReadableDatabase();
        //gest data in cursor
        Cursor cursor = db.rawQuery(queryString, filter);
        //if cursor has data
        if (cursor.moveToFirst()) {
            do {
                prospects.add(new Prospect(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)));
            } while (cursor.moveToFirst());
        } else {
            //If no result : nothing added (empty list)
        }
        db.close();
        return prospects;
    }

    /*  FIND ONE PROSPECT BY ID */
    public Prospect findOneProspect(@Nullable int id) {
        //Declaration of list to return
        List<Prospect> prospects = new ArrayList<>();
        //Query to execute
        String queryString = "SELECT * FROM " + TABLE_PROSPECT
                + " WHERE " + KEY_PROSPECT_NAME + " = " + id;
        //get db
        SQLiteDatabase db = this.getReadableDatabase();
        //gest data in cursor
        Cursor cursor = db.rawQuery(queryString, null);
        db.close();
        //if cursor has data
        if (cursor.moveToFirst()) {
            return new Prospect(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
        } else {
            //If no result : nothing added (empty list)
            return new Prospect();
        }

    }

    /*  INSERT PROSPECT   */
    public boolean addOne(Prospect prospect) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(KEY_PROSPECT_NAME, prospect.getName());
        cv.put(KEY_PROSPECT_LASTNAME, prospect.getLastname());

        long insert = db.insert(TABLE_PROSPECT, null, cv);
        return insert != -1;
    }

}
