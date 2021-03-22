package com.barseghyan_massa.nsi_prospect.db.helper;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.barseghyan_massa.nsi_prospect.MainActivity;
import com.barseghyan_massa.nsi_prospect.MyApplication;

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
    private static final String KEY_USER_LOGIN = "login";
    private static final String KEY_USER_PASSWORD = "password";
    private static final String KEY_USER_PHONE = "phone";
    private static final String KEY_USER_MAIL = "mail";

    //Company column names
    private static final String KEY_COMPANY_NAME = "name";
    private static final String KEY_COMPANY_SIRET = "siret";

    //Event column names
    private static final String KEY_EVENT_NAME = "name";
    private static final String KEY_EVENT_LOCATION = "lastname";
    private static final String KEY_EVENT_STARTDATE = "startDate";
    private static final String KEY_EVENT_ENDDATE = "endDate";

    //Prospects column names
    private static final String KEY_PROSPECT_NAME = "name";
    private static final String KEY_PROSPECT_LASTNAME = "lastname";
    private static final String KEY_PROSPECT_PHONE = "phone";
    private static final String KEY_PROSPECT_MAIL = "mail";
    private static final String KEY_PROSPECT_NOTES = "notes";

    //Project column names
    private static final String KEY_PROJECT_WORDING = "wording";
    private static final String KEY_PROJECT_NOTES = "notes";

    //Create table statements
    //User table
    private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + "(" +
            KEY_ID + " INTEGER PRIMARY KEY, " +
            KEY_USER_NAME + " TEXT, " +
            KEY_USER_LASTNAME + " TEXT, " +
            KEY_USER_LOGIN + "TEXT," +
            KEY_USER_PASSWORD + " TEXT, " +
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

    /*==================================Constructor===============================================*/
    private static DatabaseHelper instance = new DatabaseHelper();

    private DatabaseHelper() {
        super(MyApplication.getAppContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHelper getInstance() {
        return instance;
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
    /*====================================Getters=================================================*/

    public static String getLOG() {
        return LOG;
    }

    public static int getDatabaseVersion() {
        return DATABASE_VERSION;
    }

    public static String getDbName() {
        return DATABASE_NAME;
    }

    public static String getTableUser() {
        return TABLE_USER;
    }

    public static String getTableCompany() {
        return TABLE_COMPANY;
    }

    public static String getTableEvent() {
        return TABLE_EVENT;
    }

    public static String getTableProspect() {
        return TABLE_PROSPECT;
    }

    public static String getTableProject() {
        return TABLE_PROJECT;
    }

    public static String getKeyId() {
        return KEY_ID;
    }

    public static String getKeyCreatedAt() {
        return KEY_CREATED_AT;
    }

    public static String getKeyUserName() {
        return KEY_USER_NAME;
    }

    public static String getKeyUserLastname() {
        return KEY_USER_LASTNAME;
    }

    public static String getKeyUserLogin() {
        return KEY_USER_LOGIN;
    }

    public static String getKeyUserPassword() {
        return KEY_USER_PASSWORD;
    }

    public static String getKeyUserPhone() {
        return KEY_USER_PHONE;
    }

    public static String getKeyUserMail() {
        return KEY_USER_MAIL;
    }

    public static String getKeyCompanyName() {
        return KEY_COMPANY_NAME;
    }

    public static String getKeyCompanySiret() {
        return KEY_COMPANY_SIRET;
    }

    public static String getKeyEventName() {
        return KEY_EVENT_NAME;
    }

    public static String getKeyEventLocation() {
        return KEY_EVENT_LOCATION;
    }

    public static String getKeyEventStartdate() {
        return KEY_EVENT_STARTDATE;
    }

    public static String getKeyEventEnddate() {
        return KEY_EVENT_ENDDATE;
    }

    public static String getKeyProspectName() {
        return KEY_PROSPECT_NAME;
    }

    public static String getKeyProspectLastname() {
        return KEY_PROSPECT_LASTNAME;
    }

    public static String getKeyProspectPhone() {
        return KEY_PROSPECT_PHONE;
    }

    public static String getKeyProspectMail() {
        return KEY_PROSPECT_MAIL;
    }

    public static String getKeyProspectNotes() {
        return KEY_PROSPECT_NOTES;
    }

    public static String getKeyProjectWording() {
        return KEY_PROJECT_WORDING;
    }

    public static String getKeyProjectNotes() {
        return KEY_PROJECT_NOTES;
    }

    public static String getCreateTableUser() {
        return CREATE_TABLE_USER;
    }

    public static String getCreateTableCompany() {
        return CREATE_TABLE_COMPANY;
    }

    public static String getCreateTableEvent() {
        return CREATE_TABLE_EVENT;
    }

    public static String getCreateTableProspect() {
        return CREATE_TABLE_PROSPECT;
    }

    public static String getCreateTableProject() {
        return CREATE_TABLE_PROJECT;
    }
}
