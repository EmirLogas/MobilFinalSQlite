package com.example.mobilfinalsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class aes_GorevEkle extends AppCompatActivity {

    EditText aes_GorevEkle_EditTxt_GorevText;
    Spinner aes_GorevEkle_spinner_derece;
    RadioButton aes_GorevEkle_DadioBtn_Hatirlat, aes_GorevEkle_DadioBtn_Hatirlatma;
    CheckBox aes_GorevEkle_CheckBox_Onayliyorum;

    String gelenGorev;
    int gelenOnemDerecesi;
    boolean gelenHatırlat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aes_gorev_ekle);

        aes_GorevEkle_EditTxt_GorevText = findViewById(R.id.aes_GorevEkle_EditTxt_GorevText);
        aes_GorevEkle_spinner_derece = findViewById(R.id.aes_GorevEkle_spinner_derece);
        aes_GorevEkle_DadioBtn_Hatirlat = findViewById(R.id.aes_GorevEkle_DadioBtn_Hatirlat);
        aes_GorevEkle_DadioBtn_Hatirlatma = findViewById(R.id.aes_GorevEkle_DadioBtn_Hatirlatma);
        aes_GorevEkle_CheckBox_Onayliyorum = findViewById(R.id.aes_GorevEkle_CheckBox_Onayliyorum);
    }

    public void AES_GorevEkle_Btn_Back(View view) {
        finish();
    }

    public void aes_GorevEkle_Btn_Ekle(View view) {
        gelenGorev = aes_GorevEkle_EditTxt_GorevText.getText().toString();
        gelenOnemDerecesi = (int) aes_GorevEkle_spinner_derece.getSelectedItem();
        if (aes_GorevEkle_DadioBtn_Hatirlat.isSelected()) {
            gelenHatırlat = true;
        } else {
            gelenHatırlat = false;
        }
        //SQliteDatabase vt = new SQliteDatabase();
        //vt.VeriEkle(gelenGorev, gelenOnemDerecesi, gelenHatırlat);
    }
}