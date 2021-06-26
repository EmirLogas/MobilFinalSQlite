package com.example.mobilfinalsqlite;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class aes_GorevListAdapter extends ArrayAdapter<aes_Gorev> {

    private static final String TAG = "PersonListAdapter";
    private Context aes_mContext;
    int aes_mResource;

    public aes_GorevListAdapter(Context context, int resource, ArrayList<aes_Gorev> objects) {
        super(context, resource, objects);
        aes_mContext = context;
        aes_mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String aes_resim = getItem(position).getAes_resim();
        String aes_gorev = getItem(position).getAes_gorev();
        int aes_onemDerecesi = getItem(position).getAes_onemDerecesi();
        int aes_hatirlat = getItem(position).getAes_hatirlat();

        aes_Gorev aesGorev1 = new aes_Gorev(aes_resim, aes_gorev, aes_onemDerecesi, aes_hatirlat);

        LayoutInflater inflater = LayoutInflater.from(aes_mContext);
        convertView = inflater.inflate(aes_mResource, parent, false);

        ImageView aes_tvimage = convertView.findViewById(R.id.imageView2);
        TextView aes_tvgorev = convertView.findViewById(R.id.textView2);
        TextView aes_tvonemDerecesi = convertView.findViewById(R.id.textView6);
        TextView aes_tvhatirlat = convertView.findViewById(R.id.textView7);


        byte[] aes_pic = Base64.decode(aes_resim, Base64.DEFAULT);
        Bitmap bmp = BitmapFactory.decodeByteArray(aes_pic, 0, aes_pic.length);
        aes_tvimage.setImageBitmap(bmp);

        aes_tvgorev.setText(aes_gorev);
        aes_tvonemDerecesi.setText("Önem Derecesi : " + aes_onemDerecesi);
        if (aes_hatirlat == 0) {
            aes_tvhatirlat.setText("Hatırlatma : " + "Kapalı");
        } else if (aes_hatirlat == 1) {
            aes_tvhatirlat.setText("Hatırlatma : " + "Açık");
        }


        return convertView;
    }
}
