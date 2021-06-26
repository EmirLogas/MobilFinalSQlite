package com.example.mobilfinalsqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class aes_MainActivity extends AppCompatActivity {

    static final String TAG = "MainActivity";

    ListView aes_Main_ListView;
    SQLiteDatabase aes_database;

    public static ArrayList<String> aes_listItems = new ArrayList<String>();

    ArrayList<aes_Gorev> aes_GorevList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started.");


        aes_Main_ListView = findViewById(R.id.aes_Main_ListView);
        aes_database = aes_GorevEkle.database;

        try {
            aes_database = openOrCreateDatabase("Gorevler", MODE_PRIVATE, null);
            aes_database.execSQL("CREATE TABLE IF NOT EXISTS Gorevler (resim VARCHAR,gorev VARCHAR, onemDerecesi INTEGER, hatirlat INTEGER)");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Listele();

        aes_GorevListAdapter adapter = new aes_GorevListAdapter(this, R.layout.listviewrow, aes_GorevList);
        aes_Main_ListView.setAdapter(adapter);

    }

    public void AES_Btn_GorevEkle(View view) {
        Intent aes_GorevEkle = new Intent(this, aes_GorevEkle.class);
        startActivity(aes_GorevEkle);
    }

    public void Listele() {
        Cursor cursor = aes_database.rawQuery("SELECT * FROM Gorevler", null);

        int aes_resimIndex = cursor.getColumnIndex("resim");
        int aes_gorevIndex = cursor.getColumnIndex("gorev");
        int aes_onemDerecesiIndex = cursor.getColumnIndex("onemDerecesi");
        int aes_hatirlatIndex = cursor.getColumnIndex("hatirlat");

        while (cursor.moveToNext()) {
            aes_Gorev aesGorev = new aes_Gorev(cursor.getString(aes_resimIndex), cursor.getString(aes_gorevIndex), cursor.getInt(aes_onemDerecesiIndex), cursor.getInt(aes_hatirlatIndex));
            aes_GorevList.add(aesGorev);
        }
        cursor.close();
    }
}