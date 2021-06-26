package com.example.mobilfinalsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class aes_GorevEkle extends AppCompatActivity {

    public static SQLiteDatabase database;

    ImageView imageView;
    EditText aes_GorevEkle_EditTxt_GorevText;
    Spinner aes_GorevEkle_spinner_derece;
    RadioButton aes_GorevEkle_DadioBtn_Hatirlat, aes_GorevEkle_DadioBtn_Hatirlatma;
    CheckBox aes_GorevEkle_CheckBox_Onayliyorum;

    String gorev;
    int onemDerecesi, hatirlat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aes_gorev_ekle);

        imageView = findViewById(R.id.imageView);
        aes_GorevEkle_EditTxt_GorevText = findViewById(R.id.aes_GorevEkle_EditTxt_GorevText);
        aes_GorevEkle_spinner_derece = findViewById(R.id.aes_GorevEkle_spinner_derece);
        aes_GorevEkle_DadioBtn_Hatirlat = findViewById(R.id.aes_GorevEkle_DadioBtn_Hatirlat);
        aes_GorevEkle_DadioBtn_Hatirlatma = findViewById(R.id.aes_GorevEkle_DadioBtn_Hatirlatma);
        aes_GorevEkle_CheckBox_Onayliyorum = findViewById(R.id.aes_GorevEkle_CheckBox_Onayliyorum);


        try {
            database = openOrCreateDatabase("Gorevler", MODE_PRIVATE, null);
            database.execSQL("CREATE TABLE IF NOT EXISTS Gorevler (resim VARCHAR,gorev VARCHAR, onemDerecesi INTEGER, hatirlat INTEGER)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AES_GorevEkle_Btn_Back(View view) {
        finish();
    }

    public void aes_GorevEkle_Btn_Ekle(View view) {

        BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        String image = Base64.encodeToString(bytes, Base64.DEFAULT);

        gorev = aes_GorevEkle_EditTxt_GorevText.getText().toString();
        onemDerecesi = Integer.parseInt(aes_GorevEkle_spinner_derece.getSelectedItem().toString());
        if (aes_GorevEkle_DadioBtn_Hatirlat.isChecked()) {
            hatirlat = 1;
        }
        else if (aes_GorevEkle_DadioBtn_Hatirlatma.isChecked()) {
            hatirlat = 0;
        }

        try {
            database.execSQL("INSERT INTO Gorevler (resim,gorev,onemDerecesi,hatirlat) VALUES('" + image + "','" + gorev + "'," + onemDerecesi + "," + hatirlat + ")");
            Toast.makeText(getApplicationContext(), "Veri başarıyla eklendi", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent MainActivity = new Intent(this, aes_MainActivity.class);
        startActivity(MainActivity);
    }

    public void imageView(View view) {

        dispatchTakePictureIntent();

    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }
}