package com.example.mobilfinalsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "MainActivity";

    ListView aes_Main_ListView;
    SQLiteDatabase database;

    public static ArrayList<String> listItems = new ArrayList<String>();

    ArrayList<Gorev> gorevList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started.");


        aes_Main_ListView = findViewById(R.id.aes_Main_ListView);
        database = aes_GorevEkle.database;


        try {
            database = openOrCreateDatabase("Gorevler", MODE_PRIVATE, null);
            database.execSQL("CREATE TABLE IF NOT EXISTS Gorevler (gorev VARCHAR, onemDerecesi INTEGER, hatirlat INTEGER)");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Listele();

        GorevListAdapter adapter = new GorevListAdapter(this,R.layout.listviewrow,gorevList);
        aes_Main_ListView.setAdapter(adapter);

    }

    public void AES_Btn_GorevEkle(View view) {
        Intent aes_GorevEkle = new Intent(this, aes_GorevEkle.class);
        startActivity(aes_GorevEkle);
    }

    public void Listele() {
        try {
            aes_GorevEkle.database = openOrCreateDatabase("Gorevler", MODE_PRIVATE, null);
            aes_GorevEkle.database.execSQL("CREATE TABLE IF NOT EXISTS Gorevler (gorev VARCHAR, onemDerecesi INTEGER, hatirlat INTEGER)");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Cursor cursor = aes_GorevEkle.database.rawQuery("SELECT * FROM Gorevler", null);

        int gorevIndex = cursor.getColumnIndex("gorev");
        int onemDerecesiIndex = cursor.getColumnIndex("onemDerecesi");
        int hatirlatIndex = cursor.getColumnIndex("hatirlat");

        while (cursor.moveToNext()) {
            Gorev gorev = new Gorev(cursor.getString(gorevIndex), cursor.getInt(onemDerecesiIndex), cursor.getInt(hatirlatIndex));
            gorevList.add(gorev);
        }
        cursor.close();
    }
}