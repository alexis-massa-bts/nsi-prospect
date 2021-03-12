package com.barseghyan_massa.nsi_prospect.db.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class TemplateHelper extends SQLiteOpenHelper {

    public TemplateHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Userdetails(name text primary key, contact text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists Userdetails");
    }

    public boolean insertUser(String name, String contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contact", contact);
        long result = db.insert("Userdetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean updateUser(String name, String contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contact", contact);
        Cursor cursor = db.rawQuery("select * from Userdetails where name = ?", new String[]{name});
        if (cursor.getColumnCount() > 0) {
            long result = db.update("Userdetails", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean deleteUser(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Userdetails where name = ?", new String[]{name});
        if (cursor.getColumnCount() > 0) {
            long result = db.delete("Userdetails", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Userdetails", null);
        return cursor;
    }
}
