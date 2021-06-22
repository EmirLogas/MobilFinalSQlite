package com.example.mobilfinalsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AES_Btn_GorevEkle(View view) {
        Intent aes_GorevEkle = new Intent(this, aes_GorevEkle.class);
        startActivity(aes_GorevEkle);
    }
}