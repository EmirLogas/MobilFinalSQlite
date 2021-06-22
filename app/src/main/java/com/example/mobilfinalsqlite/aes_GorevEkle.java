package com.example.mobilfinalsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class aes_GorevEkle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aes_gorev_ekle);
    }

    public void AES_GorevEkle_Btn_Back(View view) {
        finish();
    }
}