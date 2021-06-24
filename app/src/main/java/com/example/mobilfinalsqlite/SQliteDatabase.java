package com.example.mobilfinalsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQliteDatabase extends SQLiteOpenHelper {


    String databaseName = "Görevler";
    int databaseVersion = 1;

    String satır_ID = "id";
    String satır_Gorev;
    int satır_OnemDerecesi;
    boolean satır_Hatirlat;


    public SQliteDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + databaseName + "("
                + satır_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + satır_Gorev + " TEXT NOT NULL, "
                + satır_OnemDerecesi + " INTEGER NOT NULL, "
                + satır_Hatirlat + " TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + databaseName);
        onCreate(db);
    }

    public void VeriEkle(String gorev, int onemDerecesi, boolean hatirlat) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put(satır_Gorev, gorev);
            cv.put(String.valueOf(satır_OnemDerecesi), onemDerecesi);
            cv.put(String.valueOf(satır_Hatirlat), hatirlat);
            db.insert(databaseName, null, cv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close();
    }
}
