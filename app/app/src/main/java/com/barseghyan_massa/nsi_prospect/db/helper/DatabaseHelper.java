package com.barseghyan_massa.nsi_prospect.db.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    public DatabaseHelper(Context context){
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

        //TODO : Hard-coded imports
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
}
